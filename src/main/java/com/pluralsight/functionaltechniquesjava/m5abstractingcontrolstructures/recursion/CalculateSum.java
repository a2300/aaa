package com.pluralsight.functionaltechniquesjava.m5abstractingcontrolstructures.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.pluralsight.functionaltechniquesjava.m5abstractingcontrolstructures.ListUtils.*;

public class CalculateSum {
    public static void main(String args[]) {
//        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        // To cause a stack overflow
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(i+1);
        }

        int total = sumImperative(list);
        System.out.println(total);

        System.out.println();
        total = sumTail(list, 0);
        System.out.println(total);
    }

    public static int sumImperative(List<Integer> list) {
        int total = 0;

        for (int i : list) {
            total += i;
        }

        return total;
    }

    public static int sum(List<Integer> list) {
        return list.isEmpty()
                ? 0
                : head(list) + sum(tail(list));
    }

    public static int sumTail(List<Integer> list, int acc) {
        if (list.isEmpty()) {
            return 0;
        } else {
            int x = head(list);
            int y = acc;
            int total = x + y;
            return sumTail(tail(list), total);
        }

    }
}
