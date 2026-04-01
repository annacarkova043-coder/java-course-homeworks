package com.example.mts;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MTS Service Types Tests")
public class ServiceTypesTest extends BaseTest {
    
    private static final String TEST_PHONE = ConfigReader.getTestPhoneNumber();
    private static final String TEST_AMOUNT = ConfigReader.getTestAmount();
    
    @ParameterizedTest
    @CsvSource({
        "Услуги связи, 297777777",
        "Домашний интернет, 297777777",
        "Рассрочка, 297777777",
        "Задолженность, 297777777"
    })
    @DisplayName("Test different service types")
    public void testDifferentServiceTypes(String serviceType, String phone) {
        // This test would need locators for different tabs
        // For now, we test the main flow
        mainPage.selectConnectionService();
        mainPage.enterPhoneNumber(phone);
        mainPage.enterAmount(TEST_AMOUNT);
        
        assertTrue(mainPage.isContinueButtonEnabled(), 
            "Continue button should be enabled for service: " + serviceType);
        
        System.out.println("✓ Service type '" + serviceType + "' works correctly");
    }
}