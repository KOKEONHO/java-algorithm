package baekjoon.gold.level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 전깃줄 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<int[]> lines = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            lines.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        lines.sort(Comparator.comparingInt(o -> o[0]));

        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        int result = dp[0];

        for (int i = 1; i < N; i++) {
            int currTo = lines.get(i)[1];
            for (int j = 0; j < i; j++) {
                int tempTo = lines.get(j)[1];
                if (currTo > tempTo) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }

        System.out.println(N - result);

    }
}

