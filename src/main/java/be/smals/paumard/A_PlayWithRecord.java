package be.smals.paumard;

import java.util.Iterator;

public class A_PlayWithRecord {

    record Range(int begin, int end) implements Iterable<Integer> {
        Range {
            if (begin > end) {
                throw new IllegalStateException("End should be greater than begin");
            }
        }

        Range(int begin) {
            this(begin, 0);
        }

        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<>() {
                int index = begin;

                @Override
                public boolean hasNext() {
                    return index < end;
                }

                @Override
                public Integer next() {
                    return index++;
                }
            };
        }
    }

    public static void main(String[] args) {
        Range range = new Range(0, 5);
        for (int value : range) {
            System.out.println("value = " + value);
        }
    }
}
