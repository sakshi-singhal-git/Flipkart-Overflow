package org.example.model;

public class LoggedInUser implements User{

    private int userId;
    private String name;
    private String profession;

    public LoggedInUser(int userId, String name, String profession) {
        this.userId = userId;
        this.name = name;
        this.profession = profession;
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
