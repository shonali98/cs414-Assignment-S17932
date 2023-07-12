package com.example.testautomation.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;

    public ConfigReader() {
        properties = new Properties();
        loadConfigProperties();
    }

    private void loadConfigProperties() {
        try (InputStream inputStream = new FileInputStream("src/main/resources/config/config.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBaseUrl() {
        return properties.getProperty("base.url");
    }

    public String getDefaultUsername() {
        return properties.getProperty("default.username");
    }

    public String getDefaultPassword() {
        return properties.getProperty("default.password");
    }

    public String getBrowser() {
        return properties.getProperty("browser");
    }

    public String getProjectName() {
        return properties.getProperty("project.name");
    }
}
