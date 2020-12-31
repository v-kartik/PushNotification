package com.example.PushNotification.Service;

import com.example.PushNotification.Model.PushNotificationRequest;

import java.util.Map;
import java.util.concurrent.ExecutionException;

public interface FCMService {

    public void sendMessage(Map<String, String> data, PushNotificationRequest request) throws InterruptedException, ExecutionException;
    public void sendMessageWithoutData(PushNotificationRequest request) throws InterruptedException, ExecutionException;
    public void sendMessageToToken(PushNotificationRequest request) throws InterruptedException, ExecutionException;
}
