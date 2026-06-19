package smartcityhub.app;

import smartcityhub.model.*;
import smartcityhub.patterns.NotificationManager;

/**
 * SmartCity Hub - Phase I demonstration driver.
 *
 * Exercises the three design patterns from the Phase II class diagram end to end:
 *   1. Factory Method  - Administrator uses EventFactory to create different Event types.
 *   2. Singleton       - one NotificationManager shared across the whole run.
 *   3. Observer        - Citizens subscribe and are notified on service-request updates.
 *
 * Run this and narrate the console output for the Phase III video.
 */
public class SmartCityHubApp {

    public static void main(String[] args) {
        System.out.println("=== SmartCity Hub - Phase I Demo ===\n");

        // --- Users ---
        Administrator admin = new Administrator("A1", "Saideep", "admin@city.gov", "pw");
        DepartmentManager manager = new DepartmentManager("M1", "Yash", "mgr@city.gov", "pw");
        Citizen alice = new Citizen("C1", "Alice", "alice@email.com", "pw");
        Citizen bob   = new Citizen("C2", "Bob", "bob@email.com", "pw");

        // --- Singleton: one shared NotificationManager ---
        NotificationManager nm = NotificationManager.getInstance();
        nm.attachObserver(alice);   // Observer: citizens subscribe
        nm.attachObserver(bob);
        System.out.println("Subscribed observers: " + nm.getObserverCount());

        // Prove it is a Singleton: a second getInstance() returns the same object.
        NotificationManager nm2 = NotificationManager.getInstance();
        System.out.println("Same NotificationManager instance? " + (nm == nm2));
        System.out.println();

        // --- Factory Method: create different event types without hardcoding classes ---
        System.out.println("--- Factory Method: creating events ---");
        Event e1 = admin.createEvent("SPORTS", "E1", "City Marathon", "Downtown", "Annual 10K run");
        Event e2 = admin.createEvent("ENVIRONMENT", "E2", "River Cleanup", "Riverside", "Volunteer cleanup");
        e1.displayDetails();
        e2.displayDetails();
        alice.registerForEvent(e1);
        System.out.println();

        // --- Observer: a service request status change notifies all citizens ---
        System.out.println("--- Observer: service request lifecycle ---");
        ServiceRequest req = alice.submitRequest("R1", "Pothole on Main St");
        manager.updateRequestStatus(req, RequestStatus.IN_PROGRESS);
        manager.updateRequestStatus(req, RequestStatus.RESOLVED);
        System.out.println();

        // --- Observer detach: Bob unsubscribes, only Alice is notified next ---
        System.out.println("--- Observer: Bob unsubscribes ---");
        nm.detachObserver(bob);
        ServiceRequest req2 = alice.submitRequest("R2", "Broken streetlight on 2nd Ave");
        manager.updateRequestStatus(req2, RequestStatus.RESOLVED);

        System.out.println("\n=== Demo complete ===");
    }
}
