package com.example.mts;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Payment Process Tests")
public class PaymentProcessTest extends BaseTest {
    
    private static final String TEST_PHONE = ConfigReader.getTestPhoneNumber();
    private static final String TEST_AMOUNT = ConfigReader.getTestAmount();
    
    @Test
    @Order(1)
    @DisplayName("Test 6: Fill connection service form and proceed to payment")
    public void testConnectionServicePayment() {
        // Step 1: Select connection service
        mainPage.selectConnectionService();
        
        // Step 2: Fill form
        mainPage.enterPhoneNumber(TEST_PHONE);
        mainPage.enterAmount(TEST_AMOUNT);
        
        // Step 3: Click Continue
        mainPage.clickContinue();
        
        // Step 4: Verify payment form is displayed
        assertTrue(mainPage.isPaymentFormDisplayed(), 
            "Payment form should be displayed after clicking Continue");
        
        System.out.println("✓ Payment form displayed successfully");
    }
    
    @Test
    @Order(2)
    @DisplayName("Test 7: Verify payment amount and phone number")
    public void testPaymentInfo() {
        // Fill form and proceed to payment
        mainPage.selectConnectionService();
        mainPage.enterPhoneNumber(TEST_PHONE);
        mainPage.enterAmount(TEST_AMOUNT);
        mainPage.clickContinue();
        
        // Wait for payment form
        assertTrue(mainPage.isPaymentFormDisplayed(), "Payment form should be displayed");
        
        // Verify phone number
        String displayedPhone = mainPage.getPaymentPhoneNumber();
        assertTrue(displayedPhone.contains(TEST_PHONE), 
            "Displayed phone number should match input");
        System.out.println("✓ Phone number verified: " + displayedPhone);
        
        // Verify amount
        String displayedAmount = mainPage.getPaymentAmount();
        assertTrue(displayedAmount.contains(TEST_AMOUNT), 
            "Displayed amount should match input");
        System.out.println("✓ Amount verified: " + displayedAmount);
        
        // Verify amount on button
        String buttonAmount = mainPage.getButtonAmount();
        assertTrue(buttonAmount.contains(TEST_AMOUNT), 
            "Button amount should match input");
        System.out.println("✓ Button amount verified: " + buttonAmount);
    }
    
    @Test
    @Order(3)
    @DisplayName("Test 8: Verify payment form placeholders")
    public void testPaymentFormPlaceholders() {
        // Navigate to payment form
        mainPage.selectConnectionService();
        mainPage.enterPhoneNumber(TEST_PHONE);
        mainPage.enterAmount(TEST_AMOUNT);
        mainPage.clickContinue();
        
        assertTrue(mainPage.isPaymentFormDisplayed(), "Payment form should be displayed");
        
        // Verify all placeholders
        assertEquals("Номер карты", mainPage.getCardNumberPlaceholder(), 
            "Card number placeholder should be correct");
        assertEquals("Срок действия", mainPage.getExpiryDatePlaceholder(), 
            "Expiry date placeholder should be correct");
        assertEquals("CVC", mainPage.getCVCPlaceholder(), 
            "CVC placeholder should be correct");
        assertEquals("Имя держателя", mainPage.getCardHolderPlaceholder(), 
            "Card holder placeholder should be correct");
        
        System.out.println("✓ All payment form placeholders verified");
    }
    
    @Test
    @Order(4)
    @DisplayName("Test 9: Verify payment system icons")
    public void testPaymentSystemIcons() {
        // Navigate to payment form
        mainPage.selectConnectionService();
        mainPage.enterPhoneNumber(TEST_PHONE);
        mainPage.enterAmount(TEST_AMOUNT);
        mainPage.clickContinue();
        
        assertTrue(mainPage.isPaymentFormDisplayed(), "Payment form should be displayed");
        
        // Check payment icons
        int iconsCount = mainPage.getPaymentIconsCount();
        assertTrue(iconsCount > 0, "Payment icons should be displayed");
        
        // Check for specific payment systems
        String[] expectedIcons = {"visa", "mastercard", "maestro", "belkart", "mir"};
        for (String icon : expectedIcons) {
            boolean isDisplayed = mainPage.isPaymentIconDisplayed(icon);
            assertTrue(isDisplayed, "Icon for " + icon + " should be displayed");
        }
        
        System.out.println("✓ Payment icons verified, count: " + iconsCount);
    }
    
    @Test
    @Order(5)
    @DisplayName("Test 10: Complete payment flow validation")
    public void testCompletePaymentFlow() {
        // Fill main form
        mainPage.selectConnectionService();
        mainPage.enterPhoneNumber(TEST_PHONE);
        mainPage.enterAmount(TEST_AMOUNT);
        mainPage.clickContinue();
        
        // Verify payment form loaded
        assertTrue(mainPage.isPaymentFormDisplayed(), "Payment form should load");
        
        // Verify all payment info
        String phone = mainPage.getPaymentPhoneNumber();
        String amount = mainPage.getPaymentAmount();
        String buttonAmount = mainPage.getButtonAmount();
        
        assertTrue(phone.contains(TEST_PHONE), "Phone number correct");
        assertTrue(amount.contains(TEST_AMOUNT), "Amount correct");
        assertTrue(buttonAmount.contains(TEST_AMOUNT), "Button amount correct");
        
        // Verify placeholders
        assertAll("Payment form placeholders",
            () -> assertEquals("Номер карты", mainPage.getCardNumberPlaceholder()),
            () -> assertEquals("Срок действия", mainPage.getExpiryDatePlaceholder()),
            () -> assertEquals("CVC", mainPage.getCVCPlaceholder()),
            () -> assertEquals("Имя держателя", mainPage.getCardHolderPlaceholder())
        );
        
        // Verify payment icons
        assertTrue(mainPage.getPaymentIconsCount() >= 5, 
            "All payment icons should be present");
        
        System.out.println("✓ Complete payment flow validated successfully");
    }
}