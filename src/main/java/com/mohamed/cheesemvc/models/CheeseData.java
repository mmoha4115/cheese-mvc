package com.mohamed.cheesemvc.models;

import java.util.ArrayList;

public class CheeseData {

    static ArrayList<Cheese> cheeses = new ArrayList<>();

    public static ArrayList<Cheese> getAll(){
        return cheeses;
    }

    public static void add(Cheese newCheese){
        cheeses.add(newCheese);
    }

    public static void remove(int cheeseId){

        Cheese cheeseToRemove = getById(cheeseId);
        cheeses.remove(cheeseToRemove);
    }

    public static Cheese getById(int cheeseId) {

        Cheese matchedCheese = null;
        for (Cheese candidateCheese: cheeses){
            if(candidateCheese.getCheeseId() == cheeseId){
                matchedCheese = candidateCheese;
                break; }
        }
        return matchedCheese;
    }


}
