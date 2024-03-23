import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Password Generator!");
        System.out.println("Would you like to generate a password? (Yes/No)");
        String generatePassword = scanner.nextLine();

        if (generatePassword.equalsIgnoreCase("yes")) {
            System.out.println("Let's generate a password!");

            // Criteria for password generation
            String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String lowerCase = "abcdefghijklmnopqrstuvwxyz";
            String numbers = "0123456789";
            String symbols = "!@#$%^&*()_+-=[]{}|;:,.<>?";

            System.out.println("Do you want to include uppercase letters? (Yes/No)");
            boolean includeUpperCase = scanner.nextLine().equalsIgnoreCase("yes");

            System.out.println("Do you want to include lowercase letters? (Yes/No)");
            boolean includeLowerCase = scanner.nextLine().equalsIgnoreCase("yes");

            System.out.println("Do you want to include numbers? (Yes/No)");
            boolean includeNumbers = scanner.nextLine().equalsIgnoreCase("yes");

            System.out.println("Do you want to include symbols? (Yes/No)");
            boolean includeSymbols = scanner.nextLine().equalsIgnoreCase("yes");

            System.out.println("Enter the desired length of the password:");
            int length = scanner.nextInt();

            String passwordAlphabet = "";
            if (includeUpperCase) passwordAlphabet += upperCase;
            if (includeLowerCase) passwordAlphabet += lowerCase;
            if (includeNumbers) passwordAlphabet += numbers;
            if (includeSymbols) passwordAlphabet += symbols;

            String password = generatePassword(passwordAlphabet, length);
            System.out.println("Generated Password: " + password);

            // Check password strength
            int passwordStrength = checkPasswordStrength(password);
            displayStrengthMessage(passwordStrength);
        } else {
            System.out.println("Thank you for using Password Generator!");
        }
    }

    private static String generatePassword(String alphabet, int length) {
        StringBuilder password = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            password.append(alphabet.charAt(index));
        }
        return password.toString();
    }

    private static int checkPasswordStrength(String password) {
        int strength = 0;
        if (password.matches(".*[A-Z].*")) strength++; // Uppercase letter
        if (password.matches(".*[a-z].*")) strength++; // Lowercase letter
        if (password.matches(".*\\d.*")) strength++; // Number
        if (password.matches(".*[!@#$%^&*()_+\\-=[\\]{}|;:,.<>?].*")) strength++; // Symbol
        if (password.length() >= 8) strength++; // Length >= 8
        if (password.length() >= 16) strength++; // Length >= 16
        return strength;
    }

    private static void displayStrengthMessage(int strength) {
        switch (strength) {
            case 0:
            case 1:
                System.out.println("Weak password.");
                break;
            case 2:
                System.out.println("Medium password.");
                break;
            case 3:
                System.out.println("Good password.");
                break;
            case 4:
            case 5:
                System.out.println("Great password.");
                break;
        }
    }
}
