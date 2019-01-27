package com.mohamed.cheesemvc.controllers;


import com.mohamed.cheesemvc.models.User;
import com.mohamed.cheesemvc.models.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @RequestMapping(value = "add" , method = RequestMethod.GET)
    public String addUserForm(Model model){
        model.addAttribute("title","Registration");
        return "user/add";
    }

    @RequestMapping(value = "add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify){
        if(user.getPassword().equals(verify)){
            UserData.add(user);
        }else {
            model.addAttribute("username",user.getUsername());
            model.addAttribute("email",user.getEmail());
            model.addAttribute("error","Password does not match verify");
            return addUserForm(model);
        }
        model.addAttribute("user",user);
        return "user/index";
    }

}
