package smartcityhub.app;

import smartcityhub.model.*;
import smartcityhub.patterns.NotificationManager;

public class SmartCityHubApp {

    public static void main(String[] args) {

        System.out.println("=== SmartCity Hub - Phase II Demo ===\n");

        // Create users
        Administrator admin = new Administrator("A1", "Saideep", "admin@city.gov", "pw");
        DepartmentManager manager = new DepartmentManager("M1", "Yash", "mgr@city.gov", "pw");
        Citizen alice = new Citizen("C1", "Alice", "alice@email.com", "pw");
        Citizen bob = new Citizen("C2", "Bob", "bob@email.com", "pw");

        // Create Event Manager
        EventManager eventManager = new EventManager();

        // Singleton + Observer
        NotificationManager nm = NotificationManager.getInstance();
        nm.attachObserver(alice);
        nm.attachObserver(bob);

        System.out.println("Subscribed observers: " + nm.getObserverCount());

        NotificationManager nm2 = NotificationManager.getInstance();
        System.out.println("Same NotificationManager instance? " + (nm == nm2));

        System.out.println();

        // Factory Pattern
        System.out.println("----- Creating Events -----");

        Event e1 = admin.createEvent(
                "SPORTS",
                "E1",
                "City Marathon",
                "Downtown",
                "Annual 10K Run");

        Event e2 = admin.createEvent(
                "ENVIRONMENT",
                "E2",
                "River Cleanup",
                "Riverside",
                "Volunteer Cleanup");

        Event e3 = admin.createEvent(
                "CULTURAL",
                "E3",
                "Music Festival",
                "Downtown",
                "Local Music Celebration");

        // Store events
        eventManager.addEvent(e1);
        eventManager.addEvent(e2);
        eventManager.addEvent(e3);

        System.out.println();

        // Administrator views all events
        System.out.println("----- Administrator Views All Events -----");
        admin.viewAllEvents(eventManager);

        System.out.println();

        // Search by type
        System.out.println("----- Search by Type -----");
        eventManager.searchByType("SPORTS");

        System.out.println();

        // Search by location
        System.out.println("----- Search by Location -----");
        eventManager.searchByLocation("Downtown");

        System.out.println();

        // Find event
        System.out.println("----- Find Event -----");

        Event foundEvent = eventManager.findEventById("E1");

        if (foundEvent != null) {
            foundEvent.displayDetails();
        }

        System.out.println();

        // Register citizens
        System.out.println("----- Event Registration -----");

        alice.registerForEvent(e1);
        bob.registerForEvent(e1);

        System.out.println();

        // Display participants
        System.out.println("----- Event Participants -----");
        e1.displayParticipants();

        System.out.println();

        // Administrator removes event
        System.out.println("----- Administrator Removes Event -----");
        admin.removeEvent(eventManager, "E2");

        System.out.println();

        // Administrator views updated events
        System.out.println("----- Updated Event List -----");
        admin.viewAllEvents(eventManager);

        System.out.println();

        // Service Request Demo
        System.out.println("----- Service Request -----");

        ServiceRequest request = alice.submitRequest(
                "R1",
                "Pothole on Main Street");

        manager.updateRequestStatus(request, RequestStatus.IN_PROGRESS);
        manager.updateRequestStatus(request, RequestStatus.RESOLVED);

        System.out.println();

        // Observer Demo
        System.out.println("----- Bob Unsubscribes -----");

        nm.detachObserver(bob);

        ServiceRequest request2 = alice.submitRequest(
                "R2",
                "Broken Streetlight");

        manager.updateRequestStatus(request2, RequestStatus.RESOLVED);

        System.out.println();

        System.out.println("Total Events Remaining: " + eventManager.getTotalEvents());

        System.out.println("\n=== Demo Complete ===");
    }
}