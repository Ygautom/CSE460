package smartcityhub.app;

import java.time.LocalDate;
import smartcityhub.model.*;
import smartcityhub.patterns.NotificationManager;

public class SmartCityHubApp {
    public static void main(String[] args) {
        System.out.println("=== SmartCity Hub - Full Functionality Demo ===\n");

        Administrator admin = new Administrator("A1", "Saideep", "admin@city.gov", "pw");
        DepartmentManager manager = new DepartmentManager("M1", "Yash", "manager@city.gov", "pw");
        Citizen alice = new Citizen("C1", "Alice", "alice@email.com", "pw");
        Citizen bob = new Citizen("C2", "Bob", "bob@email.com", "pw");

        System.out.println("----- Authentication -----");
        AuthService auth = new AuthService();
        auth.registerUser(admin);
        auth.registerUser(manager);
        auth.registerUser(alice);
        auth.registerUser(bob);
        auth.login("alice@email.com", "pw");
        auth.login("bob@email.com", "wrongpw");

        EventManager eventManager = new EventManager();
        ServiceRequestManager requestManager = new ServiceRequestManager();

        NotificationManager notificationManager = NotificationManager.getInstance();
        notificationManager.attachObserver(alice);
        notificationManager.attachObserver(bob);

        System.out.println("\n----- Singleton + Observer Setup -----");
        System.out.println("Subscribed observers: " + notificationManager.getObserverCount());
        System.out.println("Same NotificationManager instance? "
                + (notificationManager == NotificationManager.getInstance()));

        System.out.println("\n----- Admin Creates Events in Required Categories -----");
        Event music = admin.createEvent("MUSIC", "E1", "Downtown Jazz Night",
                LocalDate.now().plusDays(2), "Downtown", "Local live music and food trucks", true, 92);
        Event tech = admin.createEvent("TECH", "E2", "Smart City App Workshop",
                LocalDate.now().plusDays(4), "Innovation Center", "Learn civic technology tools", true, 88);
        Event sports = admin.createEvent("SPORTS", "E3", "Community Soccer Cup",
                LocalDate.now().plusDays(5), "City Park", "Weekend neighborhood tournament", false, 79);
        Event social = admin.createEvent("SOCIAL", "E4", "Neighborhood Mixer",
                LocalDate.now().plusDays(3), "Community Hall", "Meet residents and city volunteers", true, 67);
        Event career = admin.createEvent("CAREER", "E5", "City Jobs Fair",
                LocalDate.now().plusDays(6), "Downtown", "Career booths and resume reviews", true, 95);
        Event environment = admin.createEvent("ENVIRONMENT", "E6", "River Cleanup",
                LocalDate.now().plusDays(7), "Riverside", "Volunteer cleanup event", true, 73);

        eventManager.addEvent(music);
        eventManager.addEvent(tech);
        eventManager.addEvent(sports);
        eventManager.addEvent(social);
        eventManager.addEvent(career);
        eventManager.addEvent(environment);

        System.out.println("\n----- Event Discovery: Browse Upcoming Events Sorted By Category -----");
        eventManager.displayUpcomingEventsSortedByCategory();

        System.out.println("\n----- Event Discovery: Required Search Filters -----");
        eventManager.searchByCategory("music");
        eventManager.searchByLocation("Downtown");
        eventManager.searchByFreePaid(true);
        eventManager.searchByMinimumPopularity(85);
        eventManager.searchByDate(LocalDate.now().plusDays(4));

        System.out.println("\n----- Event Discovery: Combined Filters -----");
        eventManager.displayFilteredEvents("tech", LocalDate.now().plusDays(4),
                "Innovation Center", true, 80);

        System.out.println("\n----- Event Registration -----");
        alice.registerForEvent(music);
        bob.registerForEvent(career);
        alice.registerForEvent(tech);
        music.displayParticipants();
        career.displayParticipants();

        System.out.println("\n----- Service Request Submission -----");
        ServiceRequest pothole = alice.submitTypedRequest("POTHOLE", "R1",
                "Large pothole on Main Street");
        ServiceRequest waterLeak = bob.submitTypedRequest("WATER_LEAK", "R2",
                "Water leak near City Park fountain");
        ServiceRequest streetlight = alice.submitTypedRequest("BROKEN_STREETLIGHT", "R3",
                "Streetlight is out on 5th Avenue");

        requestManager.addRequest(pothole);
        requestManager.addRequest(waterLeak);
        requestManager.addRequest(streetlight);

        System.out.println("\n----- Residents Track Their Own Service Request Progress -----");
        alice.viewMyRequests();
        bob.viewMyRequests();

        System.out.println("\n----- City Department Updates Service Request Progress -----");
        manager.assignTask(pothole);
        manager.updateRequestStatus(pothole, RequestStatus.IN_PROGRESS);
        manager.updateRequestStatus(pothole, RequestStatus.RESOLVED);

        manager.assignTask(waterLeak);
        manager.updateRequestStatus(waterLeak, RequestStatus.IN_PROGRESS);

        manager.assignTask(streetlight);
        manager.updateRequestStatus(streetlight, RequestStatus.CLOSED);

        System.out.println("\n----- Residents Track Updated Progress -----");
        alice.viewMyRequests();
        bob.viewMyRequests();

        // ===== Added from your version =====
        System.out.println("\n----- Bob Unsubscribes -----");
        notificationManager.detachObserver(bob);

        ServiceRequest request4 = alice.submitTypedRequest(
                "BROKEN_STREETLIGHT",
                "R4",
                "Another broken streetlight reported after Bob unsubscribed");

        requestManager.addRequest(request4);

        manager.assignTask(request4);
        manager.updateRequestStatus(request4, RequestStatus.RESOLVED);
        // ================================

        System.out.println("\n----- Department Manager Dashboard and Reports -----");
        manager.viewAssignedRequests(requestManager);
        manager.generateEventReport(eventManager);
        manager.generateRequestReport(requestManager);

        System.out.println("\n----- Admin Dashboard -----");
        admin.showAdminDashboard(eventManager, requestManager);

        System.out.println("\n=== Demo Complete ===");
    }
}