public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // UC1: Welcome Message
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 1.0");
        System.out.println("System initialized successfully.");

        // UC2: Hardcoded Palindrome Check
        // String Literal stored in the String Constant Pool
        String original = "madam";

        // Using StringBuilder to reverse the string
        String reversed = new StringBuilder(original).reverse().toString();

        // Conditional Statement (if-else) to compare values
        if (original.equals(reversed)) {
            System.out.println(original + " is a palindrome.");
        } else {
            System.out.println(original + " is not a palindrome.");
        }

    }

}
