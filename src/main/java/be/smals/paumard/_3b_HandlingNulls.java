package be.smals.paumard;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class _3b_HandlingNulls {

    public static void main(String[] args) {
        String[] ints = {"a", "b", "c", null};

        List<String> strings = Stream.of(ints).toList();
        strings.removeIf(Objects::isNull);
        System.out.print(strings.size());
    }
}