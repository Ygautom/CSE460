package smartcityhub.model;

/**
 * CommunityServiceEvent - concrete Event subtype from the Phase II class diagram.
 * Overrides displayDetails(). Created by EventFactory (Factory Method pattern).
 */
public class CommunityServiceEvent extends Event {
    public CommunityServiceEvent(String eventId, String title, String location, String description) {
        super(eventId, title, location, description);
    }

    @Override
    public void displayDetails() {
        System.out.println("[CommunityService Event] " + title + " @ " + location + " - " + description);
    }
}
