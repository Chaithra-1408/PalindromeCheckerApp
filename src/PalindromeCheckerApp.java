import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // UC1: Welcome Message
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 1.0");
        System.out.println("System initialized successfully.");

        // UC10 Logic: Normalization + Recursion
        // Example phrase with mixed case and spaces
        String phrase = "A man a plan a canal Panama";

        System.out.println("\n--- UC10: Normalizing Input ---");
        System.out.println("Original Phrase: " + phrase);

        // Preprocessing: Remove everything except letters and numbers
        // \\W matches any non-word character (spaces, punctuation)
        String normalizedStr = phrase.replaceAll("[\\W]", "").toLowerCase();
        System.out.println("Normalized String: " + normalizedStr);

        // Apply Recursive Check (from UC9)
        System.out.print("UC10 Result: ");
        if (isRecursivePalindrome(normalizedStr, 0, normalizedStr.length() - 1)) {
            System.out.println("\"" + phrase + "\" is a palindrome.");
        } else {
            System.out.println("\"" + phrase + "\" is not a palindrome.");
        }
    }

    /**
     * Recursive Method used for the final check
     */
    public static boolean isRecursivePalindrome(String str, int low, int high) {
        if (low >= high) {
            return true;
        }
        if (str.charAt(low) != str.charAt(high)) {
            return false;
        }
        return isRecursivePalindrome(str, low + 1, high - 1);
    }
}