package com.example.remaketodolist.data.model;

public class Schedule {
    private String id;
    private String title;
    private String description;
    private Integer isDone = 0;
    private String date;

    public Schedule(String id, String title, String description, String date, Integer isDone){
        this.id = id;
        this.title = title;
        this.description = description;
        this.isDone = isDone;
        this.date = date;
    }

    public Schedule(String title, String description, String date, Integer isDone){
        this.title = title;
        this.description = description;
        this.isDone = isDone;
        this.date = date;
    }

    public Schedule(String title, String description, String date){
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public Schedule(String id, String title, String description, String date){
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public Integer getIsDone(){
        return isDone;
    }

    public void setIsDone(Integer isDone){
        this.isDone = isDone;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }
}
