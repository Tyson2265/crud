package com.example.CRUD;

import com.example.CRUD.UserModel.User;
import com.example.CRUD.UserModel.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @Autowired
    private UserRepo repo;

    @GetMapping("")
    public String showHomePage(){
        return "Index";
    }

    @GetMapping("/register")
    public String showAdminPage(Model model){
        model.addAttribute("user" ,new User());
        return "SignUp";
    }

    @PostMapping("/process_register")
    public String Register(User user){
        repo.save(user);
        return "register_success";
    }



}
