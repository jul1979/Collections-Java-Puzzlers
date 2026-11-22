package be.smals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    public static void main(String[] args) {
        // Expression régulière proposée dans le livre
        String emailRegex = "(?i)[^@]+@[^@]+\\.[a-z]+";
        Pattern pattern = Pattern.compile(emailRegex);
        String[] adressesAValider = {"good@some.domain", "me@oreilly.COM", "bad.address@", "bad@oreilly@com"};
        for (String email : adressesAValider) {
            Matcher matcher = pattern.matcher(email);
            // matches() vérifie si la totalité de la chaîne respecte le motif
            boolean estValide = matcher.matches();
            System.out.println(email + "->" + (estValide ? "VALIDE" : "INVALIDE"));
        }
    }
}