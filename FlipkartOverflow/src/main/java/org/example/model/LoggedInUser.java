package org.example.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LoggedInUser implements User{

    private int userId;
    private String name;
    private String profession;
    Set<String> topics;

    public Set<String> getTopics() {
        return topics;
    }

    public void setTopics(Set<String> topics) {
        this.topics = topics;
    }

    public LoggedInUser(int userId, String name, String profession) {
        this.userId = userId;
        this.name = name;
        this.profession = profession;
        this.topics = new HashSet<>();
    }

    public int getUserId() {
        return userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getName() {
        return name;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getProfession() {
        return profession;
    }

    @Override
    public void showAnswer()
    {

    }
}
