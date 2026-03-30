import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // UC1: Welcome Message
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 1.0");
        System.out.println("System initialized successfully.");

        // UC2: Hardcoded Palindrome Check
        String original = "madam";
        String reversed = new StringBuilder(original).reverse().toString();
        if (original.equals(reversed)) {
            System.out.println(original + " is a palindrome.");
        } else {
            System.out.println(original + " is not a palindrome.");
        }

        // UC3: Palindrome Check Using String Reverse
        String word = "racecar";
        String reversedWord = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversedWord = reversedWord + word.charAt(i);
        }
        if (word.equals(reversedWord)) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }

        // UC4: Character Array Based Palindrome Check
        String input = "level";
        char[] chars = input.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        boolean isPalindrome = true;
        while (start < end) {
            if (chars[start] != chars[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }
        if (isPalindrome) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is not a palindrome.");
        }

        // UC5: Stack-Based Palindrome Checker
        // Data Structure: Stack (LIFO - Last In First Out)
        String stackInput = "radar";

        // Push Operation - inserting characters into stack
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < stackInput.length(); i++) {
            stack.push(stackInput.charAt(i));
        }

        // Pop Operation - removing characters in reverse order
        // Reversal Logic - Stack naturally reverses order of elements
        String stackReversed = "";
        while (!stack.isEmpty()) {
            stackReversed = stackReversed + stack.pop();
        }

        if (stackInput.equals(stackReversed)) {
            System.out.println(stackInput + " is a palindrome.");
        } else {
            System.out.println(stackInput + " is not a palindrome.");
        }

    }

}