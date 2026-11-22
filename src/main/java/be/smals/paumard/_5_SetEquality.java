package be.smals.paumard;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class _5_SetEquality {

    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>(List.of("a", "b", "c"));
        Set<String> treeSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        treeSet.addAll(List.of("A", "B", "C"));

        System.out.print(treeSet.equals(hashSet) + " ");
        System.out.print(hashSet.equals(treeSet));
        //le treeSet utilise le comparator/comparable pour définir le equals!
    }
}
