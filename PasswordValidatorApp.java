import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidatorApp {

    public static void main(String[] args) {
        List<String> passwords = Arrays.asList(
            "Abc!123",        // inválida
            "A1b2C3d!",       // válida
            "abcD!1",         // inválida
            "AAabc123!",      // válida
            "NoSpecialChar1", // inválida
            "AAabc!1"         // válida
        );

        for (String password : passwords) {
            Thread thread = new Thread(new PasswordValidator(password));
            thread.start();
        }
    }
}

class PasswordValidator implements Runnable {
    private final String password;

    public PasswordValidator(String password) {
        this.password = password;
    }

    @Override
    public void run() {
        boolean isValid = validatePassword(password);
        System.out.println("Password: \"" + password + "\" -> " + (isValid ? "VÁLIDA ✅" : "INVÁLIDA ❌"));
    }

    private boolean validatePassword(String password) {
        if (password.length() < 8) return false;

        Pattern specialCharPattern = Pattern.compile("[^a-zA-Z0-9]");
        Pattern uppercasePattern = Pattern.compile("[A-Z]");
        Pattern lowercasePattern = Pattern.compile("[a-z]");
        Pattern digitPattern = Pattern.compile("\\d");

        Matcher specialCharMatcher = specialCharPattern.matcher(password);
        Matcher uppercaseMatcher = uppercasePattern.matcher(password);
        Matcher lowercaseMatcher = lowercasePattern.matcher(password);
        Matcher digitMatcher = digitPattern.matcher(password);

        int upperCount = 0;
        int lowerCount = 0;

        while (uppercaseMatcher.find()) upperCount++;
        while (lowercaseMatcher.find()) lowerCount++;

        return specialCharMatcher.find()
            && digitMatcher.find()
            && upperCount >= 2
            && lowerCount >= 3;
    }
}
