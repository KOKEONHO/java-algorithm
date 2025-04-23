package baekjoon.gold.level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 풍선_맞추기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = 0;
        int[] arrow = new int[1_000_001];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());

            if (arrow[height] > 0) {
                arrow[height]--;
                arrow[height - 1]++;
                continue;
            }

            result++;
            arrow[height - 1]++;
        }

        System.out.println(result);

    }
}
