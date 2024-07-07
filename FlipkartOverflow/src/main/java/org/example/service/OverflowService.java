package org.example.service;

import org.example.Exception.*;
import org.example.model.*;
import org.example.print.Console;
import org.example.print.Print;

import javax.lang.model.type.ArrayType;
import java.util.*;

public class OverflowService {
    Question question;
    Answer answer;
    Print print = new Console();
    HashMap<Integer, LoggedInUser> loggedUser = new HashMap<>();
    HashMap<Topic, Question> allFeeds = new HashMap<>();

    public void login(LoggedInUser loggedInUser) {
        if (loggedUser.containsKey(loggedInUser.getUserId())) {
            throw new UserAlreadyRegistered();
        }
        loggedUser.put(loggedInUser.getUserId(), loggedInUser);
        print.print("User logged in successfully");
    }

    public void loggedOut(LoggedInUser loggedInUser) {
        if (!loggedUser.containsKey(loggedInUser.getUserId())) {
            throw new UserAlreadyLoggedOut();
        }
        loggedUser.remove(loggedInUser.getUserId());
        print.print("User logged out successfully");
    }

    public void unsubscribe(List<String> unsubscribedTopics, LoggedInUser loggedInUser) {
        if (!loggedUser.containsKey(loggedInUser.getUserId()))
            throw new UserNotLoggedIn();
        Set<String> topics = loggedInUser.getTopics();
        for (String topic : unsubscribedTopics) {
            if (!topics.contains(topic)) {
                throw new UserNotSubsribedToTheTopic();
            } else topics.remove(topic);
        }
        print.print("User unsubscribe from topic");
    }

    public void subsribe(Set<String> subscribedTopics, LoggedInUser loggedInUser) {
        if (!loggedUser.containsKey(loggedInUser.getUserId()))
            throw new UserNotLoggedIn();
        Set<String> topics = new HashSet<>();
        for (String topic : subscribedTopics) {
            topics.add(topic);
        }
        print.print("Subscribed to the topic");
    }

    public void showFeed() {
        if (allFeeds.isEmpty())
            throw new NoFeedExists();
        else {
            for (Map.Entry<Topic, Question> feed : allFeeds.entrySet()) {
                Question question = feed.getValue();
                print.print(question.getDescription()+" ");
                List<Answer> answers = question.getAnswers();
                for(Answer ans : answers)
                    print.print(ans.getAnswerDescription()+" ");
            }
        }
    }

    public void showFeed(List<String> topics) {
        for (String topic : topics) {
            if (!allFeeds.containsKey(topic))
                throw new NoFeedExists();
            else {
                for (Map.Entry<Topic, Question> feed : allFeeds.entrySet()) {
                    if(feed.getKey().equals(topic))
                    {
                        Question question = feed.getValue();
                        print.print(question.getDescription() + " ");
                        List<Answer> answers = question.getAnswers();
                        for (Answer ans : answers)
                            print.print(ans.getAnswerDescription() + " ");
                    }
                }
            }
        }
    }
}


