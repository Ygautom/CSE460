package smartcityhub.model;

/**
 * DepartmentManager from the Phase II class diagram - inherits User.
 * Updates the status of assigned service requests (which triggers
 * notifications).
 */
public class DepartmentManager extends User {
    public DepartmentManager(String userId, String name, String email, String password) {
        super(userId, name, email, password);
    }

    public void updateRequestStatus(ServiceRequest request, RequestStatus status) {
        System.out.println(name + " (Dept. Manager) updating request "
                + request.getRequestId() + " to " + status);
        request.updateStatus(status);
    }

    public void generateReport(EventManager eventManager) {
        System.out.println("\n===== EVENT REPORT =====");
        System.out.println("Total Events: " + eventManager.getTotalEvents());
    }

}
