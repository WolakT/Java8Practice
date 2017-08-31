package com.sda.users;

import java.util.List;

/**
 * Created by RENT on 2017-08-30.
 */
public class User {
    private int id;
    private String name;
    private int age;
    private List<String> skills;

    public User(int id, String name, int age, List<String> skills) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.skills = skills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", skills=" + skills +
                '}';
    }
}
