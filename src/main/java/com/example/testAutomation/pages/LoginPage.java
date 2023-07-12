package com.example.testautomation.pages;

import com.example.testautomation.config.ConfigReader;
import com.example.testautomation.framework.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    private WebDriver driver;
    private ConfigReader configReader;

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(name = "pwd")
    private WebElement passwordField;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        configReader = new ConfigReader();
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginPage() {
        driver.get(configReader.getBaseUrl());
    }

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean isLoginSuccessful() {
        WebElement logoutButton = driver.findElement(By.id("logoutLink"));
        return logoutButton.isDisplayed();
    }
}
