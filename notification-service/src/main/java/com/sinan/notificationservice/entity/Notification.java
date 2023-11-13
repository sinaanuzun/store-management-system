package com.sinan.notificationservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Notification {

    private String title;
    private String body;
    private String recipient;

}