package com.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static String decodeVowels(String input) {
        return input.replaceAll("a", "1")
                    .replaceAll("e", "2")
                    .replaceAll("i", "3")
                    .replaceAll("o", "4")
                    .replaceAll("u", "5");
    }

    public static String decodeConsonants(String input) {
        StringBuilder decoded = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (isConsonant(c)) {
                decoded.append(getNextConsonant(c));
            } else {
                decoded.append(c);
            }
        }
        return decoded.toString();
    }

    private static boolean isConsonant(char c) {
        return "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ".indexOf(c) != -1;
    }

    private static char getNextConsonant(char c) {
        if (c == 'z') return 'b';
        if (c == 'Z') return 'B';
        return (char) (c + 1);
    }

    public static String decodeMessage(String message) {
        StringBuilder decodedMessage = new StringBuilder();
        String[] words = message.split("\\s+");

        for (String word : words) {
            if (word.matches("\\d+")) {
                decodedMessage.append(decodeVowels(word)).append(" ");
            } else {
                if (word.matches("[aeiouAEIOU]+")) {
                    decodedMessage.append(decodeVowels(word)).append(" ");
                } else if (word.matches("[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ]+")) {
                    decodedMessage.append(decodeConsonants(word)).append(" ");
                } else {
                    decodedMessage.append(word).append(" ");
                }
            }
        }

        return decodedMessage.toString().trim();
    }

    public static void main(String[] args) {
        String encryptedMessage = "t2st3ng vetviph";
        String decodedMessage = decodeMessage(encryptedMessage);
        System.out.println("Зашифроване повідомлення: " + encryptedMessage);
        System.out.println("Розшифроване повідомлення: " + decodedMessage);
    }
}
