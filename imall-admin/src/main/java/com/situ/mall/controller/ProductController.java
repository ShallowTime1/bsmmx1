package com.situ.mall.controller;

import com.situ.mall.pojo.Product;
import com.situ.mall.service.IProductService;
import com.situ.mall.util.JSONResult;
import com.situ.mall.util.LayUITableJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @ResponseBody
    @RequestMapping("/selectById")
    public Product selectById(Integer id){
        return productService.selectById(id);
    }

    @RequestMapping("/getProductListPage")
    public String getProductListPage() {
        return "product_list";
    }

    @ResponseBody
    @RequestMapping("/selectByPage")
    public LayUITableJSONResult selectByPage(Integer page, Integer limit) {
        return productService.selectByPage(page, limit);
    }

    @RequestMapping("/getProductAddPage")
    public String getProductAddPage() {
        return "product_add";
    }

    @ResponseBody
    @RequestMapping("/add")
    public JSONResult add(Product product) {
        return productService.add(product);
    }

}
