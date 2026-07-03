package smartcityhub.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Event {
    protected String eventId;
    protected String title;
    protected LocalDate date;
    protected String location;
    protected String description;
    protected EventCategory category;
    protected boolean free;
    protected int popularityScore;
    protected List<Citizen> participants;

    public Event(String eventId, String title, LocalDate date, String location,
                 String description, EventCategory category, boolean free,
                 int popularityScore) {
        this.eventId = eventId;
        this.title = title;
        this.date = date;
        this.location = location;
        this.description = description;
        this.category = category;
        this.free = free;
        this.popularityScore = Math.max(0, Math.min(100, popularityScore));
        this.participants = new ArrayList<>();
    }

    public abstract void displayDetails();

    public void registerCitizen(Citizen citizen) {
        if (!participants.contains(citizen)) {
            participants.add(citizen);
            System.out.println(citizen.getName() + " registered for " + title);
        } else {
            System.out.println(citizen.getName() + " is already registered for " + title);
        }
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

    protected String getSummaryLine() {
        String cost = free ? "Free" : "Paid";
        return title + " | " + category.getDisplayName()
                + " | " + date
                + " | " + location
                + " | " + cost
                + " | Popularity: " + popularityScore
                + " | " + description;
    }

    public String getEventId() {
        return eventId;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public EventCategory getCategory() {
        return category;
    }

    public boolean isFree() {
        return free;
    }

    public int getPopularityScore() {
        return popularityScore;
    }
}
