package org.launchcode.spaday.data;

import org.launchcode.spaday.models.User;

import java.util.*;

public class UserData {
    private static final Map<Integer, User> USERS= new HashMap<>();

    public static void add(User user){
        USERS.put(user.getId(), user);
    }

    public static User getById(int id){
        return USERS.get(id);
    }

    public static Collection<User> getAll(){
        return USERS.values();
    }

    public static void remove(int id){
        USERS.remove(id);
    }



}
