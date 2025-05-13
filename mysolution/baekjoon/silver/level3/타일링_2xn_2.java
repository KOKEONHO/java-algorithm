package baekjoon.silver.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 타일링_2xn_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < N + 1; i++) {
            dp[i] += (dp[i - 1] + dp[i - 2] * 2) % 10_007;
        }

        System.out.println(dp[N]);

    }
}
