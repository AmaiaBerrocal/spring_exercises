package com.exercises;

import org.springframework.stereotype.Component;

@Component
public class NotificationService {
    public NotificationService() {}
    public void printGreeting() {
        System.out.println("Hi!");
    }
}
