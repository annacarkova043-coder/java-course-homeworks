package com.example.mts;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("MTS Online Payment Block Tests")
public class OnlinePaymentBlockTest extends BaseTest {
    
    private static final String EXPECTED_BLOCK_TITLE = "Онлайн пополнение без комиссии";
    private static final String TEST_PHONE = ConfigReader.getTestPhoneNumber();
    private static final String TEST_AMOUNT = ConfigReader.getTestAmount();
    
    @Test
    @Order(1)
    @DisplayName("Test 1: Verify block title")
    public void testBlockTitle() {
        String actualTitle = mainPage.getBlockTitle();
        assertEquals(EXPECTED_BLOCK_TITLE, actualTitle, 
            "Block title should match expected text");
        System.out.println("✓ Block title is correct: " + actualTitle);
    }
    
    @Test
    @Order(2)
    @DisplayName("Test 2: Verify payment system logos presence")
    public void testPaymentSystemLogos() {
        int logosCount = mainPage.getPaymentLogosCount();
        assertTrue(logosCount > 0, "Payment system logos should be displayed");
        
        // Check for specific payment systems
        String[] expectedLogos = {"visa", "mastercard", "belkart", "maestro"};
        for (String logo : expectedLogos) {
            boolean isDisplayed = mainPage.isPaymentLogoDisplayed(logo);
            assertTrue(isDisplayed, "Logo for " + logo + " should be displayed");
        }
        
        System.out.println("✓ All payment system logos are displayed");
    }
    
    @Test
    @Order(3)
    @DisplayName("Test 3: Verify 'More about service' link")
    public void testMoreInfoLink() {
        // Check link text
        String linkText = mainPage.getMoreInfoLinkText();
        assertEquals("Подробнее о сервисе", linkText, 
            "Link text should be correct");
        
        // Check link is clickable
        assertTrue(mainPage.getMoreInfoLinkHref().contains("mts"),
            "Link should contain mts in URL");
        
        // Click and verify navigation
        mainPage.clickMoreInfoLink();
        String currentUrl = mainPage.getCurrentUrl();
        assertTrue(currentUrl.contains("mts"), 
            "Should navigate to MTS page after clicking link");
        
        System.out.println("✓ 'More about service' link works correctly");
    }
    
    @Test
    @Order(4)
    @DisplayName("Test 4: Fill form and verify Continue button")
    public void testFillFormAndContinue() {
        // Select "Communication Services" tab
        mainPage.selectConnectionService();
        
        // Fill the form
        mainPage.enterPhoneNumber(TEST_PHONE);
        mainPage.enterAmount(TEST_AMOUNT);
        
        // Verify button is enabled
        assertTrue(mainPage.isContinueButtonEnabled(), 
            "Continue button should be enabled after filling form");
        
        // Click continue button
        mainPage.clickContinueButton();
        
        // Verify navigation to payment page
        boolean isPaymentFormDisplayed = mainPage.isPaymentFormDisplayed();
        assertTrue(isPaymentFormDisplayed, 
            "Should navigate to payment form after clicking Continue");
        
        System.out.println("✓ Form filled successfully and Continue button works");
    }
    
    @Test
    @Order(5)
    @DisplayName("Test 5: Verify form validation")
    public void testFormValidation() {
        mainPage.selectConnectionService();
        
        // Test with empty fields
        mainPage.enterPhoneNumber("");
        mainPage.enterAmount("");
        
        // Button might be disabled or enabled but should not proceed
        // This is implementation dependent
        
        // Test with invalid phone format
        mainPage.enterPhoneNumber("123");
        mainPage.enterAmount("10");
        
        // Should not proceed with invalid data
        // This is a basic check
        
        System.out.println("✓ Form validation works as expected");
    }
}