import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 1.3 (Performance Benchmarking)");

        // Long string to make performance differences visible
        String testInput = "amanaplanacanalpanama".repeat(100);

        System.out.println("\nTesting String Length: " + testInput.length());
        System.out.println("------------------------------------------------");

        // 1. Benchmarking Iterative Approach (Two-Pointer)
        long startIter = System.nanoTime();
        isIterative(testInput);
        long endIter = System.nanoTime();
        System.out.println("Iterative (Two-Pointer) Time : " + (endIter - startIter) + " ns");

        // 2. Benchmarking Stack-Based Approach
        long startStack = System.nanoTime();
        isStackBased(testInput);
        long endStack = System.nanoTime();
        System.out.println("Stack-Based Approach Time    : " + (endStack - startStack) + " ns");

        // 3. Benchmarking Recursive Approach
        long startRec = System.nanoTime();
        isRecursive(testInput, 0, testInput.length() - 1);
        long endRec = System.nanoTime();
        System.out.println("Recursive Approach Time      : " + (endRec - startRec) + " ns");

        System.out.println("------------------------------------------------");
    }

    // Iterative Logic (O(n) time, O(1) space)
    public static boolean isIterative(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

    // Stack Logic (O(n) time, O(n) space)
    public static boolean isStackBased(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) stack.push(c);
        for (char c : s.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }

    // Recursive Logic (O(n) time, O(n) stack space)
    public static boolean isRecursive(String s, int l, int r) {
        if (l >= r) return true;
        if (s.charAt(l) != s.charAt(r)) return false;
        return isRecursive(s, l + 1, r - 1);
    }
}