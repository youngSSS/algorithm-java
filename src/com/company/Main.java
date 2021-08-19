package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int[] pi = new int[n];
        int[] reversePi = new int[n];
        long ans = 0;

        for (int i = 1, j = 0; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j))
                j = pi[j - 1];
            if (s.charAt(i) == s.charAt(j))
                pi[i] = ++j;

            // prefix == suffix 의 최소가 되는 지점을 찾기 위한 배열
            if (pi[i] != 0)
                reversePi[i] = pi[pi[i] - 1] > 0 ? reversePi[pi[i] - 1] : pi[i];

            if (reversePi[i] != 0) {
                int max = (i + 1 - reversePi[i]);
                if (max * 2 >= i + 1) ans += max;
            }
        }

        System.out.println(ans);
    }

}
