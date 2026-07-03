package smartcityhub.model;

import java.time.LocalDateTime;

public class Notification {
    private String notificationId;
    private String message;
    private LocalDateTime dateTime;

    public Notification(String notificationId, String message) {
        this.notificationId = notificationId;
        this.message = message;
        this.dateTime = LocalDateTime.now();
    }

    public String getNotificationId() {
        return notificationId;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "[" + notificationId + "] " + message + " (" + dateTime + ")";
    }
}
