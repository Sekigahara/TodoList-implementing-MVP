package com.example.remaketodolist.data.model;

import java.util.ArrayList;

public class User {
    private String id;
    private String email;
    private String displayName;
    private String password;

    public User(String id, String email, String password){
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    public User(){

    }

    public void setDisplayName(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
