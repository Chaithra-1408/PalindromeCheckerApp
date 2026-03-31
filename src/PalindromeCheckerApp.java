import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;

public class PalindromeCheckerApp {

    // Node class for Singly Linked List (UC8)
    static class Node {
        char data;
        Node next;
        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

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
        String inputStr = "level";
        char[] chars = inputStr.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        boolean isPalindromeUC4 = true;
        while (start < end) {
            if (chars[start] != chars[end]) {
                isPalindromeUC4 = false;
                break;
            }
            start++;
            end--;
        }
        if (isPalindromeUC4) {
            System.out.println(inputStr + " is a palindrome.");
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
        }

        // UC6: Queue + Stack Based Palindrome Check
        String queueInput = "civic";
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < queueInput.length(); i++) {
            queue.add(queueInput.charAt(i));
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
        }

        // UC7: Deque-Based Optimized Palindrome Checker
        String dequeInput = "noon";
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < dequeInput.length(); i++) {
            deque.addLast(dequeInput.charAt(i));
        }
        boolean isDequePalindrome = true;
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                isDequePalindrome = false;
                break;
            }
        }
        if (isDequePalindrome) {
            System.out.println(dequeInput + " is a palindrome.");
        }

        // UC8: Linked List Based Palindrome Checker
        String listInput = "refer";
        Node head = new Node(listInput.charAt(0));
        Node current = head;
        for (int i = 1; i < listInput.length(); i++) {
            current.next = new Node(listInput.charAt(i));
            current = current.next;
        }
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node prev = null, curr = slow;
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        Node left = head, right = prev;
        boolean isLinkedListPalindrome = true;
        while (right != null) {
            if (left.data != right.data) {
                isLinkedListPalindrome = false;
                break;
            }
            left = left.next;
            right = right.next;
        }
        if (isLinkedListPalindrome) {
            System.out.println(listInput + " is a palindrome.");
        }

        // UC9: Recursive Palindrome Checker
        // Goal: Check palindrome using recursion and Call Stack
        String recursiveInput = "deified";
        if (isRecursivePalindrome(recursiveInput, 0, recursiveInput.length() - 1)) {
            System.out.println(recursiveInput + " is a palindrome.");
        } else {
            System.out.println(recursiveInput + " is not a palindrome.");
        }
    }

    /**
     * Recursive Method for UC9
     */
    public static boolean isRecursivePalindrome(String str, int low, int high) {
        // Base Case: recursion exits here
        if (low >= high) {
            return true;
        }
        // Comparison step
        if (str.charAt(low) != str.charAt(high)) {
            return false;
        }
        // Recursive call: moving towards center
        return isRecursivePalindrome(str, low + 1, high - 1);
    }
}