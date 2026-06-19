package smartcityhub.patterns;

import smartcityhub.model.Notification;
import java.util.ArrayList;
import java.util.List;

/**
 * Singleton + Observer subject - NotificationManager from the Phase II class diagram.
 *
 * Singleton: private constructor + static getInstance() with lazy initialization
 * guarantee exactly one instance, so every part of the system shares one observer
 * registry (a citizen registered once will not miss notifications).
 *
 * Observer subject: holds the list of observers and broadcasts notifications to them.
 */
public class NotificationManager {
    private static NotificationManager instance;          // - instance : NotificationManager
    private List<Observer> observers;                     // - observers : List<Observer>
    private List<Notification> notifications;             // - notifications : List<Notification>

    private NotificationManager() {                       // - NotificationManager() (private)
        observers = new ArrayList<>();
        notifications = new ArrayList<>();
    }

    public static NotificationManager getInstance() {     // + getInstance() : NotificationManager
        if (instance == null) {
            instance = new NotificationManager();
        }
        return instance;
    }

    public void attachObserver(Observer observer) {       // + attachObserver(observer) : void
        observers.add(observer);
    }

    public void detachObserver(Observer observer) {       // + detachObserver(observer) : void
        observers.remove(observer);
    }

    public void notifyObservers(Notification notification) { // + notifyObservers(notification) : void
        notifications.add(notification);
        for (Observer o : observers) {
            o.update(notification);
        }
    }

    public void sendNotification(String message) {        // + sendNotification(message) : void
        Notification n = new Notification("N" + (notifications.size() + 1), message);
        notifyObservers(n);
    }

    public int getObserverCount() { return observers.size(); }
}
