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
    
    // Locators
    private static final String ONLINE_PAYMENT_BLOCK_XPATH = "//div[contains(@class, 'online-payment')]";
    private static final String BLOCK_TITLE_XPATH = "//div[contains(@class, 'pay-title')]//h2";
    private static final String PAYMENT_SYSTEM_LOGOS_XPATH = "//div[contains(@class, 'payment-logos')]//img";
    private static final String MORE_INFO_LINK_XPATH = "//a[contains(text(), 'Подробнее о сервисе')]";
    private static final String CONNECTION_SERVICE_TAB_XPATH = "//button[contains(text(), 'Услуги связи')]";
    private static final String PHONE_NUMBER_INPUT_XPATH = "//input[@placeholder='Номер телефона']";
    private static final String AMOUNT_INPUT_XPATH = "//input[@placeholder='Сумма']";
    private static final String CONTINUE_BUTTON_XPATH = "//button[contains(text(), 'Продолжить')]";
    
    @FindBy(xpath = BLOCK_TITLE_XPATH)
    private WebElement blockTitle;
    
    @FindBy(xpath = PAYMENT_SYSTEM_LOGOS_XPATH)
    private List<WebElement> paymentLogos;
    
    @FindBy(xpath = MORE_INFO_LINK_XPATH)
    private WebElement moreInfoLink;
    
    @FindBy(xpath = CONNECTION_SERVICE_TAB_XPATH)
    private WebElement connectionServiceTab;
    
    @FindBy(xpath = PHONE_NUMBER_INPUT_XPATH)
    private WebElement phoneNumberInput;
    
    @FindBy(xpath = AMOUNT_INPUT_XPATH)
    private WebElement amountInput;
    
    @FindBy(xpath = CONTINUE_BUTTON_XPATH)
    private WebElement continueButton;
    
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath(ONLINE_PAYMENT_BLOCK_XPATH)));
    }
    
    public String getBlockTitle() {
        wait.until(ExpectedConditions.visibilityOf(blockTitle));
        return blockTitle.getText();
    }
    
    public int getPaymentLogosCount() {
        return paymentLogos.size();
    }
    
    public boolean isPaymentLogoDisplayed(String logoName) {
        for (WebElement logo : paymentLogos) {
            String alt = logo.getAttribute("alt");
            String src = logo.getAttribute("src");
            if ((alt != null && alt.toLowerCase().contains(logoName.toLowerCase())) ||
                (src != null && src.toLowerCase().contains(logoName.toLowerCase()))) {
                return true;
            }
        }
        return false;
    }
    
    public void clickMoreInfoLink() {
        wait.until(ExpectedConditions.elementToBeClickable(moreInfoLink));
        moreInfoLink.click();
    }
    
    public String getMoreInfoLinkText() {
        return moreInfoLink.getText();
    }
    
    public String getMoreInfoLinkHref() {
        return moreInfoLink.getAttribute("href");
    }
    
    public void selectConnectionService() {
        wait.until(ExpectedConditions.elementToBeClickable(connectionServiceTab));
        connectionServiceTab.click();
    }
    
    public void enterPhoneNumber(String phoneNumber) {
        wait.until(ExpectedConditions.visibilityOf(phoneNumberInput));
        phoneNumberInput.clear();
        phoneNumberInput.sendKeys(phoneNumber);
    }
    
    public void enterAmount(String amount) {
        wait.until(ExpectedConditions.visibilityOf(amountInput));
        amountInput.clear();
        amountInput.sendKeys(amount);
    }
    
    public void clickContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
    }
    
    public boolean isContinueButtonEnabled() {
        return continueButton.isEnabled();
    }
    
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    
    public boolean isPaymentFormDisplayed() {
        try {
            WebDriverWait smallWait = new WebDriverWait(driver, Duration.ofSeconds(3));
            smallWait.until(ExpectedConditions.urlContains("payment"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}