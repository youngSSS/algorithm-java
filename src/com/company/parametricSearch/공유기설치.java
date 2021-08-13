package com.company.parametricSearch;

import java.util.ArrayList;
import java.util.Scanner;

public class 공유기설치 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        ArrayList<Integer> houses = new ArrayList<>();
        int ans = 0;

        for (int i = 0; i < n; i++)
            houses.add(sc.nextInt());
        houses.sort(null);

        int min = 1;
        int max = houses.get(n - 1) - houses.get(0);
        while (min <= max) {
            int param = (min + max) / 2;
            int now = houses.get(0);
            int cnt = 1;

            for (int i = 1; i < n; i++) {
                int next = houses.get(i);
                if (next - now >= param) {
                    now = next;
                    cnt += 1;
                }
            }

            if (cnt >= c) {
                min = param + 1;
                ans = param;
            }
            else {
                max = param - 1;
            }
        }

        System.out.println(ans);
    }

}
