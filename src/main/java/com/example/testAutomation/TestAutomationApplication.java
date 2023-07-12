package com.example.testautomation;

import com.example.testautomation.tests.LoginTest;
import org.testng.TestNG;
import org.testng.annotations.Test;

public class TestAutomationApplication {

    @Test
    public void runTestAutomation() {
        TestNG testNG = new TestNG();
        testNG.setTestClasses(new Class[]{LoginTest.class});
        testNG.run();
    }

    public static void main(String[] args) {
        TestAutomationApplication app = new TestAutomationApplication();
        app.runTestAutomation();
    }
}
