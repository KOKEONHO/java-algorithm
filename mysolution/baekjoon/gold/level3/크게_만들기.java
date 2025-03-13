package baekjoon.gold.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 크게_만들기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String numString = br.readLine();

        if (n == k) {
            System.out.println("0");
            return;
        }

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < numString.length(); i++) {
            int value = Character.getNumericValue(numString.charAt(i));
            while (!deque.isEmpty() && deque.peekLast() < value && k > 0) {
                deque.pollLast();
                k--;
            }
            deque.addLast(value);
        }

        while (k-- > 0) {
            deque.pollLast();
        }

        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }

        System.out.println(sb);

    }
}
