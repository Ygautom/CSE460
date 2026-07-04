package smartcityhub.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
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
            if (event.getEventId().equalsIgnoreCase(eventId)) {
                return event;
            }
        }
        return null;
    }

    public void displayAllEvents() {
        displayEvents("ALL EVENTS", events);
    }

    public void displayUpcomingEventsSortedByCategory() {
        List<Event> upcoming = new ArrayList<>();
        LocalDate today = LocalDate.now();
        for (Event event : events) {
            if (!event.getDate().isBefore(today)) {
                upcoming.add(event);
            }
        }

        upcoming.sort(Comparator
                .comparing((Event e) -> e.getCategory().getDisplayName())
                .thenComparing(Event::getDate)
                .thenComparing(Event::getTitle));

        displayEvents("UPCOMING EVENTS SORTED BY CATEGORY", upcoming);
    }

    public void searchByType(String type) {
        searchByCategory(type);
    }

    public void displayEventsByCategory(String category) {
        searchByCategory(category);
    }

    public void searchByCategory(String category) {
        EventCategory selected = EventCategory.fromString(category);
        List<Event> results = new ArrayList<>();
        for (Event event : events) {
            if (event.getCategory() == selected) {
                results.add(event);
            }
        }
        displayEvents(selected.getDisplayName().toUpperCase() + " EVENTS", results);
    }

    public void searchByLocation(String location) {
        List<Event> results = new ArrayList<>();
        for (Event event : events) {
            if (event.getLocation().equalsIgnoreCase(location)) {
                results.add(event);
            }
        }
        displayEvents("EVENTS IN " + location.toUpperCase(), results);
    }

    public void searchByDate(LocalDate date) {
        List<Event> results = new ArrayList<>();
        for (Event event : events) {
            if (event.getDate().equals(date)) {
                results.add(event);
            }
        }
        displayEvents("EVENTS ON " + date, results);
    }

    public void searchByFreePaid(boolean free) {
        List<Event> results = new ArrayList<>();
        for (Event event : events) {
            if (event.isFree() == free) {
                results.add(event);
            }
        }
        displayEvents((free ? "FREE" : "PAID") + " EVENTS", results);
    }

    public void searchByMinimumPopularity(int minimumPopularity) {
        List<Event> results = new ArrayList<>();
        for (Event event : events) {
            if (event.getPopularityScore() >= minimumPopularity) {
                results.add(event);
            }
        }
        results.sort(Comparator.comparing(Event::getPopularityScore).reversed());
        displayEvents("POPULAR EVENTS (" + minimumPopularity + "+)", results);
    }

    public List<Event> filterEvents(String category, LocalDate date, String location,
            Boolean free, Integer minimumPopularity) {
        List<Event> results = new ArrayList<>();
        EventCategory selectedCategory = null;
        if (category != null && !category.trim().isEmpty()) {
            selectedCategory = EventCategory.fromString(category);
        }

        for (Event event : events) {
            boolean matches = true;

            if (selectedCategory != null && event.getCategory() != selectedCategory) {
                matches = false;
            }
            if (date != null && !event.getDate().equals(date)) {
                matches = false;
            }
            if (location != null && !location.trim().isEmpty()
                    && !event.getLocation().equalsIgnoreCase(location)) {
                matches = false;
            }
            if (free != null && event.isFree() != free) {
                matches = false;
            }
            if (minimumPopularity != null && event.getPopularityScore() < minimumPopularity) {
                matches = false;
            }

            if (matches) {
                results.add(event);
            }
        }

        results.sort(Comparator
                .comparing((Event e) -> e.getCategory().getDisplayName())
                .thenComparing(Event::getDate)
                .thenComparing(Event::getPopularityScore, Comparator.reverseOrder()));
        return results;
    }

    public void displayFilteredEvents(String category, LocalDate date, String location,
            Boolean free, Integer minimumPopularity) {
        List<Event> results = filterEvents(category, date, location, free, minimumPopularity);
        displayEvents("COMBINED FILTER RESULTS", results);
    }

    public void displayEvents(String title, List<Event> list) {
        System.out.println("\n===== " + title + " =====");
        if (list.isEmpty()) {
            System.out.println("No events found.");
            return;
        }
        for (Event event : list) {
            event.displayDetails();
        }
    }

    public int getTotalEvents() {
        return events.size();
    }

    public List<Event> getEvents() {
        return new ArrayList<>(events);
    }
}
