package com.hoangjunss.Timetable.service.loginService;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    private WebDriver webDriver;
    @Override
    public String login(String username, String password) {
        try {
            // Truy cập trang đăng nhập
            webDriver.get("https://thongtindaotao.sgu.edu.vn/#/home");

            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
            wait.until((ExpectedCondition<Boolean>) wd ->
                    ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
            );    Thread.sleep(5000);

            try {
                // Đợi cho đến khi trường username có thể tương tác
                WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
                if (usernameField.isEnabled()) {

                    usernameField.sendKeys(username);
                } else {
                    System.out.println("Username field is disabled.");
                }

                // Đợi cho đến khi trường password có thể tương tác
                WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
                // Thay 'password' bằng ID thật của trường này
                if (passwordField.isEnabled()){

                    passwordField.sendKeys(password);
                }

                // Đợi cho đến khi nút đăng nhập có thể nhấn
                WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-primary")));
                loginButton.click();
                WebElement profileButton = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                        .until(ExpectedConditions.visibilityOfElementLocated(By.className("table-responsive"))); // Thay ID bằng id của phần tử bạn mong đợi


                // Chờ trang tải xong và kiểm tra kết quả đăng nhập nếu cần
                Thread.sleep(3000);
            }catch (Exception e) {
                e.printStackTrace();

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return "oki";
    }
}
