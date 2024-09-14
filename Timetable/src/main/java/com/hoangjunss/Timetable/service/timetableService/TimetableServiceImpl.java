package com.hoangjunss.Timetable.service.timetableService;

import com.hoangjunss.Timetable.service.loginService.LoginService;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
public class TimetableServiceImpl implements TimetableService{
    @Autowired
    private WebDriver webDriver;
    @Autowired
    private LoginService loginService;
    @Override
    public String getTimetable(String username,String password) {
        try {
            loginService.login(username,password);
            // Truy cập trang đăng nhập
            webDriver.get("https://thongtindaotao.sgu.edu.vn/#/tkb-tuan");

            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
            wait.until((ExpectedCondition<Boolean>) wd ->
                    ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
            );    Thread.sleep(5000);

            try {
                WebElement tableDad = webDriver.findElement(By.className("table-responsive-sm"));
                WebElement table = tableDad.findElement(By.tagName("table"));

                // Lấy tất cả các hàng của bảng
                WebElement rows = table.findElement(By.tagName("tr"));

                // Duyệt qua từng hàng và lấy dữ liệu của các cột
                List<List<String>> tableData = new ArrayList<>();
                    List<WebElement> columns = rows.findElements(By.tagName("td"));
                List<String> rowData = new ArrayList<>();
                    for (WebElement column : columns) {

                        // Lấy nội dung của từng cột
                        rowData.add(column.findElement(By.tagName("span")).getText());
                    }
                   tableData.add(rowData);

                WebElement tbody = table.findElement(By.tagName("tbody"));
                List<WebElement> rowsTBody = tbody.findElements(By.tagName("tr"));
                for (WebElement row : rowsTBody) {
                    List<WebElement> columnsRowsTbody = row.findElements(By.tagName("td"));
                    List<String> rowDataBody = new ArrayList<>();
                    for (WebElement column:columnsRowsTbody){
                        try {
                            // Tìm phần tử span bên trong column
                            WebElement spanElement = column.findElement(By.tagName("span"));
                            // Lấy văn bản của phần tử
                            String text = spanElement.getText();
                            rowDataBody.add(text); // Thêm văn bản vào tableData
                        } catch (NoSuchElementException e) {
                            // Nếu không tìm thấy phần tử span, thêm khoảng cách
                            rowDataBody.add(" ");
                        }
                    }
                    // Lấy nội dung của từng cột
                    tableData.add(rowDataBody);

                }


                Thread.sleep(3000);
                return tableData.toString();
            }catch (Exception e) {
                e.printStackTrace();

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return "false";
    }
}
