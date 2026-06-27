package smartcityhub.patterns;

import smartcityhub.model.*;

/**
 * Factory Method pattern - EventFactory from the Phase II class diagram.
 * createEvent(type) decides which concrete Event subtype to instantiate, so the
 * rest of the system never hardcodes SportsEvent, CulturalEvent, etc.
 * Adding a new category means editing only this factory (Open/Closed Principle).
 */
public class EventFactory {

    public static Event createEvent(String type, String eventId, String title,
                                    String location, String description) {
        switch (type.toUpperCase()) {
            case "SPORTS":
                return new SportsEvent(eventId, title, location, description);
            case "CULTURAL":
                return new CulturalEvent(eventId, title, location, description);
            case "EDUCATION":
                return new EducationEvent(eventId, title, location, description);
            case "ENVIRONMENT":
                return new EnvironmentEvent(eventId, title, location, description);
            case "COMMUNITY_SERVICE":
                return new CommunityServiceEvent(eventId, title, location, description);
            default:
                throw new IllegalArgumentException("Unknown event type: " + type);
        }
    }
}
