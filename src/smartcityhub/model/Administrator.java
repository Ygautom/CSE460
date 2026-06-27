package smartcityhub.model;

import smartcityhub.patterns.EventFactory;

/**
 * Administrator from the Phase II class diagram - inherits User.
 * Uses EventFactory to create events (Factory Method) and reviews service
 * requests.
 */
public class Administrator extends User {
    public Administrator(String userId, String name, String email, String password) {
        super(userId, name, email, password);
    }

    public void viewAllEvents(EventManager eventManager) {
        System.out.println(name + " (Admin) is viewing all events.");
        eventManager.displayAllEvents();
    }

    public void removeEvent(EventManager eventManager, String eventId) {
        System.out.println(name + " (Admin) removed event " + eventId + ".");
        eventManager.removeEvent(eventId);
    }

    public Event createEvent(String type, String eventId, String title,
            String location, String description) {
        System.out.println(name + " (Admin) creating a " + type + " event...");
        return EventFactory.createEvent(type, eventId, title, location, description);
    }

    public void reviewServiceRequests() {
        System.out.println(name + " is reviewing service requests.");
    }
}
