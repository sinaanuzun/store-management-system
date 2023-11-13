package com.sinan.notificationservice.controller;

import com.sinan.notificationservice.entity.Notification;
import com.sinan.notificationservice.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/notification")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<?> sendSimpleMailMessage(@RequestBody Notification request) {
        notificationService.sendEmail(request.getTitle(), request.getBody(), request.getRecipient());
        return ResponseEntity.ok("E-posta başarıyla gönderildi.");
    }
}