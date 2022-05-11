package com.site.mikeladze.controller;

import com.site.mikeladze.model.Login.Role;
import com.site.mikeladze.model.Login.User;
import com.site.mikeladze.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;
    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }
    @PostMapping("/registration")
        public String addUser( User user, Model model){
        User byUsername = userRepo.findByUsername(user.getUsername());
        if(byUsername!=null){
            model.addAttribute("usave","User exists!");
            return "registration";
        }
        /*Collections.singleton() - создаст сэт с одним единственным значением */
        user.setRoles(Collections.singleton(Role.USER));
        //добавляем пользователя
        userRepo.save(user);
        return "redirect:/login";
        }

}
