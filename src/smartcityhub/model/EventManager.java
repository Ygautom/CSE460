package smartcityhub.model;

import java.util.ArrayList;
import java.util.List;

public class EventManager {

    private List<Event> events;

    public EventManager() {
        events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
        System.out.println(event.getTitle() + " added successfully.");
    }

    public void removeEvent(String eventId) {
        Event event = findEventById(eventId);

        if (event != null) {
            events.remove(event);
            System.out.println("Event removed successfully.");
        } else {
            System.out.println("Event not found.");
        }
    }

    public Event findEventById(String eventId) {
        for (Event event : events) {
            if (event.getEventId().equals(eventId)) {
                return event;
            }
        }
        return null;
    }

    public void displayAllEvents() {
        if (events.isEmpty()) {
            System.out.println("No events available.");
            return;
        }

        System.out.println("\n===== ALL EVENTS =====");

        for (Event event : events) {
            event.displayDetails();
        }
    }

    public void searchByLocation(String location) {
        System.out.println("\nEvents in " + location + ":");

        boolean found = false;

        for (Event event : events) {
            if (event.getLocation().equalsIgnoreCase(location)) {
                event.displayDetails();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No events found.");
        }
    }

    public void searchByType(String type) {
        System.out.println("\n" + type + " Events:");

        boolean found = false;

        for (Event event : events) {
            if (event.getClass().getSimpleName()
                    .toUpperCase()
                    .contains(type.toUpperCase())) {

                event.displayDetails();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No events found.");
        }
    }

    public int getTotalEvents() {
        return events.size();
    }

    public List<Event> getEvents() {
        return events;
    }
}