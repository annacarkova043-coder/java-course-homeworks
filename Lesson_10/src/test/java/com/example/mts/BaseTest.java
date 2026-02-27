package com.example.mts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;
    protected MainPage mainPage;
    
    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.createDriver();
        mainPage = new MainPage(driver);
        mainPage.open();
    }
    
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}