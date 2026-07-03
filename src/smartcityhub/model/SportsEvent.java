package smartcityhub.model;

import java.time.LocalDate;

public class SportsEvent extends Event {
    public SportsEvent(String eventId, String title, String location, String description) {
        this(eventId, title, LocalDate.now().plusDays(7), location, description, true, 50);
    }

    public SportsEvent(String eventId, String title, LocalDate date, String location,
                    String description, boolean free, int popularityScore) {
        super(eventId, title, date, location, description, EventCategory.SPORTS, free, popularityScore);
    }

    @Override
    public void displayDetails() {
        System.out.println("[Sports Event] " + getSummaryLine());
    }
}
