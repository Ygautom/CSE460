package smartcityhub.model;

import smartcityhub.patterns.NotificationManager;

/**
 * ServiceRequest entity from the Phase II class diagram.
 * Attributes: requestId, description, status, dateSubmitted.
 *
 * When updateStatus() is called, it routes a notification through the single
 * NotificationManager, which broadcasts to all subscribed citizens (Observer pattern).
 */
public class ServiceRequest {
    private String requestId;
    private String description;
    private RequestStatus status;
    private java.util.Date dateSubmitted;

    public ServiceRequest(String requestId, String description) {
        this.requestId = requestId;
        this.description = description;
        this.status = RequestStatus.OPEN;
        this.dateSubmitted = new java.util.Date();
    }

    public void submitRequest() {
        System.out.println("Service request " + requestId + " submitted: " + description);
    }

    public void updateStatus(RequestStatus newStatus) {
        this.status = newStatus;
        // Notify citizens through the single shared NotificationManager.
        NotificationManager.getInstance().sendNotification(
            "Request " + requestId + " (" + description + ") is now " + newStatus);
    }

    public RequestStatus getStatus() { return status; }
    public String getRequestId() { return requestId; }
}
