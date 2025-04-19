package baekjoon.gold.level5;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 물병 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int buyCnt = 0;
        int oneCnt = 0;

        String binary = Integer.toBinaryString(N);

        for (char ch : binary.toCharArray()) {
            if (ch == '1') {
                oneCnt++;
            }
        }

        while (oneCnt > K) {
            buyCnt++;
            oneCnt = 0;

            binary = Integer.toBinaryString(++N);

            for (char ch : binary.toCharArray()) {
                if (ch == '1') {
                    oneCnt++;
                }
            }
        }

        System.out.println(buyCnt);

    }
}