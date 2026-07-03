package smartcityhub.model;

import java.util.ArrayList;
import java.util.List;
import smartcityhub.patterns.Observer;
import smartcityhub.patterns.ServiceRequestFactory;

public class Citizen extends User implements Observer {
    private List<ServiceRequest> submittedRequests;

    public Citizen(String userId, String name, String email, String password) {
        super(userId, name, email, password);
        submittedRequests = new ArrayList<>();
    }

    public void registerForEvent(Event event) {
        event.registerCitizen(this);
    }

    public ServiceRequest submitRequest(String requestId, String description) {
        ServiceRequest request = new ServiceRequest(requestId, description);
        request.submitRequest(this);
        submittedRequests.add(request);
        return request;
    }

    public ServiceRequest submitTypedRequest(String type, String requestId, String description) {
        ServiceRequest request = ServiceRequestFactory.createRequest(type, requestId, description);
        request.submitRequest(this);
        submittedRequests.add(request);
        return request;
    }

    public void viewMyRequests() {
        System.out.println("\n===== " + name.toUpperCase() + "'S SERVICE REQUEST TRACKING =====");
        if (submittedRequests.isEmpty()) {
            System.out.println("No service requests submitted.");
            return;
        }
        for (ServiceRequest request : submittedRequests) {
            request.displayProgress();
        }
    }

    public List<ServiceRequest> getSubmittedRequests() {
        return new ArrayList<>(submittedRequests);
    }

    @Override
    public void update(Notification notification) {
        System.out.println("  -> " + name + " received notification: " + notification.getMessage());
    }
}
