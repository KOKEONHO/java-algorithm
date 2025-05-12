package baekjoon.silver.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 더하기_1_2_3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] numbers = new int[]{1, 2, 3};

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] dp = new int[n + 1];
            dp[0] = 1;

            for (int i = 1; i < n + 1; i++) {
                for (int number : numbers) {
                    if (i - number >= 0)
                        dp[i] += dp[i - number];
                }
            }

            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb);

    }
}

