package com.mohamed.cheesemvc.models;

import java.util.ArrayList;

public class UserData {

    static ArrayList<User> users = new ArrayList<>();

    public static void add(User user){
        users.add(user);
    }

    public static void remove(User user){
        users.remove(user);
    }

}
