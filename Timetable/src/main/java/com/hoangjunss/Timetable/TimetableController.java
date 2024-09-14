package com.hoangjunss.Timetable;

import com.hoangjunss.Timetable.service.loginService.LoginService;
import com.hoangjunss.Timetable.service.timetableService.TimetableService;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
@RequestMapping("/api/timetable")
public class TimetableController {
    @Autowired
    private TimetableService timetableService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private WebDriver webDriver;

    @PostMapping("/get")
    public String getTimetable(@RequestParam String username, @RequestParam String password) {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        return  timetableService.getTimetable(username, password);
    }
}