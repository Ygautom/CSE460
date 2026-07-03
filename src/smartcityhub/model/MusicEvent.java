package smartcityhub.model;

import java.time.LocalDate;

public class MusicEvent extends Event {
    public MusicEvent(String eventId, String title, String location, String description) {
        this(eventId, title, LocalDate.now().plusDays(7), location, description, true, 50);
    }

    public MusicEvent(String eventId, String title, LocalDate date, String location,
                    String description, boolean free, int popularityScore) {
        super(eventId, title, date, location, description, EventCategory.MUSIC, free, popularityScore);
    }

    @Override
    public void displayDetails() {
        System.out.println("[Music Event] " + getSummaryLine());
    }
}
