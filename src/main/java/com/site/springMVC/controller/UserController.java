package com.site.springMVC.controller;

import com.site.springMVC.entity.User;
import com.site.springMVC.repository.FileRepo;
import com.site.springMVC.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class UserController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private FileRepo fileRepo;


    @GetMapping()
    public String allUsers(Model model){
        model.addAttribute("users", userRepo.findAll());
        model.addAttribute("filerload", fileRepo.findAll());
        return "user/show";

    }
    @GetMapping("/new")
    public String createNewUser(Model model){
        return "user/new";

    }
    @PostMapping("/new")
    public String saveInDbNewUser(@ModelAttribute User user){
        userRepo.save(user);
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteInDbNewUser(@ModelAttribute User user, @PathVariable int id){
        userRepo.delete(userRepo.getById(id));
        return "redirect:/";
    }
    @GetMapping("/update/{id}")
    public String updateUser(@ModelAttribute User user,Model model){
        model.addAttribute("user",user);
        return "user/update";

    }
    @PatchMapping("/{id}")
    public String updateInDbNewUser(@RequestParam String name,
            @RequestParam String email, @PathVariable int id){
        userRepo.save(new User(id,name,email));
        return "redirect:/";
    }
    @GetMapping ("/param/{id}")
    public String paramTest(@RequestParam String id, Model model){
        model.addAttribute("param",userRepo.listUserWhereParam(id));
        return "user/param";
    }





}
