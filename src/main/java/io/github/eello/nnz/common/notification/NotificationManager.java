package io.github.eello.nnz.common.notification;

public class NotificationManager {

    private final MattermostSender mmSender;

    public NotificationManager(MattermostSender mmSender) {
        this.mmSender = mmSender;
    }

    public void sendNotification(Exception e, String uri, String params) {
        mmSender.sendMessage(e, uri, params);
    }

}