package com.hoangjunss.Timetable;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/timetable")
public class TimetableController {

    @Autowired
    private WebDriver webDriver;

    @PostMapping("/get")
    public String getTimetable(@RequestParam String username, @RequestParam String password) {
        try {
            // Truy cập trang đăng nhập
            webDriver.get("https://thongtindaotao.sgu.edu.vn/#/home");

            // Kiểm tra nếu trang đã tải thành công bằng cách tìm một phần tử cụ thể


        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while accessing the login page.";
        }
        return  "true";
    }
}