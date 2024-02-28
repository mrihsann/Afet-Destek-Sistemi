package com.boyslab.ads.service.helpers;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
@Service
public final class FirebaseCloudStorage {
    @PostConstruct
    public void initialize() {

        try {
            ClassPathResource resource = new ClassPathResource("adss-b5b09-firebase-adminsdk-hp0sb-4167e4ef19.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(resource.getInputStream()))
                    .setDatabaseUrl("https://adss-b5b09-default-rtdb.firebaseio.com")
                    .setStorageBucket("adss-b5b09.appspot.com")
                    .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
