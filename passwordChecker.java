import java.util.Scanner;
import java.util.regex.Pattern;

public class PasswordStrengthChecker {

    // Check password strength
    public static String checkStrength(String password) {
        int score = 0;

        if (password.length() >= 8) score++;
        if (Pattern.compile("[A-Z]").matcher(password).find()) score++;
        if (Pattern.compile("[a-z]").matcher(password).find()) score++;
        if (Pattern.compile("[0-9]").matcher(password).find()) score++;
        if (Pattern.compile("[^a-zA-Z0-9]").matcher(password).find()) score++;

        if (score <= 2) return "Weak";
        else if (score <= 4) return "Medium";
        else return "Strong";
    }

    // Suggest strong password
    public static String suggestPassword(String password) {
        StringBuilder suggestion = new StringBuilder(password);

        if (!Pattern.compile("[A-Z]").matcher(password).find())
            suggestion.append("A");

        if (!Pattern.compile("[a-z]").matcher(password).find())
            suggestion.append("a");

        if (!Pattern.compile("[0-9]").matcher(password).find())
            suggestion.append("1");

        if (!Pattern.compile("[^a-zA-Z0-9]").matcher(password).find())
            suggestion.append("@");

        while (suggestion.length() < 8)
            suggestion.append("x");

        return suggestion.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        String strength = checkStrength(password);
        System.out.println("Password Strength: " + strength);

        if (!strength.equals("Strong")) {
            System.out.println("Suggested Strong Password: " + suggestPassword(password));
        } else {
            System.out.println("Your password is secure ✅");
        }

        sc.close();
    }
}
