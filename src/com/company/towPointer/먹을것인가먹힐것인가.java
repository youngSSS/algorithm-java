package com.company.towPointer;

import java.util.ArrayList;
import java.util.Scanner;

public class 먹을것인가먹힐것인가 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> answers = new ArrayList<>();
        int t = sc.nextInt();

        for (int test_cnt = 0; test_cnt < t; test_cnt++) {
            ArrayList<Integer> listA = new ArrayList<>();
            ArrayList<Integer> listB = new ArrayList<>();
            int n = sc.nextInt();
            int m = sc.nextInt();
            int ans = 0;

            for (int i = 0; i < n; i++)
                listA.add(sc.nextInt());
            for (int i = 0; i < m; i++)
                listB.add(sc.nextInt());

            listA.sort(null);
            listB.sort(null);

            int aIdx = 0;
            int bIdx = 0;

            while (aIdx < n) {
                if (bIdx == m) {
                    ans += bIdx;
                    aIdx += 1;
                }
                else {
                    int a = listA.get(aIdx);
                    int b = listB.get(bIdx);

                    if (a <= b) {
                        aIdx += 1;
                        ans += bIdx;
                    } else
                        bIdx += 1;
                }
            }

            answers.add(ans);
        }

        answers.forEach(System.out::println);
    }

}
