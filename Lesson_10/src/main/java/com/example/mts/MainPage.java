package com.example.mts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;
    
    // Service tabs
    @FindBy(xpath = "//button[contains(text(), 'Услуги связи')]")
    private WebElement connectionServiceTab;
    
    @FindBy(xpath = "//button[contains(text(), 'Домашний интернет')]")
    private WebElement homeInternetTab;
    
    @FindBy(xpath = "//button[contains(text(), 'Рассрочка')]")
    private WebElement installmentTab;
    
    @FindBy(xpath = "//button[contains(text(), 'Задолженность')]")
    private WebElement debtTab;
    
    // Input fields
    @FindBy(xpath = "//input[@placeholder='Номер телефона']")
    private WebElement phoneNumberInput;
    
    @FindBy(xpath = "//input[@placeholder='Номер счета']")
    private WebElement accountNumberInput;
    
    @FindBy(xpath = "//input[@placeholder='Сумма']")
    private WebElement amountInput;
    
    @FindBy(xpath = "//input[@placeholder='Номер карты']")
    private WebElement cardNumberInput;
    
    @FindBy(xpath = "//input[@placeholder='Срок действия']")
    private WebElement expiryDateInput;
    
    @FindBy(xpath = "//input[@placeholder='CVC']")
    private WebElement cvcInput;
    
    @FindBy(xpath = "//input[@placeholder='Имя держателя']")
    private WebElement cardHolderInput;
    
    // Buttons
    @FindBy(xpath = "//button[contains(text(), 'Продолжить')]")
    private WebElement continueButton;
    
    @FindBy(xpath = "//button[contains(text(), 'Оплатить')]")
    private WebElement payButton;
    
    // Payment info
    @FindBy(xpath = "//div[contains(@class, 'payment-info')]//span[contains(@class, 'phone')]")
    private WebElement paymentPhoneNumber;
    
    @FindBy(xpath = "//div[contains(@class, 'payment-info')]//span[contains(@class, 'amount')]")
    private WebElement paymentAmount;
    
    @FindBy(xpath = "//button[contains(@class, 'pay-button')]//span[contains(@class, 'amount')]")
    private WebElement buttonAmount;
    
    // Payment system icons
    @FindBy(xpath = "//div[contains(@class, 'payment-icons')]//img")
    private List<WebElement> paymentIcons;
    
    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getTimeout()));
        PageFactory.initElements(driver, this);
    }
    
    public void open() {
        driver.get(ConfigReader.getUrl());
        waitForPageToLoad();
    }
    
    private void waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOf(connectionServiceTab));
    }
    
    // Service tab selection methods
    public void selectConnectionService() {
        wait.until(ExpectedConditions.elementToBeClickable(connectionServiceTab)).click();
    }
    
    public void selectHomeInternet() {
        wait.until(ExpectedConditions.elementToBeClickable(homeInternetTab)).click();
    }
    
    public void selectInstallment() {
        wait.until(ExpectedConditions.elementToBeClickable(installmentTab)).click();
    }
    
    public void selectDebt() {
        wait.until(ExpectedConditions.elementToBeClickable(debtTab)).click();
    }
    
    // Input field methods
    public void enterPhoneNumber(String phone) {
        wait.until(ExpectedConditions.visibilityOf(phoneNumberInput)).clear();
        phoneNumberInput.sendKeys(phone);
    }
    
    public void enterAccountNumber(String account) {
        wait.until(ExpectedConditions.visibilityOf(accountNumberInput)).clear();
        accountNumberInput.sendKeys(account);
    }
    
    public void enterAmount(String amount) {
        wait.until(ExpectedConditions.visibilityOf(amountInput)).clear();
        amountInput.sendKeys(amount);
    }
    
    public void enterCardNumber(String cardNumber) {
        wait.until(ExpectedConditions.visibilityOf(cardNumberInput)).clear();
        cardNumberInput.sendKeys(cardNumber);
    }
    
    public void enterExpiryDate(String expiry) {
        wait.until(ExpectedConditions.visibilityOf(expiryDateInput)).clear();
        expiryDateInput.sendKeys(expiry);
    }
    
    public void enterCVC(String cvc) {
        wait.until(ExpectedConditions.visibilityOf(cvcInput)).clear();
        cvcInput.sendKeys(cvc);
    }
    
    public void enterCardHolder(String holder) {
        wait.until(ExpectedConditions.visibilityOf(cardHolderInput)).clear();
        cardHolderInput.sendKeys(holder);
    }
    
    // Get placeholder methods
    public String getPhoneNumberPlaceholder() {
        return phoneNumberInput.getAttribute("placeholder");
    }
    
    public String getAccountNumberPlaceholder() {
        return accountNumberInput.getAttribute("placeholder");
    }
    
    public String getAmountPlaceholder() {
        return amountInput.getAttribute("placeholder");
    }
    
    public String getCardNumberPlaceholder() {
        return cardNumberInput.getAttribute("placeholder");
    }
    
    public String getExpiryDatePlaceholder() {
        return expiryDateInput.getAttribute("placeholder");
    }
    
    public String getCVCPlaceholder() {
        return cvcInput.getAttribute("placeholder");
    }
    
    public String getCardHolderPlaceholder() {
        return cardHolderInput.getAttribute("placeholder");
    }
    
    // Action methods
    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }
    
    public void clickPay() {
        WebDriverWait paymentWait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getPaymentTimeout()));
        paymentWait.until(ExpectedConditions.elementToBeClickable(payButton)).click();
    }
    
    // Payment info verification
    public String getPaymentPhoneNumber() {
        WebDriverWait paymentWait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getPaymentTimeout()));
        paymentWait.until(ExpectedConditions.visibilityOf(paymentPhoneNumber));
        return paymentPhoneNumber.getText();
    }
    
    public String getPaymentAmount() {
        return paymentAmount.getText();
    }
    
    public String getButtonAmount() {
        return buttonAmount.getText();
    }
    
    // Payment icons verification
    public int getPaymentIconsCount() {
        return paymentIcons.size();
    }
    
    public boolean isPaymentIconDisplayed(String iconName) {
        for (WebElement icon : paymentIcons) {
            String alt = icon.getAttribute("alt");
            String src = icon.getAttribute("src");
            if ((alt != null && alt.toLowerCase().contains(iconName.toLowerCase())) ||
                (src != null && src.toLowerCase().contains(iconName.toLowerCase()))) {
                return true;
            }
        }
        return false;
    }
    
    // Check if payment form is displayed
    public boolean isPaymentFormDisplayed() {
        try {
            WebDriverWait paymentWait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getPaymentTimeout()));
            paymentWait.until(ExpectedConditions.visibilityOf(cardNumberInput));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}