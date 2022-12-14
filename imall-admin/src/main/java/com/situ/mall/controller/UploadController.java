package com.situ.mall.controller;


import com.situ.mall.constant.RedisConstant;
import com.situ.mall.util.ImageServerUtil;
import com.situ.mall.util.JSONResult;
import com.situ.mall.util.QiniuUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private RedisTemplate redisTemplate;

    @ResponseBody
    @RequestMapping("/uploadImage")
    public JSONResult uploadImage(MultipartFile file) {
        String name = UUID.randomUUID().toString().replace("-", "");
        String fileName = file.getOriginalFilename();
        String extension = FilenameUtils.getExtension(fileName);
        String newFileName = name + "." + extension;
        if (ImageServerUtil.IMG_SERVER == ImageServerUtil.LOCAL) {
            String filePath = "F:\\mypic\\" + newFileName;
            try {
                file.transferTo(new File(filePath));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            try {
                QiniuUtils.upload2Qiniu(file.getBytes(), newFileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        redisTemplate.opsForSet().add(RedisConstant.UPLOAD_IMAGE,newFileName);
        System.out.println("上传成功：" + newFileName);

        return JSONResult.ok("上传成功",newFileName);
    }
}
