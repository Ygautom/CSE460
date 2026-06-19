package smartcityhub.model;

/**
 * CulturalEvent - concrete Event subtype from the Phase II class diagram.
 * Overrides displayDetails(). Created by EventFactory (Factory Method pattern).
 */
public class CulturalEvent extends Event {
    public CulturalEvent(String eventId, String title, String location, String description) {
        super(eventId, title, location, description);
    }

    @Override
    public void displayDetails() {
        System.out.println("[Cultural Event] " + title + " @ " + location + " - " + description);
    }
}
