package org.example.model;

import java.util.List;

public class Question {
    private int upvote;
    private String description;
    private List<Answer> answers;
    private LoggedInUser loggedInUser;
    private List<Topic> topic;
    private String timestamp;

    public Question(List<Answer> answers, LoggedInUser loggedInUser, List<Topic> topic, String timestamp) {
        this.answers = answers;
        this.loggedInUser = loggedInUser;
        this.topic = topic;
        this.timestamp = timestamp;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUpvote(int upvote) {
        this.upvote = upvote;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public void setLoggedInUser(LoggedInUser loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void setTopic(List<Topic> topic) {
        this.topic = topic;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getUpvote() {
        return upvote;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public LoggedInUser getLoggedInUser() {
        return loggedInUser;
    }

    public List<Topic> getTopic() {
        return topic;
    }

    public String getTimestamp() {
        return timestamp;
    }






}
