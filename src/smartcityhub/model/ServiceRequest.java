package smartcityhub.model;

import java.time.LocalDateTime;
import smartcityhub.patterns.NotificationManager;

public class ServiceRequest {
    private String requestId;
    private String description;
    private RequestStatus status;
    private LocalDateTime dateSubmitted;
    private String issueType;
    private String assignedTo;
    private String submittedByUserId;
    private String submittedByName;

    public ServiceRequest(String requestId, String description) {
        this(requestId, description, "GENERAL");
    }

    public ServiceRequest(String requestId, String description, String issueType) {
        this.requestId = requestId;
        this.description = description;
        this.issueType = issueType;
        this.status = RequestStatus.OPEN;
        this.dateSubmitted = LocalDateTime.now();
        this.assignedTo = null;
        this.submittedByUserId = null;
        this.submittedByName = null;
    }

    public void submitRequest() {
        System.out.println("Service request " + requestId + " submitted: " + description);
    }

    public void submitRequest(Citizen citizen) {
        this.submittedByUserId = citizen.getUserId();
        this.submittedByName = citizen.getName();
        System.out.println(citizen.getName() + " submitted service request "
                + requestId + " (" + issueType + "): " + description);
    }

    // Added from your version for compatibility
    public void displayStatus() {
        System.out.println("Current Status: " + status);
    }

    public void updateStatus(RequestStatus newStatus) {
        this.status = newStatus;
        NotificationManager.getInstance().sendNotification(
                "Request " + requestId + " (" + description + ") is now " + newStatus);
    }

    public void assignTo(String managerName) {
        this.assignedTo = managerName;
        System.out.println("Request " + requestId + " assigned to " + managerName);
    }

    public void displayProgress() {
        String assigned = assignedTo == null ? "unassigned" : assignedTo;
        String submitter = submittedByName == null ? "unknown" : submittedByName;
        System.out.println("- " + requestId
                + " | Type: " + issueType
                + " | Status: " + status
                + " | Assigned: " + assigned
                + " | Submitted by: " + submitter
                + " | Description: " + description);
    }

    public String getRequestId() {
        return requestId;
    }

    public String getDescription() {
        return description;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public LocalDateTime getDateSubmitted() {
        return dateSubmitted;
    }

    public String getIssueType() {
        return issueType;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public String getSubmittedByUserId() {
        return submittedByUserId;
    }

    public String getSubmittedByName() {
        return submittedByName;
    }
}