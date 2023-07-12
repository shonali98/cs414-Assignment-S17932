package com.example.testautomation.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    private WebDriver driver;
    private String screenshotDir;

    public ScreenshotUtil(WebDriver driver, String screenshotDir) {
        this.driver = driver;
        this.screenshotDir = screenshotDir;
    }

    public void captureScreenshot(String screenshotName) {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = screenshotName + "_" + timestamp + ".png";
        Path destinationPath = Path.of(screenshotDir, fileName);

        try {
            Files.copy(screenshotFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot captured: " + destinationPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
