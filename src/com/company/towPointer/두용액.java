package com.company.towPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 두용액 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> liquid = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        int ansMin = 0, ansMax = 0;
        int ansGap = Integer.MAX_VALUE;

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            liquid.add(Integer.parseInt(input[i]));
        liquid.sort(null);

        int minPointer = 0;
        int maxPointer = n - 1;

        while (minPointer < maxPointer) {
            int minValue = liquid.get(minPointer);
            int maxValue = liquid.get(maxPointer);
            int gap = minValue + maxValue;

            if (Math.abs(gap) < ansGap) {
                ansMin = minValue;
                ansMax = maxValue;
                ansGap = Math.abs(gap);
            }

            int nextMinPointer = minPointer + 1;
            int nextMaxPointer = maxPointer - 1;
            int minGap = Math.abs(liquid.get(nextMinPointer) + maxValue);
            int maxGap = Math.abs(minValue + liquid.get(nextMaxPointer));

            if (minGap < maxGap) minPointer = nextMinPointer;
            else maxPointer = nextMaxPointer;
        }

        System.out.println(ansMin + " " + ansMax);
    }

}
