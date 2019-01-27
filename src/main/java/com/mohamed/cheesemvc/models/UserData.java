package com.mohamed.cheesemvc.models;

import java.util.ArrayList;

public class UserData {

    static ArrayList<User> users = new ArrayList<>();

    public static ArrayList<User> getAll(){
        return users;
    }

    public static void add(User user){
        users.add(user);
    }

    public static void remove(User user){
        users.remove(user);
    }

    public static User getById(int userId){
        User matchedUser = null;
        for(User candidateUser : users){
            if(candidateUser.getUserId() == userId){
                matchedUser = candidateUser;
                break;
            }
        }
        return matchedUser;
    }


}
