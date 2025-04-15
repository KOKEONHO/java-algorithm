package baekjoon.gold.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 과제 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Homework> deadlineMinHeap = new PriorityQueue<>(Comparator.comparingInt(homework -> homework.deadline));
        PriorityQueue<Homework> scoreMinHeap = new PriorityQueue<>(Comparator.comparingInt(homework -> homework.score));

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            Homework homework = new Homework(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            deadlineMinHeap.add(homework);
        }

        while (!deadlineMinHeap.isEmpty()) {
            Homework polled = deadlineMinHeap.poll();

            scoreMinHeap.add(polled);

            if (scoreMinHeap.size() > polled.deadline) {
                scoreMinHeap.poll();
            }
        }

        int result = 0;

        while (!scoreMinHeap.isEmpty()) {
            result += scoreMinHeap.poll().score;
        }

        System.out.println(result);

    }

    private static class Homework {

        int deadline;
        int score;

        public Homework(int deadline, int score) {
            this.deadline = deadline;
            this.score = score;
        }
    }
}
