package com.hoangjunss.Timetable;

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
    private WebDriver webDriver;

    @PostMapping("/get")
    public String getTimetable(@RequestParam String username, @RequestParam String password) {
        try {
            // Truy cập trang đăng nhập
            webDriver.get("https://thongtindaotao.sgu.edu.vn/#/home");

            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

            try {
                // Đợi cho đến khi trường username có thể tương tác
                WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
                usernameField.sendKeys(username);

                // Đợi cho đến khi trường password có thể tương tác
                WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.name("password"))); // Thay 'password' bằng ID thật của trường này
                passwordField.sendKeys(password);

                // Đợi cho đến khi nút đăng nhập có thể nhấn
                WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("btn")));
                loginButton.click();

                // Chờ trang tải xong và kiểm tra kết quả đăng nhập nếu cần
                Thread.sleep(3000);
            }catch (Exception e) {
               e.printStackTrace();
               return "Error  while accessing the login page.";
           }


        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while accessing the login page.";
        }
        return  "true";
    }
}