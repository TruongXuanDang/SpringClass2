package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String index(Model model){
        List<User> lsUser = userService.getAll();
        model.addAttribute("lsUser",lsUser);
        return "/landingpage/indexProduct";
    }

    @RequestMapping("/user/rooms")
    public String rooms(Model model){
        List<Product> lsProduct = productService.getAll();
        model.addAttribute("lsProduct",lsProduct);
        return "/landingpage/rooms";
    }

    @RequestMapping("/ajax")
    public String ajax(Model model) {

        return "ajax";
    }

//    @RequestMapping("/add")
//    public String addRole(Model model){
//        model.addAttribute("role",new Role());
//        return "addRole";
//    }
//
//    @RequestMapping(value = "save",method = RequestMethod.POST)
//    public String save(@Validated @ModelAttribute("role") Role role, BindingResult bindingResult){
//        new RoleValidator().validate(role,bindingResult);
//        if(bindingResult.hasErrors()){
//            return "addRole";
//        }
//        else {
//            roleService.saveRole(role);
//            return "redirect:/";
//        }
//    }
//
//    @RequestMapping("/edit")
//    public String editUser(@RequestParam("id") int roleId, Model model){
//        Optional<Role> roleEdit = roleService.findRoleById(roleId);
//        roleEdit.ifPresent(role->model.addAttribute("role",role));
//        return "editRole";
//    }
//
//    @RequestMapping("/delete")
//    public String deleteUser(@RequestParam("id") int roleId, Model model){
//        roleService.deleteRole(roleId);
//        return "redirect:/";
//    }
}
