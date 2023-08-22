package com.urise.webapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;

public class StreamsPractice {

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 3, 3};
        System.out.println(minValue(values));
        values = new int[]{9, 8, 7, 7, 1, 2, 3, 0, 1};
        System.out.println(minValue(values));
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 3, 3));
        System.out.println(oddOrEven(list));
        list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
        System.out.println(oddOrEven(list));
    }

    static int minValue(int[] values) {
        return Arrays.stream(values)
                .distinct()
                .sorted()
                .reduce(0, (a, b) -> a * 10 + b);
    }

    static List<Integer> oddOrEven(List<Integer> integers) {
        Map<Boolean, List<Integer>> map = integers.stream()
                .collect(partitioningBy(x -> x % 2 == 0, toList()));
        return map.get(map.get(false).size() % 2 != 0);
    }
}
