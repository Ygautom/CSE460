package smartcityhub.patterns;

import smartcityhub.model.ServiceRequest;

/**
 * Factory Method pattern - ServiceRequestFactory.
 * The Phase II design document names a ServiceRequestFactory alongside EventFactory.
 * createRequest(type) stamps the request with its issue type (POTHOLE, GRAFFITI,
 * WATER_LEAK, NOISE_COMPLAINT) so the rest of the system never hardcodes those
 * categories. Adding a new request type means editing only this factory.
 */
public class ServiceRequestFactory {

    public static ServiceRequest createRequest(String type, String requestId,
                                               String description) {
        switch (type.toUpperCase()) {
            case "POTHOLE":
            case "GRAFFITI":
            case "WATER_LEAK":
            case "NOISE_COMPLAINT":
            case "BROKEN_STREETLIGHT":
                return new ServiceRequest(requestId, description, type.toUpperCase());
            default:
                throw new IllegalArgumentException("Unknown request type: " + type);
        }
    }
}
