package com.example.test;


public class User {
    private String name;
    private String email;
    private String school;


    //Qitu ruhen te dhenat
    public User() {}


    public User(String name, String email, String school){
        this.name = name;
        this.email = email;
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getSchool() {
        return school;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
