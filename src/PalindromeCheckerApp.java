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
        String queueInput = "civic";
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < queueInput.length(); i++) {
            queue.add(queueInput.charAt(i));
        }
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < queueInput.length(); i++) {
            stack2.push(queueInput.charAt(i));
        }
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

        // UC7: Deque-Based Optimized Palindrome Checker
        // Data Structure: Deque (Double Ended Queue)
        String dequeInput = "noon";

        // Insert characters into Deque
        // Deque allows insertion and deletion from both front and rear
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < dequeInput.length(); i++) {
            deque.addLast(dequeInput.charAt(i));
        }

        // Front and Rear Access
        // Remove first and last characters and compare
        // Optimized - no need for separate reversal data structure
        boolean isDequePalindrome = true;
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                isDequePalindrome = false;
                break;
            }
        }

        if (isDequePalindrome) {
            System.out.println(dequeInput + " is a palindrome.");
        } else {
            System.out.println(dequeInput + " is not a palindrome.");
        }

    }

}