package smartcityhub.patterns;

import smartcityhub.model.Notification;

public interface Observer {
    void update(Notification notification);
}
