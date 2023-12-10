package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PalindromeCheckerTest {

    @Test
    void testIsPalindromeWithPalindromeWord() {
        assertTrue(PalindromeChecker.isPalindrome("level"));
    }

    @Test
    void testIsPalindromeWithNonPalindromeWord() {
        assertFalse(PalindromeChecker.isPalindrome("hello"));
    }

    @Test
    void testIsPalindromeWithMixedCaseWord() {
        assertTrue(PalindromeChecker.isPalindrome("Reviver"));
    }

    @Test
    void testIsPalindromeWithPhrase() {
        assertTrue(PalindromeChecker.isPalindrome("A man a plan a canal Panama"));
    }

    @Test
    void testIsPalindromeWithEmptyString() {
        assertTrue(PalindromeChecker.isPalindrome(""));
    }

    @Test
    void testIsPalindromeWithWhitespace() {
        assertTrue(PalindromeChecker.isPalindrome("   racecar   "));
    }
}