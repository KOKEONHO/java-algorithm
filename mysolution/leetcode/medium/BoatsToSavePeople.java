package leetcode.medium;

import java.util.Arrays;

public class BoatsToSavePeople {
  public int numRescueBoats(int[] people, int limit) {

    int head = 0;
    int tail = people.length - 1;
    int boatCnt = 0;

    Arrays.sort(people);

    while (head <= tail) {
      boatCnt++;
      if (people[head] + people[tail] <= limit) {
        head++;
      }
      tail--;
    }

    return boatCnt;

  }
}
