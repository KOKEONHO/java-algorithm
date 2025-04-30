package baekjoon.silver.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 동물원 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] cage = new int[N][3];

        cage[0][0] = 1;     // 0열에 아무 사자 없음
        cage[0][1] = 1;     // 0열 왼쪽에 사자
        cage[0][2] = 1;     // 0열 오른쪽에 사자

        for (int i = 1; i < N; i++) {
            cage[i][0] = (cage[i - 1][0] + cage[i - 1][1] + cage[i - 1][2]) % 9901;
            cage[i][1] = (cage[i - 1][0] + cage[i - 1][2]) % 9901;
            cage[i][2] = (cage[i - 1][0] + cage[i - 1][1]) % 9901;
        }

        int result = (cage[N - 1][0] + cage[N - 1][1] + cage[N - 1][2]) % 9901;

        System.out.println(result);

    }
}
