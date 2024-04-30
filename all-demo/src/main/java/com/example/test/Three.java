package com.example.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 伐木工
 *
 * @author zaochun.zjw
 * @date 2024/4/29
 */
public class Three {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] ints = maxLength(num);
        Arrays.sort(ints);
        Arrays.stream(ints).forEach(it -> System.out.print(it + " "));
    }

    public static int[] maxLength(int num) {
        List<Integer> res = new ArrayList<>();
        if (num < 4) {
            return new int[]{num};
        }

        while (num > 1) {
            if (num - 6 >= 0) {
                num = num - 3;
                res.add(3);
                continue;
            }

            if (num == 5) {
                res.add(3);
                res.add(2);
                break;
            }

            if (num - 4 >= 0) {
                num = num - 4;
                res.add(4);
                continue;
            }
            if (num - 3 >= 0) {
                num = num - 3;
                res.add(3);
                continue;
            }
            if (num - 2 >= 0) {
                num = num - 2;
                res.add(2);
                continue;
            }
        }

        return convert(res);
    }

    public static int[] convert(List<Integer> list) {
        int[] resNum = new int[list.size()];
        for (int i = 0; i < resNum.length; i++) {
            resNum[i] = list.get(i);
        }

        return resNum;
    }
}
