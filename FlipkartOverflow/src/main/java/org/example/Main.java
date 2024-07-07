package org.example;

import org.example.model.LoggedInUser;
import org.example.service.OverflowService;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        OverflowService overflowService = new OverflowService();

        //login user
        LoggedInUser loggedInUser = new LoggedInUser(1, "Sachin", "developer");
        overflowService.login(loggedInUser);
        overflowService.loggedOut(loggedInUser);

        loggedInUser = new LoggedInUser(1, "Sakshi", "developer");
        overflowService.login(loggedInUser);
        //subscribe to topic
        Set<String> topic = new HashSet<>();
        topic.add("Java");
        topic.add("Hadoop");
        topic.add("jdk");
        overflowService.subsribe(topic, loggedInUser);

        List<String> singletonList = Collections.singletonList("Java");
        overflowService.unsubscribe(singletonList, loggedInUser);

        overflowService.showFeed();

        overflowService.showFeed(Arrays.asList("Java"));
    }
}
