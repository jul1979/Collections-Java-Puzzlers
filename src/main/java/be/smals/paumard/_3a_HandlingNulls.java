package be.smals.paumard;

import java.util.List;
import java.util.stream.Stream;

public class _3a_HandlingNulls {

    public static void main(String[] args) {
        String[] ints = {"a", "b", "c", null};

        var strings1 = Stream.of(ints).toList();
        System.out.print(strings1.size());

        var strings2 = List.of(ints);
        System.out.print(strings2.size());
    }
}
