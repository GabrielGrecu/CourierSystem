package com.upt.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DataValidatorTest {

    @Test
    public void testIsName_Valid() {
        assertTrue(DataValidator.isName("John Doe"));
        assertTrue(DataValidator.isName("Alice"));
    }

    @Test
    public void testIsName_Invalid() {
        assertFalse(DataValidator.isName("John123"));
        assertFalse(DataValidator.isName("Alice@"));
        assertFalse(DataValidator.isName("12345"));
    }

    @Test
    public void testIsPassword_Valid() {
        assertTrue(DataValidator.isPassword("Password123"));
        assertTrue(DataValidator.isPassword("Valid@123"));
    }

    @Test
    public void testIsPassword_Invalid() {
        assertFalse(DataValidator.isPassword("short"));
        assertFalse(DataValidator.isPassword("nopunctuation1"));
        assertFalse(DataValidator.isPassword("NOLOWERCASE1@"));
        assertFalse(DataValidator.isPassword("nouppercase1@"));
        assertFalse(DataValidator.isPassword("NoDigits@"));
    }

    @Test
    public void testIsPhoneNo_Valid() {
        assertTrue(DataValidator.isPhoneNo("9876543210"));
        assertTrue(DataValidator.isPhoneNo("9123456789"));
    }

    @Test
    public void testIsPhoneNo_Invalid() {
        assertFalse(DataValidator.isPhoneNo("1234567890"));
        assertFalse(DataValidator.isPhoneNo("98765abcde"));
        assertFalse(DataValidator.isPhoneNo("987654321"));
    }

    @Test
    public void testIsNull() {
        assertTrue(DataValidator.isNull(null));
        assertTrue(DataValidator.isNull(""));
        assertTrue(DataValidator.isNull("  "));
    }

    @Test
    public void testIsNotNull() {
        assertFalse(DataValidator.isNull("value"));
        assertFalse(DataValidator.isNull("123"));
    }

    @Test
    public void testIsInteger_Valid() {
        assertTrue(DataValidator.isInteger("123"));
        assertTrue(DataValidator.isInteger("0"));
        assertTrue(DataValidator.isInteger("-456"));
    }

    @Test
    public void testIsInteger_Invalid() {
        assertFalse(DataValidator.isInteger("12.34"));
        assertFalse(DataValidator.isInteger("abc"));
        assertFalse(DataValidator.isInteger("123abc"));
    }

    @Test
    public void testIsLong_Valid() {
        assertTrue(DataValidator.isLong("1234567890123"));
        assertTrue(DataValidator.isLong("0"));
        assertTrue(DataValidator.isLong("-1234567890123"));
    }

    @Test
    public void testIsLong_Invalid() {
        assertFalse(DataValidator.isLong("12.34"));
        assertFalse(DataValidator.isLong("abc"));
        assertFalse(DataValidator.isLong("123abc"));
    }

    @Test
    public void testIsEmail_Valid() {
        assertTrue(DataValidator.isEmail("test@example.com"));
        assertTrue(DataValidator.isEmail("user.name@domain.co.in"));
    }

    @Test
    public void testIsEmail_Invalid() {
        assertFalse(DataValidator.isEmail("plainaddress"));
        assertFalse(DataValidator.isEmail("@no-local-part.com"));
        assertFalse(DataValidator.isEmail("Outlook Contact <outlook-contact@domain.com>"));
    }

    @Test
    public void testIsDate_Valid() {
        assertTrue(DataValidator.isDate("01/01/2020"));
        assertTrue(DataValidator.isDate("31/12/1999"));
    }

//    @Test
//    public void testIsDate_Invalid() {
//        assertFalse(DataValidator.isDate("2020/01/01"));
//        assertFalse(DataValidator.isDate("31-12-1999"));
//        assertFalse(DataValidator.isDate("invalid date"));
//    }
}
