package com.example.CRUD.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public String showUserList(Model model){
        List<User> ListUsers = service.ListAll();

        model.addAttribute("ListUsers" , ListUsers);
        return "Users";

    }

    @GetMapping("/users/new")
    public String showNewForm(Model model){
        model.addAttribute("user" , new User());
        model.addAttribute("pageTitle" , "Add New User");

        return "user_form";
    }
    @PostMapping("/users/save")
    public String saveUser(User user , RedirectAttributes redirectAttributes){
        service.save(user);
        redirectAttributes.addFlashAttribute("message" , "The User has been Added Successfully");
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String showEditForm (@PathVariable("id") Integer id , Model model ,RedirectAttributes ra){
        try {
          User user =  service.getById(id);
            model.addAttribute("user" , user);
            model.addAttribute("pageTitle" , "Edit User (ID :" + id +")");
            return "user_form";

        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message" , "The user has been saved");
            return "redirect:/users";
        }
    }




    @GetMapping("/users/delete/{id}")
    public String deleteById (@PathVariable("id") Integer id  ,RedirectAttributes ra) throws UserNotFoundException {
        service.deleteById(id);
        ra.addFlashAttribute("message" , "The user ID" +id+" has been deleted");


        return "redirect:/users";
    }


}
