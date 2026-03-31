import java.util.*;

// 1. Define the Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String text);
}

// 2. Implementation A: Stack-Based Strategy
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String text) {
        String clean = text.replaceAll("[\\W]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : clean.toCharArray()) {
            stack.push(c);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return clean.equals(reversed.toString());
    }
}

// 3. Implementation B: Deque-Based Strategy
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String text) {
        String clean = text.replaceAll("[\\W]", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : clean.toCharArray()) {
            deque.addLast(c);
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}

// 4. Context Class: The Palindrome Checker
class PalindromeContext {
    private PalindromeStrategy strategy;

    // Inject strategy at runtime
    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(String text) {
        return strategy.isPalindrome(text);
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 1.2 (Strategy Pattern)");

        PalindromeContext context = new PalindromeContext();
        String testInput = "Race Car";

        // --- Scenario 1: Using Stack Strategy ---
        context.setStrategy(new StackStrategy());
        System.out.println("\n[Strategy: Stack]");
        System.out.println("Result: " + context.executeStrategy(testInput));

        // --- Scenario 2: Using Deque Strategy ---
        context.setStrategy(new DequeStrategy());
        System.out.println("\n[Strategy: Deque]");
        System.out.println("Result: " + context.executeStrategy(testInput));
    }
}