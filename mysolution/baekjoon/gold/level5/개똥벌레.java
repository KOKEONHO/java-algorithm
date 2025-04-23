package baekjoon.gold.level5;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 개똥벌레 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());    // 동굴 길이
        int H = Integer.parseInt(st.nextToken());    // 동굴 높이

        /*
            석순과 종유석을 별개의 배열에 담아 계산

            누적합 계산 시 `Array Index Out of Bounds`를 회피하기 위해 배열 크기를 H + 2로 선언
        */

        int[] bottom = new int[H + 2];
        int[] top = new int[H + 2];

        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());

            if (i % 2 == 0) {
                bottom[height]++;
            } else {
                top[height]++;
            }
        }

        for (int i = H; i > 0; i--) {
            top[i] += top[i + 1];
            bottom[i] += bottom[i + 1];
        }

        int min = Integer.MAX_VALUE;
        int minCnt = 0;

        for (int i = 1; i < H + 1; i++) {
            int crash = bottom[i] + top[H - i + 1];
            if (crash < min) {
                min = crash;
                minCnt = 1;
                continue;
            }
            if (crash == min) {
                minCnt++;
            }
        }

        sb.append(min).append(" ").append(minCnt);

        System.out.println(sb);

    }

}