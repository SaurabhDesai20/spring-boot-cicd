package com.spring_boot_app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/api/welcome")
public class WelcomeController {

    @Value("${spring.application.name:spring-boot-app}")
    private String appName;

    @GetMapping
    public String welcome() {
        return "welcome"; // resolves to templates/welcome.html
    }

    @GetMapping("/status")
    @ResponseBody
    public Map<String, Object> status() {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("app", appName);
        response.put("status", "UP");
        response.put("timestamp", LocalDateTime.now().toString());
        return response;
    }
}