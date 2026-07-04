package smartcityhub.model;

import java.time.LocalDate;
import smartcityhub.patterns.EventFactory;

public class Administrator extends User {
    public Administrator(String userId, String name, String email, String password) {
        super(userId, name, email, password);
    }

    public Event createEvent(String type, String eventId, String title,
                             String location, String description) {
        System.out.println(name + " (Admin) creating a " + type + " event...");
        return EventFactory.createEvent(type, eventId, title, location, description);
    }

    public Event createEvent(String type, String eventId, String title,
                             LocalDate date, String location, String description,
                             boolean free, int popularityScore) {
        System.out.println(name + " (Admin) creating a " + type + " event...");
        return EventFactory.createEvent(type, eventId, title, date, location,
                description, free, popularityScore);
    }

    public void viewAllEvents(EventManager eventManager) {
        System.out.println(name + " (Admin) is viewing all events.");
        eventManager.displayAllEvents();
    }

    // Added from your version
    public void viewTotalEvents(EventManager eventManager) {
        System.out.println("Total Events: " + eventManager.getTotalEvents());
    }

    public void removeEvent(EventManager eventManager, String eventId) {
        System.out.println(name + " (Admin) removing event " + eventId + ".");
        eventManager.removeEvent(eventId);
    }

    public void reviewServiceRequests(ServiceRequestManager requestManager) {
        System.out.println(name + " (Admin) is reviewing service requests.");
        requestManager.displayAllRequests();
    }

    public void showAdminDashboard(EventManager eventManager, ServiceRequestManager requestManager) {
        System.out.println("\n================ ADMIN DASHBOARD ================");
        System.out.println("Admin: " + name);
        System.out.println("Total Events: " + eventManager.getTotalEvents());
        System.out.println("Total Service Requests: " + requestManager.getTotalRequests());
        System.out.println("Open Requests: " + requestManager.countByStatus(RequestStatus.OPEN));
        System.out.println("In Progress Requests: " + requestManager.countByStatus(RequestStatus.IN_PROGRESS));
        System.out.println("Resolved Requests: " + requestManager.countByStatus(RequestStatus.RESOLVED));
        System.out.println("Closed Requests: " + requestManager.countByStatus(RequestStatus.CLOSED));
        eventManager.displayUpcomingEventsSortedByCategory();
        requestManager.displayAllRequests();
        System.out.println("=================================================");
    }
}