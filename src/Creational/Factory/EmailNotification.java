package Creational.Factory;

import java.sql.SQLOutput;

public class EmailNotification implements Notification{
    @Override
    public void send(String message) {
        System.out.println("Sending email : " + message);
    }
}
