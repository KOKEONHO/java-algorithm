package baekjoon.gold.level5;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한_배낭_Bottom_Up {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());    // 물건 수
        int K = Integer.parseInt(st.nextToken());    // 배낭 무게 제한

        int[][] items = new int[N][2];
        int[] dp = new int[K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            items[i][0] = weight;
            items[i][1] = value;
        }

        for (int i = 0; i < N; i++) {
            int currWeight = items[i][0];
            int currValue = items[i][1];

            for (int j = K; j >= currWeight; j--) {
                dp[j] = Math.max(dp[j], dp[j - currWeight] + currValue);
            }
        }

        int result = Integer.MIN_VALUE;
        for (int value : dp) {
            if (result < value) {
                result = value;
            }
        }

        System.out.println(result);

    }
}