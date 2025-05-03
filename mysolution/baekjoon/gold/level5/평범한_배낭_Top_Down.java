package baekjoon.gold.level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 평범한_배낭_Top_Down {

    private static int N, K;
    private static int[][] items;
    private static int[][] memo;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 물건 개수
        K = Integer.parseInt(st.nextToken());   // 배낭 무게 제한

        items = new int[N][2];
        memo = new int[N + 1][K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken()); // 무게
            items[i][1] = Integer.parseInt(st.nextToken()); // 가치
        }

        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(memo[i], -1);
        }

        System.out.println(dp(0, 0));

    }

    private static int dp(int idx, int weight) {

        if (idx == N)
            return 0;

        if (memo[idx][weight] != -1)
            return memo[idx][weight];

        int skip = dp(idx + 1, weight);

        int take = 0;

        if (weight + items[idx][0] <= K) {
            take = dp(idx + 1, weight + items[idx][0]) + items[idx][1];
        }

        memo[idx][weight] = Math.max(skip, take);

        return memo[idx][weight];

    }
}
