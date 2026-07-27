package Creational.Factory;

public class FactoryMethodDemo {
    public static void main(String[] args){
        NotificationCreator creator;

        // Send Email
        creator = new EmailNotificationCreator();
        creator.send("Welcome to our platform!");

        // Send SMS
        creator = new SmsNotificationCreator();
        creator.send("Your OTP is 123456");
    }
}
