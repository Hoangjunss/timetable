package com.hoangjunss.Timetable.config;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeleniumConfig {

    @Bean
    public WebDriver chromeDriver() {

        System.setProperty("webdriver.chrome.driver", "chromedriver-win64/chromedriver.exe");


        return new ChromeDriver();
    }
}