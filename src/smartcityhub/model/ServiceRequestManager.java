package smartcityhub.model;

import java.util.ArrayList;
import java.util.List;

/**
 * NEW: ServiceRequestManager mirrors EventManager but for service requests.
 * It stores every submitted request and supports lookup and filtering by status,
 * which the Administrator's "Review Service Requests" use case (Phase I) needs.
 */
public class ServiceRequestManager {

    private List<ServiceRequest> requests;

    public ServiceRequestManager() {
        requests = new ArrayList<>();
    }

    public void addRequest(ServiceRequest request) {
        requests.add(request);
    }

    public ServiceRequest findRequestById(String requestId) {
        for (ServiceRequest r : requests) {
            if (r.getRequestId().equals(requestId)) {
                return r;
            }
        }
        return null;
    }

    public void displayByStatus(RequestStatus status) {
        System.out.println("\nRequests with status " + status + ":");

        boolean found = false;

        for (ServiceRequest r : requests) {
            if (r.getStatus() == status) {
                System.out.println("- " + r.getRequestId() + " (" + r.getIssueType()
                        + "): " + r.getDescription());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No requests found.");
        }
    }

    public void displayAllRequests() {
        if (requests.isEmpty()) {
            System.out.println("No requests available.");
            return;
        }

        System.out.println("\n===== ALL SERVICE REQUESTS =====");

        for (ServiceRequest r : requests) {
            String assigned = (r.getAssignedTo() == null) ? "unassigned" : r.getAssignedTo();
            System.out.println("- " + r.getRequestId() + " (" + r.getIssueType() + ") ["
                    + r.getStatus() + "] -> " + assigned);
        }
    }

    public int countByStatus(RequestStatus status) {
        int count = 0;
        for (ServiceRequest r : requests) {
            if (r.getStatus() == status) {
                count++;
            }
        }
        return count;
    }

    public int getTotalRequests() {
        return requests.size();
    }

    public List<ServiceRequest> getRequests() {
        return requests;
    }
}
