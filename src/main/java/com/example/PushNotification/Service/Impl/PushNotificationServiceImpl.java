package com.example.PushNotification.Service.Impl;

import com.example.PushNotification.Model.PushNotificationRequest;
import com.example.PushNotification.Service.FCMService;
import com.example.PushNotification.Service.PushNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PushNotificationServiceImpl implements PushNotificationService {
    @Autowired
    private FCMService fcmService;

    public void sendPushNotification(PushNotificationRequest request) {
        try {
            fcmService.sendMessage(getSamplePayloadData(), request);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void sendPushNotificationWithoutData(PushNotificationRequest request) {
        try {
            fcmService.sendMessageWithoutData(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void sendPushNotificationToToken(PushNotificationRequest request) {
        try {
            fcmService.sendMessageToToken(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private Map<String, String> getSamplePayloadData() {
        Map<String, String> pushData = new HashMap<>();
        pushData.put("messageId", "msgid");
        pushData.put("text", "txt");
        pushData.put("user", "Kartik");
        return pushData;
    }
}
