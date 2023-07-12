package com.example.testautomation.tests;

import com.example.testautomation.config.ConfigReader;
import com.example.testautomation.framework.TestBase;
import com.example.testautomation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    private LoginPage loginPage;
    private ConfigReader configReader;

    @BeforeMethod
    public void setUp() {
        initializeDriver();
        loginPage = new LoginPage(driver);
        configReader = new ConfigReader();
    }

    @Test
    public void successfulLoginTest() {
        loginPage.navigateToLoginPage();
        loginPage.enterUsername(configReader.getDefaultUsername());
        loginPage.enterPassword(configReader.getDefaultPassword());
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login was not successful");
    }

    @Test
    public void invalidCredentialsTest() {
        loginPage.navigateToLoginPage();
        loginPage.enterUsername("invalidusername");
        loginPage.enterPassword("invalidpassword");
        loginPage.clickLoginButton();
        Assert.assertFalse(loginPage.isLoginSuccessful(), "Login was successful with invalid credentials");
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}
