package smartcityhub.model;

import java.util.Date;

/**
 * Notification entity from the Phase II class diagram.
 * Attributes: notificationId, message, date.
 */
public class Notification {
    private String notificationId;
    private String message;
    private Date date;

    public Notification(String notificationId, String message) {
        this.notificationId = notificationId;
        this.message = message;
        this.date = new Date();
    }

    public String getNotificationId() { return notificationId; }
    public String getMessage() { return message; }
    public Date getDate() { return date; }

    @Override
    public String toString() {
        return "[" + notificationId + "] " + message;
    }
}
