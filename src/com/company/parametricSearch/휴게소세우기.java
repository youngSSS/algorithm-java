package com.company.parametricSearch;

import java.util.ArrayList;
import java.util.Scanner;

public class 휴게소세우기 {

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int l = sc.nextInt();
        ArrayList<Integer> restArea = new ArrayList<>();
        int ans = 0;

        for (int i = 0; i < n; i++)
            restArea.add(sc.nextInt());
        restArea.add(0);
        restArea.add(l);
        restArea.sort(null);

        int left = 0;
        int right = l;
        while (left <= right) {
            int param = (left + right) / 2;
            int cnt = 0;
            for (int i = 1; i < restArea.size(); i++)
                cnt += (restArea.get(i) - 1 - restArea.get(i - 1)) / param;

            if (cnt > m)
                left = param + 1;
            else {
                ans = param;
                right = param - 1;
            }

        }

        System.out.println(ans);
    }

}

