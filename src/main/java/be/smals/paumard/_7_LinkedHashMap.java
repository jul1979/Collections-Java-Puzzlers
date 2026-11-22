package be.smals.paumard;

import java.util.LinkedHashMap;
import java.util.Map;

public class _7_LinkedHashMap {
    public static void main(String[] args) {
        Map<String, Integer> map = LinkedHashMap.newLinkedHashMap(3);
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("b", 4);
        System.out.print(map.get("a"));
        System.out.print(map);
    }
}
