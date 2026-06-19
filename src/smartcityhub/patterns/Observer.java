package smartcityhub.patterns;

import smartcityhub.model.Notification;

/**
 * Observer pattern - the «interface» Observer from the Phase II class diagram.
 * Any class that wants to receive notifications (e.g. Citizen) implements this.
 */
public interface Observer {
    void update(Notification notification);
}
