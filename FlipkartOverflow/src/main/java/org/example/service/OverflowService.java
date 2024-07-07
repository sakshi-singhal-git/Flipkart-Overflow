package org.example.service;

import org.example.Exception.*;
import org.example.model.*;
import org.example.print.Print;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OverflowService {
    Question question;
    Answer answer;
    Print print;
    HashMap<Integer, LoggedInUser> loggedUser;
    HashMap<Integer, User> loggedOutUser;
    HashMap<LoggedInUser, List<Topic>> subsribe;
    HashMap<Topic, Feed> allFeeds;
    List<String> topics;

    public void login(LoggedInUser loggedInUser)
    {
        if(!loggedUser.containsKey(loggedInUser.getUserId()))
        {
            throw new UserAlreadyRegistered();
        }
        loggedUser.put(loggedInUser.getUserId(), loggedInUser);
    }

    public void loggedOut(LoggedInUser loggedInUser)
    {
        if(!loggedUser.containsKey(loggedInUser.getUserId()))
        {
            throw new UserAlreadyLoggedOut();
        }
        loggedUser.remove(loggedInUser);
        print.print("User logged out successfully");

    }
    public void subsribeTopic(Topic topic, LoggedInUser loggedInUser)
    {
        if(subsribe.containsKey(loggedInUser))
        {
            List<Topic> subscribed = subsribe.get(loggedInUser);
            if(subscribed.contains(topic))
            {
                throw new UserAlreadySubsribedToTopic();
            }
        }
        if(!subsribe.containsKey(loggedInUser))
            subsribe.put(loggedInUser,new ArrayList<>());
        subsribe.get(loggedInUser).add(topic);
        print.print("User subscribe to topic");
    }

    public void unsubscribe(Topic topic, LoggedInUser loggedInUser)
    {
        if(subsribe.containsKey(loggedInUser))
        {
            List<Topic> subscribed = subsribe.get(loggedInUser);
            if(!subscribed.contains(topic))
            {
                throw new UserNotSubsribedToTheTopic();
            }
        }
        List<Topic> subscribed = subsribe.get(loggedInUser);
        subscribed.remove(topic);
        print.print("User unsubscribe from topic");
    }

    public void subsribe(List<String> topic)
    {
        for(String t: topic)
        {
            if(!topics.contains(t)) topics.add(t);
            else{
                throw new TopicAlreadyPresent();
            }
        }
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
        if(allFeeds.containsKey(topic))
            throw new NoFeedExists();
        else{
            Feed f = allFeeds.get(topic);
            print.print(f.getQuestion().getQuestion()+ " "+ f.getAnser());
            }
        }
    }


