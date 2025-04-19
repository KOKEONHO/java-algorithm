package baekjoon.gold.level5;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 행복_유치원 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 원생 수
        int K = Integer.parseInt(st.nextToken());   // 나누려는 조 수

        int[] kids = new int[N];
        PriorityQueue<Integer> gaps = new PriorityQueue<>(Comparator.reverseOrder());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            kids[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            gaps.add(kids[i] - kids[i - 1]);
        }

        while (K-- > 1) {
            gaps.poll();
        }

        int total = 0;

        while (!gaps.isEmpty()) {
            total += gaps.poll();
        }

        System.out.println(total);

    }
}
