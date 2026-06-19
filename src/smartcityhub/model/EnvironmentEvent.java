package smartcityhub.model;

/**
 * EnvironmentEvent - concrete Event subtype from the Phase II class diagram.
 * Overrides displayDetails(). Created by EventFactory (Factory Method pattern).
 */
public class EnvironmentEvent extends Event {
    public EnvironmentEvent(String eventId, String title, String location, String description) {
        super(eventId, title, location, description);
    }

    @Override
    public void displayDetails() {
        System.out.println("[Environment Event] " + title + " @ " + location + " - " + description);
    }
}
