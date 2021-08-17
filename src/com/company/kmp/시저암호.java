package com.company.kmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class 시저암호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> answers = new ArrayList<>();

        for (int count = 0; count < n; count++) {
            String alphabet = br.readLine();
            String original = br.readLine();
            String secret = br.readLine();
            ArrayList<Integer> shiftValues = new ArrayList<>();
            String message;
            HashMap<Character, Integer> alphabetMap = new HashMap<>();

            for (int i = 0; i < alphabet.length(); i++)
                alphabetMap.put(alphabet.charAt(i), i);

            for (int shiftCount = 0; shiftCount < alphabet.length(); shiftCount++) {
                StringBuilder newOriginal = new StringBuilder(original);
                for (int i = 0; i < original.length(); i++)
                    newOriginal.setCharAt(i, alphabet.charAt((alphabetMap.get(newOriginal.charAt(i)) + shiftCount) % alphabet.length()));

                if (kmp(secret, newOriginal.toString()))
                    shiftValues.add(shiftCount);
            }

            if (shiftValues.size() == 0) {
                message = "no solution";
            }
            else if (shiftValues.size() == 1) {
                message = "unique: " + shiftValues.get(0);
            }
            else {
                message = "ambiguous:";
                for (Integer shiftValue : shiftValues)
                    message += (" " + shiftValue);
            }

            answers.add(message);
        }

        answers.forEach(System.out::println);
    }

    public static boolean kmp(String text, String pattern) {
        int[] pi = getPi(pattern);
        int count = 0, j = 0;

        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j))
                j = pi[j - 1];

            if (text.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) {
                    j = pi[j];
                    count += 1;
                    if (count >= 2) return false;
                }
                else
                    j += 1;
            }
        }

        return count == 1;
    }

    public static int[] getPi(String p) {
        int[] pi = new int[p.length()];
        int j = 0;

        for (int i = 1; i < p.length(); i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j))
                j = pi[j - 1];

            if (p.charAt(i) == p.charAt(j))
                pi[i] = ++j;
        }

        return pi;
    }

}
