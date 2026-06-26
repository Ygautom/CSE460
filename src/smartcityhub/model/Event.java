package smartcityhub.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Abstract Event class from the Phase II class diagram.
 */
public abstract class Event {

    protected String eventId;
    protected String title;
    protected Date date;
    protected String location;
    protected String description;

    // NEW
    protected List<Citizen> participants;

    public Event(String eventId, String title, String location, String description) {
        this.eventId = eventId;
        this.title = title;
        this.date = new Date();
        this.location = location;
        this.description = description;

        // NEW
        participants = new ArrayList<>();
    }

    public abstract void displayDetails();

    public void registerCitizen(Citizen citizen) {
        participants.add(citizen);
        System.out.println(citizen.getName() + " registered for " + title);
    }

    public void displayParticipants() {
        System.out.println("Participants for " + title + ":");

        if (participants.isEmpty()) {
            System.out.println("No participants registered.");
            return;
        }

        for (Citizen citizen : participants) {
            System.out.println("- " + citizen.getName());
        }
    }

    public String getTitle() {
        return title;
    }

    public String getEventId() {
        return eventId;
    }

    public String getLocation() {
        return location;
    }
}