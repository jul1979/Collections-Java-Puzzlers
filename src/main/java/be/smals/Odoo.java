package be.smals;

import java.util.*;

public class Odoo {

    public List<Character> charFrequencies(Character[] elements) {
        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
        List<Character> mostFrequentCharacters = new ArrayList<>();
        Arrays.stream(elements).forEach(c -> characterIntegerHashMap.merge(c, 1, Integer::sum));
        characterIntegerHashMap.values().stream().max(Integer::compareTo).ifPresent(maxFrequency -> {
            characterIntegerHashMap.entrySet().stream()
                    .filter(entry -> entry.getValue().equals(maxFrequency))
                    .forEach(entry -> mostFrequentCharacters.add(entry.getKey()));
        });
        return mostFrequentCharacters;
    }

    public HashMap<Integer, Integer> matchers(int[] numbers, int target) {
        HashMap<Integer, Integer> duos = new HashMap<>();
        for (var startIndex = 0; startIndex < numbers.length - 1; startIndex++) {
            findMatchingDuos(numbers, target, startIndex, duos);
        }
        return duos;
    }
    private HashMap<Integer, Integer> findMatchingDuos(int[] numbers, int target, int startindex, HashMap<Integer, Integer> duos) {
        //[2, 7, 11, 15] //0,1,2,3 //length = 4
        int fixedIndex = startindex;
        while (startindex < numbers.length - 1) {
            if (numbers[fixedIndex] + numbers[++startindex] == target) {
                duos.put(numbers[fixedIndex], numbers[startindex]);
            }
        }
        return duos;
    }
    public Set<Integer> removeDuplicates (int [] numbers){
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        Arrays.stream(numbers).forEach((number)->integerIntegerHashMap.merge(number,1,Integer::sum));
        return integerIntegerHashMap.keySet();
    }
    public int removeElement(int[] nums, int val) {
        var singles = new ArrayList<>();
        Arrays.stream(nums).filter((num)->num!=val).forEach(singles::add);
        System.out.println("singles = " + singles);
        return  singles.size();
    }

    /*Input: haystack = "sadbutsad", needle = "sad"
    Output: 0
    Explanation: "sad" occurs at index 0 and 6.
    The first occurrence is at index 0, so we return 0.
    Example 2:

    Input: haystack = "leetcode", needle = "leeto"
    Output: -1
    Explanation: "leeto" did not occur in "leetcode", so we return -1.*/
    public int displayMatchingIndex(String haystack, String needle) {
        for (int index = 0; index <= (haystack.length() - needle.length()); index++) {
            if (checkIfIndexMatch(haystack, needle, index)) return index;
        }
        return -1;
    }

    private boolean checkIfIndexMatch(String haystack, String needle, int index) {
        int i = 0;
        while (i < needle.length() && haystack.charAt(index) == needle.charAt(i)) {
            index++;
            i++;
        }
        return i == needle.length();
    }

    public static boolean estEquilibre(String expression) {
        Stack<Character> pile = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                pile.push(c);
            } else {
                if (pile.isEmpty()) return false;
                char dernier = pile.pop();
                if (!((dernier == '(' && c == ')') ||
                        (dernier == '{' && c == '}') ||
                        (dernier == '[' && c == ']'))) {
                    return false;
                }
            }
        }
        return pile.isEmpty();
    }
}
