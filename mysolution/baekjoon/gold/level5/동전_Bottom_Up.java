package baekjoon.gold.level5;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전_Bottom_Up {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());    // 테스트 케이스 수

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());    // 동전 종류 수
            int[] coins = new int[N];    // 동전 종류 배열

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());    // 만들어야 하는 금액
            int[] dp = new int[M + 1];
            dp[0] = 1;

            for (int coin : coins) {
                for (int i = 1; i < M + 1; i++) {
                    if (i - coin >= 0) {
                        dp[i] += dp[i - coin];
                    }
                }
            }

            sb.append(dp[M]).append("\n");
        }

        System.out.println(sb);

    }
}
