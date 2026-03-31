import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeCheckerApp {

    // Node class for Singly Linked List
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
        } else {
            System.out.println(dequeInput + " is not a palindrome.");
        }

        // UC8: Linked List Based Palindrome Checker
        // Data Structure: Singly Linked List
        String listInput = "refer";

        // Convert string to linked list - Node Traversal
        Node head = new Node(listInput.charAt(0));
        Node current = head;
        for (int i = 1; i < listInput.length(); i++) {
            current.next = new Node(listInput.charAt(i));
            current = current.next;
        }

        // Fast and Slow Pointer Technique - find middle
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // In-Place Reversal - reverse second half
        Node prev = null;
        Node curr = slow;
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // Compare both halves
        Node left = head;
        Node right = prev;
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
        } else {
            System.out.println(listInput + " is not a palindrome.");
        }

    }

}