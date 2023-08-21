package com.urise.webapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsPractice {

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 3, 3};
        System.out.println(minValue(values));
        values = new int[]{9, 8, 7, 7, 1, 2, 3, 0, 1};
        System.out.println(minValue(values));
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 3, 3));
        System.out.println(oddOrEven(list));
        list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println(oddOrEven(list));
    }

    static int minValue(int[] values) {
        return Arrays.stream(values)
                .distinct()
                .sorted()
                .reduce(0, (a, b) -> (int) Math.pow(10, (int) (Math.log10(b) + 1)) * a + b);
    }

    static List<Integer> oddOrEven(List<Integer> integers) {
        int mod = integers.stream().reduce(Integer::sum).get() % 2;
        return integers
                .stream()
                .filter(n -> n % 2 != mod)
                .collect(Collectors.toList());
    }
}
