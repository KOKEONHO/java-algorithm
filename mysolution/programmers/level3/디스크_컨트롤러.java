package programmers.level3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크_컨트롤러 {

    public int solution(int[][] jobs) {

        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] job1, int[] job2) {
                return job1[0] - job2[0];
            }
        });

        PriorityQueue<int[]> readyQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] job1, int[] job2) {
                if (job1[1] == job2[1]) {
                    return job1[0] - job2[0];
                }
                return job1[1] - job2[1];
            }
        });

        int time = 0;
        int index = 0;
        int jobCount = jobs.length;
        int totalTurnAroundTime = 0;

        while (index < jobCount || !readyQueue.isEmpty()) {

            while (index < jobCount && time >= jobs[index][0]) {
                readyQueue.add(jobs[index]);
                index++;
            }

            if (!readyQueue.isEmpty()) {
                int[] currentJob = readyQueue.poll();
                if (currentJob[0] > time) {
                    time = currentJob[0];
                }
                time += currentJob[1];
                totalTurnAroundTime += time - currentJob[0];
                continue;
            }

            time++;

        }

        return totalTurnAroundTime / jobCount;

    }
}
