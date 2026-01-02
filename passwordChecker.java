import java.util.Scanner;

public class PasswordChecker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        int strength = 0;

        // Length check
        if (password.length() >= 8) {
            strength++;
        }

        // Uppercase check
        if (password.matches(".*[A-Z].*")) {
            strength++;
        }

        // Lowercase check
        if (password.matches(".*[a-z].*")) {
            strength++;
        }

        // Digit check
        if (password.matches(".*[0-9].*")) {
            strength++;
        }

        // Special character check
        if (password.matches(".*[!@#$%^&*()].*")) {
            strength++;
        }

        // Final result
        if (strength <= 2) {
            System.out.println("Password Strength: WEAK ❌");
        } else if (strength <= 4) {
            System.out.println("Password Strength: MEDIUM ⚠️");
        } else {
            System.out.println("Password Strength: STRONG ✅");
        }

        sc.close();
    }
}
