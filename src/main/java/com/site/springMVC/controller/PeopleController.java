package com.site.springMVC.controller;

import com.site.springMVC.entity.Person;
import com.site.springMVC.repository.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/people")
public class PeopleController {
    @Autowired
    PersonDAO personDAO;

    @GetMapping
    public String index(Model model){
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }
    @GetMapping("/all")
    public String indexs(Model model){
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String sgow(@PathVariable("id") int id,Model model){
        model.addAttribute("person",personDAO.show(id));

        return "people/show";
    }
    @GetMapping("/new")
    public String newPerson(Model model){
        return "people/new";
    }
    @PostMapping()
    public String create(@ModelAttribute("person") Person person){
        personDAO.save(person);
        /*должны что-то вернуть пользователю после поста*/
        return "redirect:/people";
    }
    @GetMapping("/news")
    public String newPersons(Model model){
        return "people/news";
    }
    @PostMapping("/all")
    public String creates(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult){
        /*Очень важно чтобы резальт был после модели атрибут*/
        if(bindingResult.hasErrors()){
            //в этой форме уже будут ошибки показаны
            return "people/news";
        }
        personDAO.save(person);
        /*должны что-то вернуть пользователю после поста*/
        return "redirect:/people/all";
    }
    /*Редактирование человека*/
    @GetMapping("/{id}/edit")
    public String edit(Model model,@PathVariable int id){
        //для удобства в полях уже будет все написано
        model.addAttribute("person",personDAO.show(id));
        return "people/edit";
    }
    @PatchMapping("/{id}/edit")
    public String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult ,@PathVariable("id") int id,Model model){
        /*Очень важно чтобы резальт был после модели атрибут*/
        if(bindingResult.hasErrors()){
            //получаем лист с ошибками
            Collector<FieldError, ?, Map<String, String>> collector = Collectors.toMap(
                    fieldError -> fieldError.getField() + "Error", FieldError::getField);
            Map<String,String> errorsMap = bindingResult.getFieldErrors().stream().collect(collector);
            model.mergeAttributes(errorsMap);
            model.addAttribute("message",person);
            return "people/edit";
        }
        personDAO.update(id,person);
        return "redirect:/people";

    }
    /*удаление человека*/
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        personDAO.delete(id);
        return "redirect:/people";

    }
}
