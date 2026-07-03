package smartcityhub.model;

import java.util.ArrayList;
import java.util.List;

public class ServiceRequestManager {
    private List<ServiceRequest> requests;

    public ServiceRequestManager() {
        requests = new ArrayList<>();
    }

    public void addRequest(ServiceRequest request) {
        requests.add(request);
    }

    public ServiceRequest findRequestById(String requestId) {
        for (ServiceRequest request : requests) {
            if (request.getRequestId().equalsIgnoreCase(requestId)) {
                return request;
            }
        }
        return null;
    }

    public void displayAllRequests() {
        System.out.println("\n===== ALL SERVICE REQUESTS =====");
        if (requests.isEmpty()) {
            System.out.println("No requests available.");
            return;
        }
        for (ServiceRequest request : requests) {
            request.displayProgress();
        }
    }

    public void displayByStatus(RequestStatus status) {
        System.out.println("\n===== REQUESTS WITH STATUS " + status + " =====");
        boolean found = false;
        for (ServiceRequest request : requests) {
            if (request.getStatus() == status) {
                request.displayProgress();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No requests found.");
        }
    }

    public void displayRequestsForCitizen(Citizen citizen) {
        System.out.println("\n===== REQUESTS SUBMITTED BY " + citizen.getName().toUpperCase() + " =====");
        boolean found = false;
        for (ServiceRequest request : requests) {
            if (citizen.getUserId().equals(request.getSubmittedByUserId())) {
                request.displayProgress();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No requests found.");
        }
    }

    public void displayAssignedTo(String managerName) {
        System.out.println("\n===== REQUESTS ASSIGNED TO " + managerName.toUpperCase() + " =====");
        boolean found = false;
        for (ServiceRequest request : requests) {
            if (managerName.equals(request.getAssignedTo())) {
                request.displayProgress();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No assigned requests found.");
        }
    }

    public int countByStatus(RequestStatus status) {
        int count = 0;
        for (ServiceRequest request : requests) {
            if (request.getStatus() == status) {
                count++;
            }
        }
        return count;
    }

    public int getTotalRequests() {
        return requests.size();
    }

    public List<ServiceRequest> getRequests() {
        return new ArrayList<>(requests);
    }
}
