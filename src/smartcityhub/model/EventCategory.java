package smartcityhub.model;

public enum EventCategory {
    MUSIC("Music"),
    TECH("Tech"),
    SPORTS("Sports"),
    SOCIAL("Social"),
    CAREER("Career"),
    EDUCATION("Education"),
    ENVIRONMENT("Environment"),
    CULTURAL("Cultural"),
    COMMUNITY_SERVICE("Community Service");

    private final String displayName;

    EventCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static EventCategory fromString(String value) {
        String normalized = value.trim()
                .replace('-', '_')
                .replace(' ', '_')
                .toUpperCase();
        return EventCategory.valueOf(normalized);
    }
}
