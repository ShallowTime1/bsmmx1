package com.situ.mall.job;


import com.situ.mall.constant.RedisConstant;
import com.situ.mall.util.QiniuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Set;

@Configuration
public class DeleteImageJob {

    @Autowired
    private RedisTemplate redisTemplate;

    @Scheduled(cron = "0 */1 * * * ?")
    public void deleteImage() {
        System.out.println("DeleteImageJob.deleteImage");

        Set<String> set = redisTemplate.opsForSet().difference(RedisConstant.UPLOAD_IMAGE, RedisConstant.UPLOAD_IMAGE_TO_DB);
        if(set != null) {
            for (String imageName : set) {
                QiniuUtils.deleteFileFromQiniu(imageName);
                redisTemplate.opsForSet().remove(RedisConstant.UPLOAD_IMAGE, imageName);
                System.out.println("删除图片：" + imageName);
            }
        }
    }
}
