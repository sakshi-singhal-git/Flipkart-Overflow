package org.example;

import org.example.model.LoggedInUser;
import org.example.service.OverflowService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        OverflowService overflowService = new OverflowService();

        //login user
        overflowService.login(new LoggedInUser(1, "Sachin", "developer"));

        overflowService.loggedOut(new LoggedInUser(1, "Sachin", "developer"));
        overflowService.login(new LoggedInUser(1, "Sakshi", "developer"));
        //subscribe to topic
        List<String> topic = new ArrayList<>();
        topic.add("Java");
        topic.add("Hadoop");
        topic.add("jdk");
        overflowService.subsribe(topic);

        overflowService.showFeed();

        overflowService.showFeed("Java");
    }
}
