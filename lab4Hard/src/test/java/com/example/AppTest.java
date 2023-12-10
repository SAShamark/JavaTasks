package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    void testDecodeVowels() {
        String encodedWord = "t2st3ng";
        String decodedWord = Decoder.decodeVowels(encodedWord);
        assertEquals("testing", decodedWord);
    }

    @Test
    void testDecodeConsonants() {
        String encodedWord = "vetviph";
        String decodedWord = Decoder.decodeConsonants(encodedWord);
        assertEquals("testing", decodedWord);
    }

    @Test
    void testDecodeMessage() {
        String encodedMessage = "t2st3ng vetviph";
        String decodedMessage = Decoder.decodeMessage(encodedMessage);
        assertEquals("testing testing", decodedMessage);
    }

    @Test
    void testDecodeMessageWithMixedEncoding() {
        String encodedMessage = "t2st3ng vetviph 12345";
        String decodedMessage = Decoder.decodeMessage(encodedMessage);
        assertEquals("testing testing 12345", decodedMessage);
    }

    @Test
    void testDecodeMessageWithSpecialCharacters() {
        String encodedMessage = "t2st3ng! vetviph?";
        String decodedMessage = Decoder.decodeMessage(encodedMessage);
        assertEquals("testing! testing?", decodedMessage);
    }
}
