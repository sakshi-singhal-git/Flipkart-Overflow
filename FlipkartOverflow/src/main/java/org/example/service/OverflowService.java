package org.example.service;

import org.example.Exception.*;
import org.example.model.*;
import org.example.print.Console;
import org.example.print.Print;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OverflowService {
    Question question;
    Answer answer;
    Print print = new Console();
    HashMap<Integer, LoggedInUser> loggedUser = new HashMap<>();
//    HashMap<Integer, User> loggedOutUser;
//    HashMap<LoggedInUser, List<Topic>> subsribe = new HashMap<>();
    HashMap<Topic, Feed> allFeeds = new HashMap<>();
    List<String> topics = new ArrayList<>();

    public void login(LoggedInUser loggedInUser)
    {
        if(loggedUser.containsKey(loggedInUser.getUserId()))
        {
            throw new UserAlreadyRegistered();
        }
        loggedUser.put(loggedInUser.getUserId(), loggedInUser);
        print.print("User logged in successfully");
    }

    public void loggedOut(LoggedInUser loggedInUser)
    {
        if(!loggedUser.containsKey(loggedInUser.getUserId()))
        {
            throw new UserAlreadyLoggedOut();
        }
        loggedUser.remove(loggedInUser.getUserId());
        print.print("User logged out successfully");

    }
//    public void subsribeTopic(Topic topic, LoggedInUser loggedInUser)
//    {
//        if(subsribe.containsKey(loggedInUser))
//        {
//            List<Topic> subscribed = subsribe.get(loggedInUser);
//            if(subscribed.contains(topic))
//            {
//                throw new UserAlreadySubsribedToTopic();
//            }
//        }
//        if(!subsribe.containsKey(loggedInUser))
//            subsribe.put(loggedInUser,new ArrayList<>());
//        subsribe.get(loggedInUser).add(topic);
//        print.print("User subscribe to topic");
//    }

    public void unsubscribe(List<String> listOfTopics)
    {
        for(String topic: listOfTopics)
        {
            if(!topics.contains(topic)){
                throw new UserNotSubsribedToTheTopic();
            }
            else topics.remove(topic);
        }
        print.print("User unsubscribe from topic");
    }
//        if(subsribe.containsKey(loggedInUser))
//        {
//            List<Topic> subscribed = subsribe.get(loggedInUser);
//            if(!subscribed.contains(topic))
//            {
//                throw new UserNotSubsribedToTheTopic();
//            }
//        }
//        List<Topic> subscribed = subsribe.get(loggedInUser);
//        subscribed.remove(topic);
//

    public void subsribe(List<String> topic)
    {
        for(String t: topic)
        {
            if(!topics.contains(t)) topics.add(t);
            else{
                throw new TopicAlreadyPresent();
            }
        }
        print.print("Subscribed to the topic");
    }

    public void showFeed()
    {
        if(allFeeds.isEmpty())
            throw new NoFeedExists();
        else{
            for(Map.Entry<Topic, Feed> feed: allFeeds.entrySet())
            {
                Feed f = feed.getValue();
                print.print(f.getQuestion().getQuestion()+ " "+ f.getAnser());
            }
        }
    }

    public void showFeed(String topic)
    {
        if(!allFeeds.containsKey(topic))
            throw new NoFeedExists();
        else{
            Feed f = allFeeds.get(topic);
            print.print(f.getQuestion().getQuestion()+ " "+ f.getAnser());
            }
        }
    }


