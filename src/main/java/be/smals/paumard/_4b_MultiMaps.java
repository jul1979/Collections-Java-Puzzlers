package be.smals.paumard;

import java.util.*;

public class _4b_MultiMaps {

    public static void main(String[] args) {

/*        var numbers = List.of(-1, 0, 1);
        Map<Integer, List<Integer>> map = new HashMap<>();
        numbers.forEach(
                number -> map.putIfAbsent(number, new ArrayList<>())
                        .add(number));
        System.out.println(map.get(0));*/

/*        var numbers = List.of(-1, 0, 1);

        Map<Integer, List<Integer>> map = new HashMap<>();
        numbers.forEach(
                number -> map.computeIfAbsent(number, ArrayList::new)
                        .add(number));
        System.out.println(map.get(0));*/

        var map = new IdentityHashMap<Integer, String>();
        map.put(1, "one");
        map.put(10, "ten");
        map.put(100, "hundred");
        map.put(1000, "thousand");
        map.put(1, "one again");
        map.put(10, "ten again");
        map.put(100, "hundred again");
        map.put(1000, "thousand again");
        System.out.print(map.size());
    }
}
