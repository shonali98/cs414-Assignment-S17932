package com.example.testautomation.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryUtil {
    private WebDriver driver;

    public PageFactoryUtil(WebDriver driver) {
        this.driver = driver;
    }

    public <T> T initializePage(Class<T> pageClass) {
        return PageFactory.initElements(driver, pageClass);
    }
}
