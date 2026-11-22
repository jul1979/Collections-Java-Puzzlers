package be.smals.paumard;

import java.util.List;
import java.util.stream.Stream;

public class _3_HandlingNulls {

    public static void main(String[] args) {
        String[] ints = {"a", "b", "c", null};

        List<String> strings1 = Stream.of(ints).toList();
        System.out.print(strings1.size());

        List<String> strings2 = List.of(ints);
        System.out.print(strings2.size());
    }
}