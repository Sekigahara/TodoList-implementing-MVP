package com.example.remaketodolist.data.model;

import java.util.ArrayList;

public class GroupSchedule {
    private String id;
    private int image;
    private String title;
    private String description;
    private ArrayList<Schedule> listSchedule;

    public GroupSchedule(String id, int image, String title, String description){
        this.id = id;
        this.image = image;
        this.title = title;
        this.description = description;
        listSchedule = new ArrayList<>();
    }

    public void addSchedule(Schedule schedule){
        listSchedule.add(schedule);
    }

    public ArrayList<Schedule> getListGroupSchedule(){
        return listSchedule;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public int getImage(){
        return image;
    }

    public void setImage(int image){
        this.image = image;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }
}