package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping("/product")
    public String index(Model model){
        List<Product> lsProduct = productService.getAll();
        model.addAttribute("lsProduct",lsProduct);
        return "/product/indexProduct";
    }

    @RequestMapping("/product/add")
    public String addRole(Model model){
        model.addAttribute("product",new Product());
        return "/product/addProduct";
    }

    @RequestMapping(value = "/product/save",method = RequestMethod.POST)
    public String save(@Validated @ModelAttribute("product") Product product, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/product/addProduct";
        }
        else {
            productService.saveProduct(product);
            return "redirect:/product";
        }
    }

    @RequestMapping("/product/edit")
    public String editProduct(@RequestParam("id") int productId, Model model){
        Optional<Product> productEdit = productService.findProductById(productId);
        productEdit.ifPresent(product->model.addAttribute("product",product));
        return "/product/editProduct";
    }

    @RequestMapping("/product/delete")
    public String deleteProduct(@RequestParam("id") int productId, Model model){
        productService.deleteProduct(productId);
        return "redirect:/product";
    }
}
