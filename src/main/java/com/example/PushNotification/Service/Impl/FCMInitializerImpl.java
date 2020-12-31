package com.example.PushNotification.Service.Impl;

import com.example.PushNotification.Service.FCMInitializer;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class FCMInitializerImpl implements FCMInitializer {
    @Value("${app.firebase-configuration-file}")
    private String firebaseConfigPath;
//    Logger logger = LoggerFactory.getLogger(FCMInitializer.class);
    @Deprecated
    @PostConstruct
    public void initialize() {
        try {

            System.out.println(firebaseConfigPath);
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(new ClassPathResource(firebaseConfigPath).getInputStream()))
                    .setDatabaseUrl("https://water-manager-bc941.firebaseio.com")
                    .build();
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
                System.out.println("Firebase application has been initialized");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
