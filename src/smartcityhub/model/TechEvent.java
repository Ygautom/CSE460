package smartcityhub.model;

import java.time.LocalDate;

public class TechEvent extends Event {
    public TechEvent(String eventId, String title, String location, String description) {
        this(eventId, title, LocalDate.now().plusDays(7), location, description, true, 50);
    }

    public TechEvent(String eventId, String title, LocalDate date, String location,
                    String description, boolean free, int popularityScore) {
        super(eventId, title, date, location, description, EventCategory.TECH, free, popularityScore);
    }

    @Override
    public void displayDetails() {
        System.out.println("[Tech Event] " + getSummaryLine());
    }
}
