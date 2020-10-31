package com.example.remaketodolist.data.model;

import java.util.ArrayList;

public class User {
    private String id;
    private String email;
    private String password;
    private ArrayList<GroupSchedule> listGroupSchedule;

    public User(String id, String email, String password){
        this.id = id;
        this.email = email;
        this.password = password;
        this.listGroupSchedule = new ArrayList<>();
    }

    public void addGroupSchedule(GroupSchedule groupSchedule){
        listGroupSchedule.add(groupSchedule);
    }

    public ArrayList<GroupSchedule> getListGroupSchedule(){
        return listGroupSchedule;
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
