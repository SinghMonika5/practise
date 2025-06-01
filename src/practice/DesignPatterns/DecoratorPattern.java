package practice.DesignPatterns;

public class DecoratorPattern {
    public static void main(String[] args) {
        SimpleNotification simpleNotification = new SimpleNotification();
        simpleNotification.send("SimpleNotification");
        System.out.println("--------------------------");

        Notification smsNotification = new SMSNotificationDecorator(new SimpleNotification());
        smsNotification.send("Hello, this is an SMS notification!");

        System.out.println("--------------------------");

        Notification emailNotification = new EmailNotificationDecorator(new SimpleNotification());
        emailNotification.send("Hello, this is an Email notification!");

        System.out.println("--------------------------");

        Notification combinedNotification = new SMSNotificationDecorator(new EmailNotificationDecorator(new SimpleNotification()));
        combinedNotification.send("Hello, this is a combined SMS and Email notification!");



    }
}

interface Notification {
    void send(String message);
}



class SimpleNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending simple notification: " + message);
    }
}


abstract class NotificationDecorator implements Notification {
    protected Notification notification;

    public NotificationDecorator(Notification notification) {
        this.notification = notification;
    }

    @Override
    public void send(String message) {
        notification.send(message);
    }
}


class SMSNotificationDecorator extends NotificationDecorator {
    public SMSNotificationDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS notification: " + message);
    }
}


class EmailNotificationDecorator extends NotificationDecorator {
    public EmailNotificationDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendEmail(message);
    }

    private void sendEmail(String message) {
        System.out.println("Sending Email notification: " + message);
    }
}

