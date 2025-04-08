package leetcode.easy;

import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;

class LongestPalindrome {

    public int longestPalindrome(String s) {

        int result = 0;
        boolean oddAppeared = false;

        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        maxHeap.addAll(map.values());

        while (!maxHeap.isEmpty()) {
            int polled = maxHeap.poll();
            if (polled % 2 != 0) {
                if (!oddAppeared) {
                    result += polled;
                    oddAppeared = true;
                    continue;
                }
                result += polled - 1;
                continue;
            }
            result += polled;
        }

        return result;

    }
}
