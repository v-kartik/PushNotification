package com.example.PushNotification.Service;

import com.example.PushNotification.Model.PushNotificationRequest;

public interface PushNotificationService {

    public void sendPushNotification(PushNotificationRequest request);
    public void sendPushNotificationWithoutData(PushNotificationRequest request);
    public void sendPushNotificationToToken(PushNotificationRequest request);
}
