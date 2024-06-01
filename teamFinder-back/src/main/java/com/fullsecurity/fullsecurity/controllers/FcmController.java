//package com.fullsecurity.fullsecurity.controllers;// FcmController.java
//import com.google.firebase.messaging.FirebaseMessaging;
//import com.google.firebase.messaging.Message;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class FcmController {
//
//    @Autowired
//    private FirebaseMessaging firebaseMessaging;
//
//    @PostMapping("/send-fcm")
//    public String sendFCMMessage(@RequestBody String token) {
//        Message message = Message.builder()
//                .setToken(token)
//                .putData("message", "Test")
//                .build();
//
//        try {
//            String response = firebaseMessaging.send(message);
//            return "FCM message sent: " + response;
//        } catch (Exception e) {
//            return "Error sending FCM message: " + e.getMessage();
//        }
//    }
//}
