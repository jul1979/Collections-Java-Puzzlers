package be.smals.paumard;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class _1_ArraysAsList {

    public static void main(String[] args) {
        String[] stringArray = {"one", "two", "three"};
        List<String> stringList = Arrays.asList(stringArray);


        int[] intArray = {1, 2, 3};
        List<int[]> intList = Arrays.asList(intArray);

        System.out.print(stringList.contains("one") + ", ");
        System.out.println(intList.contains(1));
        System.out.println("stringList size = " + stringList.size());
        //System.out.println("squareRootSum(1,10) = " + squareRootSum(1,10));
        System.out.println("squareRootSum(1,10) = " + squareRootSum(5,3));
        System.out.println("compute(5,3) = " + compute(5,3));
    }


    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static double squareRootSum(int n, int k) {
        int count = 0;
        double sum = 0;
        while (count < k) {
            if (isPrime(n)) {
                sum += Math.sqrt(n);
                count++;
            }
            n++;
        }
        return sum;
    }

    public static double compute(int n, int k) {
        return Stream.iterate(n, e -> e + 1)
                .filter(_1_ArraysAsList::isPrime)
                .mapToDouble(Math::sqrt)
                .limit(k)
                .sum();
    }
}