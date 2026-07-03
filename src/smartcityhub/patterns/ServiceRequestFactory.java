package smartcityhub.patterns;

import smartcityhub.model.ServiceRequest;

public class ServiceRequestFactory {
    public static ServiceRequest createRequest(String type, String requestId,
                                               String description) {
        switch (type.trim().replace('-', '_').replace(' ', '_').toUpperCase()) {
            case "POTHOLE":
            case "GRAFFITI":
            case "WATER_LEAK":
            case "NOISE_COMPLAINT":
            case "BROKEN_STREETLIGHT":
            case "TRASH_PICKUP":
                return new ServiceRequest(requestId, description,
                        type.trim().replace('-', '_').replace(' ', '_').toUpperCase());
            default:
                throw new IllegalArgumentException("Unknown request type: " + type);
        }
    }
}
