package smartcityhub.model;

/**
 * SportsEvent - concrete Event subtype from the Phase II class diagram.
 * Overrides displayDetails(). Created by EventFactory (Factory Method pattern).
 */
public class SportsEvent extends Event {
    public SportsEvent(String eventId, String title, String location, String description) {
        super(eventId, title, location, description);
    }

    @Override
    public void displayDetails() {
        System.out.println("[Sports Event] " + title + " @ " + location + " - " + description);
    }
}
