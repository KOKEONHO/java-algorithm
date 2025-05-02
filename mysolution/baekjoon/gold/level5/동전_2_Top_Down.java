package baekjoon.gold.level5;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
    recursion + memoization 풀이
*/

public class 동전_2_Top_Down {

    private static Map<Integer, Integer> memo;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        memo = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());    // 동전 종류
        int k = Integer.parseInt(st.nextToken());    // 목표 합

        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(dp(coins, k));

    }

    private static int dp(int[] coins, int remainder) {

        if (remainder == 0)
            return 0;

        if (remainder < 0)
            return -1;

        if (memo.containsKey(remainder))
            return memo.get(remainder);

        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            int result = dp(coins, remainder - coin);
            if (result >= 0 && result < min) {
                min = result + 1;
            }
        }

        memo.put(remainder, min == Integer.MAX_VALUE ? -1 : min);

        return memo.get(remainder);

    }
}