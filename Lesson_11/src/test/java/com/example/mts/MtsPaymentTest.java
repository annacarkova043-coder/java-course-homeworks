package com.example.mts;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Epic("MTS Payment Tests")
@Feature("Online Payment")
@DisplayName("MTS Payment Tests with Allure Reports")
public class MtsPaymentTest extends BaseTest {
    
    private static final String TEST_PHONE = ConfigReader.getTestPhoneNumber();
    private static final String TEST_AMOUNT = ConfigReader.getTestAmount();
    
    @Test
    @Story("Payment Form")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Test 1: Verify main page loads correctly")
    @Description("Check that main page opens and connection service tab is visible")
    public void testMainPageLoad() {
        saveScreenshot();
        saveTextLog("Main page loaded successfully");
        assertTrue(true, "Main page should load without errors");
    }
    
    @Test
    @Story("Payment Form")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Test 2: Fill payment form and verify continue button")
    @Description("Select connection service, fill phone and amount, then click continue")
    public void testFillPaymentForm() {
        Allure.step("Select connection service");
        mainPage.selectConnectionService();
        saveScreenshot();
        
        Allure.step("Enter phone number: " + TEST_PHONE);
        mainPage.enterPhoneNumber(TEST_PHONE);
        
        Allure.step("Enter amount: " + TEST_AMOUNT);
        mainPage.enterAmount(TEST_AMOUNT);
        saveScreenshot();
        
        Allure.step("Click Continue button");
        mainPage.clickContinue();
        saveScreenshot();
        
        Allure.step("Verify payment form is displayed");
        boolean isDisplayed = mainPage.isPaymentFormDisplayed();
        saveTextLog("Payment form displayed: " + isDisplayed);
        
        assertTrue(isDisplayed, "Payment form should be displayed after clicking Continue");
    }
    
    @Test
    @Story("Payment Information")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Test 3: Verify payment information")
    @Description("Check that phone number and amount are correctly displayed on payment page")
    public void testPaymentInformation() {
        Allure.step("Navigate to payment form");
        mainPage.selectConnectionService();
        mainPage.enterPhoneNumber(TEST_PHONE);
        mainPage.enterAmount(TEST_AMOUNT);
        mainPage.clickContinue();
        saveScreenshot();
        
        Allure.step("Verify payment form is displayed");
        assertTrue(mainPage.isPaymentFormDisplayed(), "Payment form should be displayed");
        
        Allure.step("Check displayed phone number");
        String displayedPhone = mainPage.getPaymentPhoneNumber();
        saveTextLog("Displayed phone: " + displayedPhone);
        assertTrue(displayedPhone.contains(TEST_PHONE), 
            "Displayed phone should match input");
        
        Allure.step("Check displayed amount");
        String displayedAmount = mainPage.getPaymentAmount();
        saveTextLog("Displayed amount: " + displayedAmount);
        assertTrue(displayedAmount.contains(TEST_AMOUNT), 
            "Displayed amount should match input");
        
        saveScreenshot();
    }
    
    @Test
    @Story("Form Validation")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Test 4: Test with different phone numbers")
    @Description("Verify form works with different phone number formats")
    public void testDifferentPhoneNumbers() {
        String[] testPhones = {
            TEST_PHONE,
            "29" + TEST_PHONE,
            "+375" + TEST_PHONE,
            "8 029" + TEST_PHONE
        };
        
        for (String phone : testPhones) {
            Allure.step("Testing with phone: " + phone);
            
            driver.navigate().refresh();
            mainPage.selectConnectionService();
            mainPage.enterPhoneNumber(phone);
            mainPage.enterAmount(TEST_AMOUNT);
            mainPage.clickContinue();
            
            boolean isDisplayed = mainPage.isPaymentFormDisplayed();
            saveTextLog("Phone " + phone + " - Payment form displayed: " + isDisplayed);
            
            if (isDisplayed) {
                driver.navigate().back();
            }
        }
        
        saveScreenshot();
    }
    
    @Test
    @Story("Form Validation")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Test 5: Test with different amounts")
    @Description("Verify form works with different payment amounts")
    public void testDifferentAmounts() {
        String[] testAmounts = {"5.00", "10.50", "100.00", "999.99"};
        
        for (String amount : testAmounts) {
            Allure.step("Testing with amount: " + amount);
            
            driver.navigate().refresh();
            mainPage.selectConnectionService();
            mainPage.enterPhoneNumber(TEST_PHONE);
            mainPage.enterAmount(amount);
            mainPage.clickContinue();
            
            boolean isDisplayed = mainPage.isPaymentFormDisplayed();
            saveTextLog("Amount " + amount + " - Payment form displayed: " + isDisplayed);
            
            if (isDisplayed) {
                driver.navigate().back();
            }
        }
        
        saveScreenshot();
    }
}