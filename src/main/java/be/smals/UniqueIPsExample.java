package be.smals;

import java.util.regex.Pattern;
import java.util.stream.Stream;

public class UniqueIPsExample {

    public static void main(String[] args) {
        // Expression régulière pour reconnaître une adresse IP (ex. 192.168.1.1)
        Pattern ipAddress = Pattern.compile("\\d+\\.\\d+\\.\\d+\\.\\d+");
        Pattern separator = Pattern.compile("\\s+");

        Stream<String> lignesDuFichier = Stream.of(
                "192.168.1.1 GET /index.html 200",
                "mot_invalide 10.0.0.1 - - [29/Sep/2026]",
                "192.168.1.1 POST /login 200"
        );

        long ipUniquesCount = lignesDuFichier
                .flatMap(ligne -> separator.splitAsStream(ligne))
                .filter(mot -> ipAddress.matcher(mot).matches()) // Utilisation de matcher().
                .distinct()
                .count();
        System.out.println("Nombre d'adresses IP uniques trouvées : " + ipUniquesCount);
    }
}
