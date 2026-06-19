package smartcityhub.model;

import java.util.Date;

/**
 * Abstract Event class from the Phase II class diagram (name shown in italics = abstract).
 * Attributes: eventId, title, date, location, description.
 * Abstract operation displayDetails() is overridden by each concrete event type.
 */
public abstract class Event {
    protected String eventId;
    protected String title;
    protected Date date;
    protected String location;
    protected String description;

    public Event(String eventId, String title, String location, String description) {
        this.eventId = eventId;
        this.title = title;
        this.date = new Date();
        this.location = location;
        this.description = description;
    }

    public abstract void displayDetails();

    public String getTitle() { return title; }
    public String getEventId() { return eventId; }
}
