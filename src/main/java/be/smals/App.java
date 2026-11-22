package be.smals;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Main method
 */
public class App {
    public static void main(String[] args) {
        String haystack = "leetcode";
        String needle = "e";
        String test = "({[]})";
        System.out.println(new Odoo().displayMatchingIndex(haystack, needle));
        Collection<String> names = Collections.emptyList();
        //System.out.println(Odoo.estEquilibre("({[]})")); // true
        //System.out.println(Odoo.estEquilibre("({[})"));  // false
        //System.out.println(Odoo.estEquilibre("()[]{}"));  // true
        /*String[] test1 = {"flower", "flow", "flight"};
        String[] test2 = {"lower", "low", "light"};
        String[] test3 = {"ower", "ow", "ight"};
        String[] test4 = {"wer", "w", "ght";
        System.out.println(leetCode.longestCommonPrefix(test1, prefixes_frequencies));*/
        //leetCode.longestCommonPrefix(test1);
        //leetCode.longestCommonPrefix(test2);
        //leetCode.longestCommonPrefix(test3);
        //leetCode.longestCommonPrefix(test4);

        //System.out.println("maxSizeElement = " + maxSizeElement[0]);
        /*Solution solution = new Solution();
        String ssnTest1 = "93051822361";
        String ssnTest2 = "02031003152";// "02031003152"
        String ssnTest3 = "12345678900";
        String ssnTest4 = " ";
        String ssnTest5 = "79120442534";
        System.out.println("93051822361 is valid? : " + solution.validator(ssnTest1));
        System.out.println("02031003152 is valid? : " + solution.validator(ssnTest2));
        System.out.println("12345678900 is valid? : " + solution.validator(ssnTest3));
        System.out.println("empty string is valid? : " + solution.validator(ssnTest4));
        System.out.println("79120442534 is valid? : " + solution.validator(ssnTest5));*/
        Consumer<String> moto = (name) -> System.out.println("name = " + name);
        moto.accept("jules");
        // Ce code lève une NullPointerException !
        Optional<String> myValue = Optional.ofNullable(null);
    }
}
