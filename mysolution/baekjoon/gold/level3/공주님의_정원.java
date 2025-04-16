package baekjoon.gold.level3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 공주님의_정원 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Flower> flowers = new PriorityQueue<>(Comparator.comparingInt(flower -> flower.start));

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            Flower flower = new Flower(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
            );

            flowers.add(flower);
        }

        int count = 0;
        int maxEnd = 0;
        int currentDay = 60;    // 3.1

        while (currentDay < 335) {

            int tempMaxEnd = maxEnd;

            while (!flowers.isEmpty() && flowers.peek().start <= currentDay) {
                tempMaxEnd = Math.max(tempMaxEnd, flowers.poll().end);
            }

            if (tempMaxEnd == maxEnd) {
                System.out.println(0);
                return;
            }

            count++;
            maxEnd = tempMaxEnd;
            currentDay = maxEnd;
        }

        System.out.println(count);

    }

    private static class Flower {

        int start;
        int end;

        public Flower(
            int startMonth,
            int startDay,
            int endMonth,
            int endDay
        ) {
            this.start = convertDate(startMonth, startDay);
            this.end = convertDate(endMonth, endDay);
        }

        private int convertDate(
            int month,
            int day
        ) {
            int convertedDate = 0;

            for (int i = 1; i < month; i++) {
                switch (i) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        convertedDate += 31;
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        convertedDate += 30;
                        break;
                    case 2:
                        convertedDate += 28;
                        break;
                }
            }

            return convertedDate += day;
        }
    }
}
