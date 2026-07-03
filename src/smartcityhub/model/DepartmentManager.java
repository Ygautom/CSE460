package smartcityhub.model;

public class DepartmentManager extends User {
    public DepartmentManager(String userId, String name, String email, String password) {
        super(userId, name, email, password);
    }

    public void assignTask(ServiceRequest request) {
        System.out.println(name + " (Dept. Manager) assigning request " + request.getRequestId());
        request.assignTo(name);
    }

    public void updateRequestStatus(ServiceRequest request, RequestStatus status) {
        System.out.println(name + " (Dept. Manager) updating request "
                + request.getRequestId() + " to " + status);
        request.updateStatus(status);
    }

    public void viewAssignedRequests(ServiceRequestManager requestManager) {
        requestManager.displayAssignedTo(name);
    }

    public void generateEventReport(EventManager eventManager) {
        System.out.println("\n===== EVENT REPORT =====");
        System.out.println("Total Events: " + eventManager.getTotalEvents());
    }

    public void generateRequestReport(ServiceRequestManager requestManager) {
        System.out.println("\n===== SERVICE REQUEST REPORT =====");
        System.out.println("Total Requests: " + requestManager.getTotalRequests());
        System.out.println("Open:        " + requestManager.countByStatus(RequestStatus.OPEN));
        System.out.println("In Progress: " + requestManager.countByStatus(RequestStatus.IN_PROGRESS));
        System.out.println("Resolved:    " + requestManager.countByStatus(RequestStatus.RESOLVED));
        System.out.println("Closed:      " + requestManager.countByStatus(RequestStatus.CLOSED));
    }
}
