package com.company.dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class 섬의개수 {

    static int w, h;
    static int[][] map;
    static int[][] visit;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        ArrayList<Integer> answers = new ArrayList<>();

        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();

            if (w == 0 && h == 0)
                break;

            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            visit = new int[h][w];

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && visit[i][j] == 0) {
                        dfs(i, j);
                        answer += 1;
                    }
                }
            }

            answers.add(answer);
            answer = 0;
        }

        answers.forEach(System.out::println);
    }

    public static void dfs(int x, int y) {
        visit[x][y] = 1;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                if (map[nx][ny] == 1 && visit[nx][ny] == 0)
                    dfs(nx, ny);
            }
        }
    }

}
