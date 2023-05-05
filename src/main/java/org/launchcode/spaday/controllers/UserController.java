package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm(Model model){
        model.addAttribute("user",new User());
        return "user/add";
    }

    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User user,@RequestParam String verify) {
        if(user.getPassword().equals(verify)) {
            UserData.add(user);
            model.addAttribute("username", user.getUsername());
            model.addAttribute("users", UserData.getAll());
            return "user/index";
        }
        model.addAttribute(user);
        model.addAttribute("warning", "Passwords do not match");
        return "user/add";
    }

    @GetMapping("profile/{id}")
    public String getUserInfo(Model model, @PathVariable int id){
        System.out.println(id);
        model.addAttribute("user",UserData.getById(id));
        return "user/profile";
    }
}
