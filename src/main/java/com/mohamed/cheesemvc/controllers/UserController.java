package com.mohamed.cheesemvc.controllers;


import com.mohamed.cheesemvc.models.User;
import com.mohamed.cheesemvc.models.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("users",UserData.getAll());
        return "user/index";
    }

    @RequestMapping(value = "add" , method = RequestMethod.GET)
    public String addUserForm(Model model){
        model.addAttribute("title","Registration");
        model.addAttribute(new User());
        return "user/add";
    }

    @RequestMapping(value = "add")
    public String processAddUserForm(Model model, @ModelAttribute  @Valid User user, Errors errors){
        if(errors.hasErrors()){
            model.addAttribute("title","Registration");
            model.addAttribute(user);
            return "user/add";
        }
        UserData.add(user);
        return index(model);
    }

}
