package com.company.towPointer;

import java.util.ArrayList;
import java.util.Scanner;

public class 수들의합2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n; i++)
            numbers.add(sc.nextInt());

        int end = 0, cnt = 0, sum = 0;
        for (int start = 0; start < n; start++) {
            while (sum < m && end < n) {
                sum += numbers.get(end);
                end += 1;
            }

            if (sum == m)
                cnt += 1;

            sum -= numbers.get(start);
        }
    }

}
