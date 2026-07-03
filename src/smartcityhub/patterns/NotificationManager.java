package smartcityhub.patterns;

import java.util.ArrayList;
import java.util.List;
import smartcityhub.model.Notification;

public class NotificationManager {
    private static NotificationManager instance;
    private List<Observer> observers;
    private List<Notification> notifications;

    private NotificationManager() {
        observers = new ArrayList<>();
        notifications = new ArrayList<>();
    }

    public static NotificationManager getInstance() {
        if (instance == null) {
            instance = new NotificationManager();
        }
        return instance;
    }

    public void attachObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void detachObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Notification notification) {
        notifications.add(notification);
        for (Observer observer : observers) {
            observer.update(notification);
        }
    }

    public void sendNotification(String message) {
        Notification notification = new Notification("N" + (notifications.size() + 1), message);
        notifyObservers(notification);
    }

    public int getObserverCount() {
        return observers.size();
    }

    public int getNotificationCount() {
        return notifications.size();
    }
}
