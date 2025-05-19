package baekjoon.silver.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간_합_구하기_5 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (i > 0)
                    dp[i][j] += dp[i - 1][j];

                if (j > 0)
                    dp[i][j] += dp[i][j - 1];

                if (i > 0 && j > 0)
                    dp[i][j] -= dp[i - 1][j - 1];

                dp[i][j] += map[i][j];
            }
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            int sum = dp[x2][y2];

            if (x1 > 0)
                sum -= dp[x1 - 1][y2];
            if (y1 > 0)
                sum -= dp[x2][y1 - 1];
            if (x1 > 0 && y1 > 0)
                sum += dp[x1 - 1][y1 - 1];

            sb.append(sum).append("\n");
        }

        System.out.println(sb);

    }
}
