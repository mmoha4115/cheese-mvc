package com.mohamed.cheesemvc.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mohamed.cheesemvc.models.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "cheese")
public class CheeseController {

    @RequestMapping(value = "")
    public String index(Model model){

        model.addAttribute("cheeses",CheeseData.getAll());
        model.addAttribute("title","My Cheeses");
        return "cheese/index";
    }

    @RequestMapping(value = "add" , method = RequestMethod.GET)
    public  String displayAddCheeeseForm(Model model){
        model.addAttribute("title","Add Cheese");
        model.addAttribute(new Cheese());
        return "cheese/add";
    }

    @RequestMapping(value = "add" , method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid Cheese newCheese , Errors errors,Model model){
        if(errors.hasErrors()){
            model.addAttribute("title","Add Cheese");
            return "cheese/add";
        }
        CheeseData.add(newCheese);
//        redirect to /cheese
        return "redirect:";
    }

    @RequestMapping(value = "remove",method = RequestMethod.GET)
    public String removeCheeseForm(Model model){
        model.addAttribute("cheeses",CheeseData.getAll());
        model.addAttribute("title","Remove Cheese");

        return "cheese/remove";
    }

    @RequestMapping(value = "remove",method = RequestMethod.POST)
    public String proccessRemoveCheeseForm(@RequestParam int [] cheeseId){
        for (int aCheeseId : cheeseId) {
            CheeseData.remove(aCheeseId);
        }
        return "redirect:";
    }

    @RequestMapping(value = "edit/{cheeseId}" , method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int cheeseId){
        model.addAttribute("cheese",CheeseData.getById(cheeseId));
        return "cheese/edit";
    }

    @RequestMapping(value = "edit/{cheeseId}" , method = RequestMethod.POST)
    public String processEditForm(int cheeseId , String name, String description){
        CheeseData.getById(cheeseId).setDescription(description);
        CheeseData.getById(cheeseId).setName(name);
        return "cheese/index";
    }
}
