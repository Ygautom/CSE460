package smartcityhub.model;

import java.time.LocalDate;

public class CareerEvent extends Event {
    public CareerEvent(String eventId, String title, String location, String description) {
        this(eventId, title, LocalDate.now().plusDays(7), location, description, true, 50);
    }

    public CareerEvent(String eventId, String title, LocalDate date, String location,
                    String description, boolean free, int popularityScore) {
        super(eventId, title, date, location, description, EventCategory.CAREER, free, popularityScore);
    }

    @Override
    public void displayDetails() {
        System.out.println("[Career Event] " + getSummaryLine());
    }
}
