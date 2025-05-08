package baekjoon.gold.level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 합분해 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 0 ~ N
        int K = Integer.parseInt(st.nextToken());   // 사용 숫자 개수

        int[][] dp = new int[K + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                for (int x = 0; x <= j; x++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - x]) % 1_000_000_000;
                }
            }
        }

        System.out.println(dp[K][N]);

    }
}
