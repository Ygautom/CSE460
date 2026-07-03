package smartcityhub.model;

import java.time.LocalDate;

public class EducationEvent extends Event {
    public EducationEvent(String eventId, String title, String location, String description) {
        this(eventId, title, LocalDate.now().plusDays(7), location, description, true, 50);
    }

    public EducationEvent(String eventId, String title, LocalDate date, String location,
                    String description, boolean free, int popularityScore) {
        super(eventId, title, date, location, description, EventCategory.EDUCATION, free, popularityScore);
    }

    @Override
    public void displayDetails() {
        System.out.println("[Education Event] " + getSummaryLine());
    }
}
