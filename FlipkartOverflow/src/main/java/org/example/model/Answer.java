package org.example.model;

import java.util.List;

public class Answer {
    private String description;
    private int upvote;
    private LoggedInUser loggedInUser;
    private String timestamp;

    public String getAnswerDescription() {
        return description;
    }

    public void setAnswerDescription(String description)
    {
        this.description = description;
    }

    public void setUpvote(int upvote) {
        this.upvote = upvote;
    }

    public void setLoggedInUser(LoggedInUser loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getUpvote() {
        return upvote;
    }

    public LoggedInUser getLoggedInUser() {
        return loggedInUser;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
