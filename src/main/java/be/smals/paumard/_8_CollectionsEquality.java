package be.smals.paumard;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _8_CollectionsEquality {

    //https://youtu.be/w6hhjg_gt_M?si=xBrxgDkAb7PpySDa(Java Collections Puzzlers by Maurice Naftalin And José Paumard)
    public static void main(String[] args) {
        var ints = List.of(1, 2, 3);
        var a = Arrays.asList(1, 2, 3);
        var c = Collections.unmodifiableCollection(ints);
        var l = Collections.unmodifiableList(ints);

        System.out.print(a.equals(c) + " ");
        System.out.print(a.equals(l) + " ");
        System.out.print(c.equals(l));
    }
}
