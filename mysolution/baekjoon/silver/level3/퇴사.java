package baekjoon.silver.level3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] counsels = new int[N][2];
        int[] dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            counsels[i] = new int[]{T, P};
        }

        for (int i = N - 1; i >= 0; i--) {
            int[] counsel = counsels[i];

            int time = counsel[0];
            int pay = counsel[1];

            if (i + time < N + 1) {
                dp[i] = Math.max(dp[i + time] + pay, dp[i + 1]);
            } else {
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[0]);

    }
}
