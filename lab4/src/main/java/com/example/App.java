package com.example;

public class App {
    public static boolean isPalindrome(String word) {
        String cleanWord = word.replaceAll("\\s+", "").toLowerCase();

        String reversedWord = new StringBuilder(cleanWord).reverse().toString();

        return cleanWord.equals(reversedWord);
    }

    public static void main(String[] args) {
        String exampleWord = "level";
        if (isPalindrome(exampleWord)) {
            System.out.println(exampleWord + " it`s palindrom.");
        } else {
            System.out.println(exampleWord + " it`s not palindrom.");
        }
    }
}