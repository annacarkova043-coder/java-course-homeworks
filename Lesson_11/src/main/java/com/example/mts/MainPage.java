package com.example.mts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;
    
    @FindBy(xpath = "//button[contains(text(), 'Услуги связи')]")
    private WebElement connectionServiceTab;
    
    @FindBy(xpath = "//input[@placeholder='Номер телефона']")
    private WebElement phoneNumberInput;
    
    @FindBy(xpath = "//input[@placeholder='Сумма']")
    private WebElement amountInput;
    
    @FindBy(xpath = "//button[contains(text(), 'Продолжить')]")
    private WebElement continueButton;
    
    @FindBy(xpath = "//div[contains(@class, 'payment-info')]//span[contains(@class, 'phone')]")
    private WebElement paymentPhoneNumber;
    
    @FindBy(xpath = "//div[contains(@class, 'payment-info')]//span[contains(@class, 'amount')]")
    private WebElement paymentAmount;
    
    @FindBy(xpath = "//input[@placeholder='Номер карты']")
    private WebElement cardNumberInput;
    
    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getTimeout()));
        PageFactory.initElements(driver, this);
    }
    
    public void open() {
        driver.get(ConfigReader.getUrl());
        wait.until(ExpectedConditions.visibilityOf(connectionServiceTab));
    }
    
    public void selectConnectionService() {
        wait.until(ExpectedConditions.elementToBeClickable(connectionServiceTab)).click();
    }
    
    public void enterPhoneNumber(String phone) {
        wait.until(ExpectedConditions.visibilityOf(phoneNumberInput)).sendKeys(phone);
    }
    
    public void enterAmount(String amount) {
        wait.until(ExpectedConditions.visibilityOf(amountInput)).sendKeys(amount);
    }
    
    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }
    
    public boolean isPaymentFormDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(cardNumberInput));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public String getPaymentPhoneNumber() {
        return paymentPhoneNumber.getText();
    }
    
    public String getPaymentAmount() {
        return paymentAmount.getText();
    }
}