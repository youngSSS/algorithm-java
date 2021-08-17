package com.company.kmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 광고 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        String text = br.readLine();

        int[] pi = new int[l];
        int j = 0;

        for (int i = 1; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != text.charAt(j))
                j = pi[j - 1];
            if (text.charAt(i) == text.charAt(j))
                pi[i] = ++j;
        }

        System.out.println(text.length() - pi[l - 1]);
    }

}
