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

    // NEW: issue type (POTHOLE, GRAFFITI, etc.) and the manager it is assigned to
    private String issueType;
    private String assignedTo;

    public ServiceRequest(String requestId, String description) {
        this(requestId, description, "GENERAL");
    }

    // NEW: typed constructor used by ServiceRequestFactory
    public ServiceRequest(String requestId, String description, String issueType) {
        this.requestId = requestId;
        this.description = description;
        this.issueType = issueType;
        this.status = RequestStatus.OPEN;
        this.dateSubmitted = new java.util.Date();
        this.assignedTo = null;
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

    // NEW: accessors for type/assignment used by the manager and report
    public String getIssueType() { return issueType; }
    public String getDescription() { return description; }
    public String getAssignedTo() { return assignedTo; }

    public void assignTo(String managerName) {
        this.assignedTo = managerName;
        System.out.println("Request " + requestId + " assigned to " + managerName);
    }
}
