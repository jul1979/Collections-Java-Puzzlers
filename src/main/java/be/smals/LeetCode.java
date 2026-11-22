package be.smals;

import java.util.*;

public class LeetCode {

    private String[] removeFirstCharacter(String[] strs, int index) {
        return Arrays.stream(strs).map(s -> s.substring(index)).toArray(String[]::new);
    }

    private String getLongestCommonPrefix(HashMap<String, Integer> prefixes_frequencies_map, int totalElements) {
        List<String> prefixCandidates = prefixes_frequencies_map.entrySet()
                .stream().filter(entry -> entry.getValue() == totalElements)
                .map(Map.Entry::getKey).toList();
        return prefixCandidates.stream().max(Comparator.comparingInt(String::length)).orElse("");
    }


/*    private HashMap<String, Integer> prefixes_frequencies(String[] strs, HashMap<String, Integer> prefixes_frequencies) {
        //String[] strs = {"flower", "flow", "flight"};
        final int[] maxSizeElement = new int[1];
        Arrays.stream(strs).min(Comparator.comparing(String::length))
                .ifPresent(s -> maxSizeElement[0] = s.length());
        for (int i = 1; i <= maxSizeElement[0]; i++) {
            int current = i;
            Arrays.stream(strs).map(s -> s.substring(0, current))
                    .forEach(s -> prefixes_frequencies
                            .merge(s, 1, Integer::sum));
        }
        return prefixes_frequencies;
    }*/

    private HashMap<String, Integer> prefixes_frequencies(String[] strs, HashMap<String, Integer> prefixes_frequencies) {
        //String[] strs = {"flower", "flow", "flight"};
        int[] maxSizeElement = new int[1];
        Arrays.stream(strs).min(Comparator.comparing(String::length))
                .ifPresent(s -> maxSizeElement[0] = s.length());
        for (int i = 1; i <= maxSizeElement[0]; i++) {
            int current = i;
            String elementToBeComparedTo = strs[0].substring(0, current);
            //je veux compter les sous chaines qui sont égales elementToBeComparedTo
            long matchingElementsCount = Arrays.stream(strs)
                    .map(s -> s.substring(0, current))
                    .filter(s -> s.equals(elementToBeComparedTo))
                    .count();
            if (matchingElementsCount == strs.length) {
                //prefixes_frequencies.merge(elementToBeComparedTo, 1, Integer::sum);
                prefixes_frequencies.put(elementToBeComparedTo, strs.length);
            }
        }
        return prefixes_frequencies;
    }

    public String longestCommonPrefix(String[] strs) {
        Objects.requireNonNull(strs);
        //HashMap<String, Integer> prefixes_frequencies_map = new HashMap<>();
        HashMap<String, Integer> prefixes_frequencies_map = prefixes_frequencies(strs, new HashMap<>());
      /*  final int[] maxSizeElement = new int[1];
        Arrays.stream(strs).min(Comparator.comparing(String::length)).ifPresent(s -> maxSizeElement[0] = s.length());
        for (int k = 0; k < maxSizeElement[0]; k++) {
            String[] strings = removeFirstCharacter(strs, k);
            prefixes_frequencies(strings, prefixes_frequencies_map);
        }*/
        return getLongestCommonPrefix(prefixes_frequencies_map, strs.length);
    }
}
