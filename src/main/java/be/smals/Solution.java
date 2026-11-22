package be.smals;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Solution {


    /**
     * Vérifie la validité d'un numéro d'identification (SSIN) belge.
     * <p>
     * Le SSIN doit comporter exactement 11 chiffres. Les deux derniers chiffres
     * représentent une clé de contrôle calculée à partir des neuf premiers chiffres
     * via un modulo 97. Si la vérification échoue avec l'interprétation "ancienne
     * génération" (né avant 2000), la méthode réessaie en préfixant le SSIN par "2",
     * conformément à la règle appliquée aux personnes nées à partir de 2000.
     *
     * @param ssin le numéro SSIN à valider, sous forme de chaîne de 11 chiffres (non {@code null})
     * @return {@code true} si le SSIN est valide, {@code false} sinon (longueur incorrecte,
     * format non numérique, ou clé de contrôle invalide)
     * @throws NullPointerException si {@code ssin} est {@code null}
     */
    public boolean validator(String ssin) {
        Objects.requireNonNull(ssin);
        if (ssin.length() != 11) {
            return false;
        }
        String TWO = "2";
        try {
            String lastTwoDigits = ssin.substring(9);//indice vont de 0 à 10
            int lastTwoDigitsAsInt = Integer.parseInt(lastTwoDigits);
            if (!(checksum(ssin, lastTwoDigitsAsInt))) {
                //ajouter 2 au ssin et rappeller la méthode checksum
                String caseWithTwoAddedToSsn = TWO + ssin;
                return checksum(caseWithTwoAddedToSsn, lastTwoDigitsAsInt);
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Calcule et vérifie la clé de contrôle d'un SSIN à partir de ses premiers chiffres.
     * <p>
     * Extrait les 9 (SSIN de longueur 11) ou 10 (SSIN de longueur 12, préfixé par "2")
     * premiers chiffres, puis vérifie que {@code 97 - (nombre % 97)} correspond bien
     * à la clé de contrôle fournie.
     *
     * @param ssin               le SSIN (éventuellement préfixé par "2") dont on extrait les premiers chiffres
     * @param lastTwoDigitsAsInt la clé de contrôle attendue (deux derniers chiffres du SSIN)
     * @return {@code true} si la clé de contrôle calculée correspond à {@code lastTwoDigitsAsInt}
     * @throws NumberFormatException si les chiffres extraits ne forment pas un entier valide
     */
    private boolean checksum(String ssin, int lastTwoDigitsAsInt) {
        String firstNineOrTenDigitsAsAString = switch (ssin.length()) {
            case 11 -> ssin.substring(0, 9);
            case 12 -> ssin.substring(0, 10);
            default -> "";
        };
        int firstNineDigitsAsanInt = Integer.parseInt(firstNineOrTenDigitsAsAString);
        //tester le modulo
        return (97 - (firstNineDigitsAsanInt % 97)) == lastTwoDigitsAsInt;
    }

    public static int test() {
        try {
            return 1;
        } finally {
            System.out.println("Bloc finally exécuté !");
        }
    }

    public static void main(String[] args) {
        String name = "latéléréalitécestdelaMerde";
       /*  String distinctLetters = name.chars().filter(Character::isAlphabetic)
                .map(Character::toLowerCase)
                .distinct()
                .mapToObj(Character::toString)
                .collect(Collectors.joining());*/

        Map<Character, Long> frequencies = name.chars().filter(Character::isAlphabetic)
                .map(Character::toLowerCase)
                .mapToObj((c) -> (char) c)
                .collect(groupingBy(Function.identity(), Collectors.counting()));
        //System.out.println("frequencies = " + frequencies);
        List<Map.Entry<Character, Long>> mostFrequentLetters = frequencies.entrySet().stream()
                .sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
                .limit(4)
                .toList();
        //System.out.println("mostFrequentLetters = " + mostFrequentLetters);

        Map<Long, List<Character>> map =
                frequencies.entrySet().stream().collect(Collectors.groupingBy(
                        Map.Entry::getValue,
                        Collectors.mapping(
                                Map.Entry::getKey,
                                Collectors.toList()
                        )
                ));
        Map.Entry<Long, List<Character>> mostSeenLetter = map.entrySet().stream().max(Map.Entry.comparingByKey()).orElseThrow();
        List<Map.Entry<Long, List<Character>>> mostSeenLetters = map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).toList();
        //System.out.println("mostSeenLetter = " + mostSeenLetter);
        //System.out.println("mostSeenLetters = " + mostSeenLetters);
        //System.out.println("map = " + map);

       /* frequencies.forEach((key, value) -> System.out.println("{key = " + key + ":" + "value = " + value + "}"));
        //Optional<Long> max = frequencies.values().stream().max(Comparator.naturalOrder());
        long max = frequencies.values().stream().max(Comparator.naturalOrder()).get();
        HashSet<Character> mostFrequents = new HashSet<>();
        // System.out.println("max = " + (max.isPresent()?max.get():0));
        frequencies.entrySet().stream()
                .filter((key)->key.getValue()==max)
                .forEach((e)->mostFrequents.add(e.getKey()));
        Map.Entry<Character, Long> characterLongEntry = frequencies.entrySet().stream().max(Map.Entry.comparingByValue()).orElseThrow();
       // System.out.println("mostFrequents = " + mostFrequents);

        System.out.println("characterLongEntry = " + characterLongEntry);*/
        String coordinates = "50.85:4.35";
        double latitude = Double.parseDouble(coordinates.split(":")[0]);
        double longitude = Double.parseDouble(coordinates.split(":")[1]);
        System.out.println("longitude = " + longitude);
        System.out.println("latitude = " + latitude);
    }
}
