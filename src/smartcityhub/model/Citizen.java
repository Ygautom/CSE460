package smartcityhub.model;

import smartcityhub.patterns.Observer;

/**
 * Citizen from the Phase II class diagram - inherits User and implements
 * Observer.
 * A Citizen subscribes to the NotificationManager and is notified via update().
 */
public class Citizen extends User implements Observer {

    public Citizen(String userId, String name, String email, String password) {
        super(userId, name, email, password);
    }

    public void registerForEvent(Event event) {
        event.registerCitizen(this);
    }

    public ServiceRequest submitRequest(String requestId, String description) {
        ServiceRequest request = new ServiceRequest(requestId, description);
        request.submitRequest();
        return request;
    }

    // NEW: submit a typed request built by ServiceRequestFactory
    public ServiceRequest submitTypedRequest(String type, String requestId, String description) {
        ServiceRequest request =
                smartcityhub.patterns.ServiceRequestFactory.createRequest(type, requestId, description);
        request.submitRequest();
        return request;
    }

    @Override
    public void update(Notification notification) {
        System.out.println("  -> " + name + " received notification: " + notification.getMessage());
    }
}
