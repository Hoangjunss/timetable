package com.hoangjunss.Timetable.config;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeleniumConfig {

    @Bean
    public WebDriver chromeDriver() {

        System.setProperty("webdriver.chrome.driver", "D:/personalProject/Timetable/chromedriver-win64/chromedriver.exe");
        //*ChromeOptions options = new ChromeOptions();

        // Thêm tùy chọn để chạy ChromeDriver trong chế độ headless
        /*options.addArguments("--headless");
        options.addArguments("--disable-gpu"); // Tùy chọn này thường cần thiết trên Windows
        options.addArguments("--no-sandbox");*/ // Tùy chọn này giúp tránh lỗi trên một số hệ điều hành


        return new ChromeDriver();
    }
}