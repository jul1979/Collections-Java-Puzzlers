package be.smals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneExtractor {
    public static void main(String[] args) {
        String texte = "Veuillez contacter le support au (123) 456-7890 ou l'agence au (987) 654-3210.";
        // Motifs de chiffres (\\d) avec parenthèses et tiret échappés
        String phoneRegex = "\\(\\d\\d\\d\\) \\d\\d\\d-\\d\\d\\d\\d";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(texte);
        //find() avance à la prochaine occurrence trouvée dans le texte
        while (matcher.find()) {
            System.out.println("Numéro extrait : " + matcher.group() + " à l'index de début : " + matcher.start());
        }
    }
}
