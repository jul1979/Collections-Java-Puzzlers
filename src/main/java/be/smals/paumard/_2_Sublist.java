package be.smals.paumard;

import java.util.ArrayList;
import java.util.List;

public class _2_Sublist {

    public static void main(String[] args) {
        var ints = new ArrayList<>(List.of(1, 2, 3, 4, 5));

        List<Integer> sublist = ints.subList(0, 1);
        System.out.print(sublist + " ");

        sublist.addAll(List.of(10, 11, 12));
        System.out.print(ints);
    }
}