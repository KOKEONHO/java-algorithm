package baekjoon.gold.level5;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class 사과나무 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int one = 0;
        int two = 0;
        String result = "YES";

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i) {
            int num = Integer.parseInt(st.nextToken());
            sum += num;
            one += num % 2;
            two += num / 2;
        }

        if (sum % 3 > 0 || one > two) {
            result = "NO";
        }

        System.out.println(result);
    }
}

