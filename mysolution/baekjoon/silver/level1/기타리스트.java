package baekjoon.silver.level1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기타리스트 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());    // 곡 개수
        int S = Integer.parseInt(st.nextToken());    // 시작 볼륨
        int M = Integer.parseInt(st.nextToken());    // 최대 볼륨

        st = new StringTokenizer(br.readLine());

        int[] vols = new int[N];
        boolean[][] dp = new boolean[N + 1][M + 1];    // Bottom-Up

        for (int i = 0; i < N; i++) {
            vols[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][S] = true;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M + 1; j++) {
                if (dp[i][j]) {
                    int volUp = j + vols[i];
                    int volDown = j - vols[i];

                    if (volUp <= M) {
                        dp[i + 1][volUp] = true;
                    }

                    if (volDown >= 0) {
                        dp[i + 1][volDown] = true;
                    }
                }
            }
        }

        for (int i = M; i >= 0; i--) {
            if (dp[N][i]) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);

    }
}
