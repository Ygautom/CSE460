package smartcityhub.model;

import java.time.LocalDate;

public class CommunityServiceEvent extends Event {
    public CommunityServiceEvent(String eventId, String title, String location, String description) {
        this(eventId, title, LocalDate.now().plusDays(7), location, description, true, 50);
    }

    public CommunityServiceEvent(String eventId, String title, LocalDate date, String location,
                    String description, boolean free, int popularityScore) {
        super(eventId, title, date, location, description, EventCategory.COMMUNITY_SERVICE, free, popularityScore);
    }

    @Override
    public void displayDetails() {
        System.out.println("[Community Service Event] " + getSummaryLine());
    }
}
