package com.urise.webapp;

import java.util.Arrays;

public class StreamsPractice {

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 3, 3};
        System.out.println(minValue(values));
        values = new int[]{9, 8, 7, 7, 1, 2, 3, 0, 1};
        System.out.println(minValue(values));
    }

    static int minValue(int[] values) {
        return Arrays.stream(values)
                .distinct()
                .sorted()
                .reduce(0, (a,b) -> (int)Math.pow(10, (int)(Math.log10(b) + 1)) * a + b);
    }
}
