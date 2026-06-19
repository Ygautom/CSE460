package smartcityhub.model;

/**
 * EducationEvent - concrete Event subtype from the Phase II class diagram.
 * Overrides displayDetails(). Created by EventFactory (Factory Method pattern).
 */
public class EducationEvent extends Event {
    public EducationEvent(String eventId, String title, String location, String description) {
        super(eventId, title, location, description);
    }

    @Override
    public void displayDetails() {
        System.out.println("[Education Event] " + title + " @ " + location + " - " + description);
    }
}
