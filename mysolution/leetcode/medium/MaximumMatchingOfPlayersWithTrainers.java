package leetcode.medium;

import java.util.PriorityQueue;

public class MaximumMatchingOfPlayersWithTrainers {

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {

        int result = 0;

        PriorityQueue<Integer> playersHeap = new PriorityQueue<>();
        PriorityQueue<Integer> trainersHeap = new PriorityQueue<>();

        for (int player : players) {
            playersHeap.add(player);
        }

        for (int trainer : trainers) {
            trainersHeap.add(trainer);
        }

        while (!playersHeap.isEmpty()) {
            int player = playersHeap.poll();
            while (!trainersHeap.isEmpty() && trainersHeap.peek() < player) {
                trainersHeap.poll();
            }
            if (trainersHeap.isEmpty()) {
                break;
            }
            trainersHeap.poll();
            result++;
        }

        return result;

    }
}
