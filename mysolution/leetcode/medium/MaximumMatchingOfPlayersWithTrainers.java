package leetcode.medium;

import java.util.Arrays;

public class MaximumMatchingOfPlayersWithTrainers {

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {

        Arrays.sort(players);
        Arrays.sort(trainers);

        int result = 0;
        int trainersPointer = 0;
        int trainersLength = trainers.length;

        for (int player : players) {
            while (trainersPointer < trainersLength && player > trainers[trainersPointer]) {
                trainersPointer++;
            }
            if (trainersPointer == trainersLength) {
                break;
            }
            result++;
            trainersPointer++;
        }

        return result;

    }
}
