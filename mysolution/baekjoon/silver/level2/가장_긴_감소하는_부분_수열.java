package baekjoon.silver.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장_긴_감소하는_부분_수열 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] sequence = new int[N];

        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int result = dp[0];

        for (int i = 1; i < N; i++) {
            int number = sequence[i];
            for (int j = 0; j < i; j++) {
                if (sequence[i] < sequence[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    result = Math.max(result, dp[i]);
                }
            }
        }

        System.out.println(result);

    }
}

