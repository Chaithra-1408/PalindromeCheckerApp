import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

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
        String stackInput = "radar";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < stackInput.length(); i++) {
            stack.push(stackInput.charAt(i));
        }
        String stackReversed = "";
        while (!stack.isEmpty()) {
            stackReversed = stackReversed + stack.pop();
        }
        if (stackInput.equals(stackReversed)) {
            System.out.println(stackInput + " is a palindrome.");
        } else {
            System.out.println(stackInput + " is not a palindrome.");
        }

        // UC6: Queue + Stack Based Palindrome Check
        // Data Structures: Queue (FIFO) + Stack (LIFO)
        String queueInput = "civic";

        // Queue - FIFO (First In First Out)
        // Enqueue Operation - inserting characters into queue
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < queueInput.length(); i++) {
            queue.add(queueInput.charAt(i));
        }

        // Stack - LIFO (Last In First Out)
        // Push Operation - inserting characters into stack
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < queueInput.length(); i++) {
            stack2.push(queueInput.charAt(i));
        }

        // Logical Comparison
        // Dequeue (queue) vs Pop (stack) to validate palindrome
        boolean isQueueStackPalindrome = true;
        while (!queue.isEmpty()) {
            if (queue.poll() != stack2.pop()) {
                isQueueStackPalindrome = false;
                break;
            }
        }

        if (isQueueStackPalindrome) {
            System.out.println(queueInput + " is a palindrome.");
        } else {
            System.out.println(queueInput + " is not a palindrome.");
        }

    }

}