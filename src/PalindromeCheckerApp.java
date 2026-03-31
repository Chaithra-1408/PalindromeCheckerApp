import java.util.Scanner;

// Palindrome Service Class - Encapsulating Logic
class PalindromeService {

    /**
     * Public method to check palindrome status.
     * Logic is hidden from the main method.
     */
    public boolean checkPalindrome(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        // Normalization (From UC10)
        String cleanStr = input.replaceAll("[\\W]", "").toLowerCase();

        // Call internal recursive logic (Encapsulated)
        return isRecursivePalindrome(cleanStr, 0, cleanStr.length() - 1);
    }

    private boolean isRecursivePalindrome(String str, int low, int high) {
        if (low >= high) {
            return true;
        }
        if (str.charAt(low) != str.charAt(high)) {
            return false;
        }
        return isRecursivePalindrome(str, low + 1, high - 1);
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        // UC1: Welcome Message
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 1.0 (OOPS Edition)");

        // Instantiate the Service Object
        PalindromeService service = new PalindromeService();

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter a word or phrase: ");
        String userInput = scanner.nextLine();

        // Use the service to check palindrome
        boolean result = service.checkPalindrome(userInput);

        System.out.println("\n--- UC11: OOPS Result ---");
        if (result) {
            System.out.println("SUCCESS: \"" + userInput + "\" is a valid palindrome.");
        } else {
            System.out.println("FAILURE: \"" + userInput + "\" is NOT a palindrome.");
        }

        scanner.close();
    }
}