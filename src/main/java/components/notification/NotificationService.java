package components.notification;

public class NotificationService {
    public void sendEmail(String email, String message) {
        System.out.println("[NotificationComponent] Sending Email to " + email + ": " + message);
    }

    public void sendSMS(String phone, String message) {
        System.out.println("[NotificationComponent] Sending SMS to " + phone + ": " + message);
    }
}