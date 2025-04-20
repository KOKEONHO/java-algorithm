package baekjoon.gold.level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 꿀_따기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] honey = new int[N];
        int[] prefixSum = new int[N];
        int[] suffixSum = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            honey[i] = Integer.parseInt(st.nextToken());
        }

        prefixSum[N - 1] = 0;

        for (int i = N - 2; i >= 0; i--) {
            prefixSum[i] = prefixSum[i + 1] + honey[i + 1];
        }

        suffixSum[0] = 0;

        for (int i = 1; i < N; i++) {
            suffixSum[i] = suffixSum[i - 1] + honey[i - 1];
        }

        long headMax = Long.MIN_VALUE;

        for (int i = 1; i < N - 1; i++) {
            headMax = Math.max(headMax, prefixSum[i] - honey[i]);
        }
        headMax += prefixSum[0];

        long tailMax = Long.MIN_VALUE;

        for (int i = N - 2; i > 0; i--) {
            tailMax = Math.max(tailMax, suffixSum[i] - honey[i]);
        }
        tailMax += suffixSum[N - 1];

        long bodyMax = Long.MIN_VALUE;

        for (int i = 1; i < N - 1; i++) {
            bodyMax = Math.max(bodyMax, (prefixSum[0] - prefixSum[i]) + (suffixSum[N - 1] - suffixSum[i]));
        }

        System.out.println(Math.max(Math.max(headMax, tailMax), bodyMax));
    }
}
