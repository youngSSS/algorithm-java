package com.company.kmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 라디오전송 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int[] pi = new int[s.length()];

        int j = 0;
        for (int i = 1; i < l; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j))
                j = pi[j - 1];
            if (s.charAt(i) == s.charAt(j))
                pi[i] = ++j;
        }

        System.out.println(l - pi[l - 1]);
    }

}
