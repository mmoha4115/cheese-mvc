package com.mohamed.cheesemvc.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping(value = "cheese")
public class CheeseController {

    static HashMap<String,String> cheeses = new HashMap<>();

    @RequestMapping(value = "")
    public String index(Model model){

        model.addAttribute("cheeses",cheeses);
        model.addAttribute("title","My Cheeses");
        return "cheese/index";
    }

    @RequestMapping(value = "add" , method = RequestMethod.GET)
    public  String displayAddCheeeseForm(Model model,String error){
        model.addAttribute("title","Add Cheese");
        model.addAttribute("error",error);
        return "cheese/add";
    }

    @RequestMapping(value = "add" , method = RequestMethod.POST)
    public String processAddCheeseForm(Model model,@RequestParam String cheeseName, @RequestParam String description){
        if(cheeseName.isEmpty() || containsNumbers(cheeseName)){
            String error = "Cheese name must contain alphabets only and must not be empty!";
            return displayAddCheeeseForm(model, error);
        }
        cheeses.put(cheeseName,description);
//        redirect to /cheese
        return "redirect:";
    }

    public boolean containsNumbers(String cheeseName){
        char [] numbers = "0123456789".toCharArray();
        char [] letterOfCheeseName = cheeseName.toCharArray();

        for(char cheeseNameChar:letterOfCheeseName){
            for (char numberChar: numbers){
                if(cheeseNameChar == numberChar){
                    return true;
                }
            }
        }
        return false;
    }

    @RequestMapping(value = "remove",method = RequestMethod.GET)
    public String removeCheeseForm(Model model){
        model.addAttribute("cheeses",cheeses);
        model.addAttribute("title","Remove Cheese");

        return "cheese/remove";
    }

    @RequestMapping(value = "remove",method = RequestMethod.POST)
    public String proccessRemoveCheeseForm(@RequestParam ArrayList<String> cheese){
        for (String aCheese : cheese) {
            cheeses.remove(aCheese,cheeses.get(aCheese));
        }

        return "redirect:";
    }
}
