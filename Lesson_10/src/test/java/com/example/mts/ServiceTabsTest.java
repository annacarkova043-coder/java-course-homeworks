package com.example.mts;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Service Tabs Placeholder Tests")
public class ServiceTabsTest extends BaseTest {
    
    @Test
    @DisplayName("Test 1: Verify connection service tab placeholder")
    public void testConnectionServicePlaceholder() {
        mainPage.selectConnectionService();
        String placeholder = mainPage.getPhoneNumberPlaceholder();
        assertEquals("Номер телефона", placeholder, 
            "Connection service should have correct placeholder");
        System.out.println("✓ Connection service placeholder: " + placeholder);
    }
    
    @Test
    @DisplayName("Test 2: Verify home internet tab placeholder")
    public void testHomeInternetPlaceholder() {
        mainPage.selectHomeInternet();
        String placeholder = mainPage.getAccountNumberPlaceholder();
        assertEquals("Номер счета", placeholder, 
            "Home internet should have correct placeholder");
        System.out.println("✓ Home internet placeholder: " + placeholder);
    }
    
    @Test
    @DisplayName("Test 3: Verify installment tab placeholder")
    public void testInstallmentPlaceholder() {
        mainPage.selectInstallment();
        String placeholder = mainPage.getAccountNumberPlaceholder();
        assertEquals("Номер счета", placeholder, 
            "Installment should have correct placeholder");
        System.out.println("✓ Installment placeholder: " + placeholder);
    }
    
    @Test
    @DisplayName("Test 4: Verify debt tab placeholder")
    public void testDebtPlaceholder() {
        mainPage.selectDebt();
        String placeholder = mainPage.getAccountNumberPlaceholder();
        assertEquals("Номер счета", placeholder, 
            "Debt should have correct placeholder");
        System.out.println("✓ Debt placeholder: " + placeholder);
    }
    
    @ParameterizedTest
    @CsvSource({
        "connection, Услуги связи, Номер телефона",
        "home, Домашний интернет, Номер счета",
        "installment, Рассрочка, Номер счета",
        "debt, Задолженность, Номер счета"
    })
    @DisplayName("Test 5: Parameterized test for all service tabs")
    public void testAllServiceTabs(String tabName, String expectedTabText, String expectedPlaceholder) {
        switch (tabName) {
            case "connection":
                mainPage.selectConnectionService();
                break;
            case "home":
                mainPage.selectHomeInternet();
                break;
            case "installment":
                mainPage.selectInstallment();
                break;
            case "debt":
                mainPage.selectDebt();
                break;
        }
        
        String actualPlaceholder = tabName.equals("connection") ? 
            mainPage.getPhoneNumberPlaceholder() : mainPage.getAccountNumberPlaceholder();
        
        assertEquals(expectedPlaceholder, actualPlaceholder, 
            "Placeholder for " + expectedTabText + " should be correct");
        
        System.out.println("✓ " + expectedTabText + " tab verified with placeholder: " + actualPlaceholder);
    }
}