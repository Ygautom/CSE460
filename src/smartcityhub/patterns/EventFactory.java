package smartcityhub.patterns;

import java.time.LocalDate;
import smartcityhub.model.*;

public class EventFactory {
    public static Event createEvent(String type, String eventId, String title,
                                    String location, String description) {
        return createEvent(type, eventId, title, LocalDate.now().plusDays(7),
                location, description, true, 50);
    }

    public static Event createEvent(String type, String eventId, String title,
                                    LocalDate date, String location, String description,
                                    boolean free, int popularityScore) {
        switch (type.trim().replace('-', '_').replace(' ', '_').toUpperCase()) {
            case "SPORTS":
                return new SportsEvent(eventId, title, date, location, description, free, popularityScore);
            case "MUSIC":
                return new MusicEvent(eventId, title, date, location, description, free, popularityScore);
            case "TECH":
                return new TechEvent(eventId, title, date, location, description, free, popularityScore);
            case "SOCIAL":
                return new SocialEvent(eventId, title, date, location, description, free, popularityScore);
            case "CAREER":
                return new CareerEvent(eventId, title, date, location, description, free, popularityScore);
            case "CULTURAL":
                return new CulturalEvent(eventId, title, date, location, description, free, popularityScore);
            case "EDUCATION":
                return new EducationEvent(eventId, title, date, location, description, free, popularityScore);
            case "ENVIRONMENT":
                return new EnvironmentEvent(eventId, title, date, location, description, free, popularityScore);
            case "COMMUNITY_SERVICE":
                return new CommunityServiceEvent(eventId, title, date, location, description, free, popularityScore);
            default:
                throw new IllegalArgumentException("Unknown event type: " + type);
        }
    }
}
