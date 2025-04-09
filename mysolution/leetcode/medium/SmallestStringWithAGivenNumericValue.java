package leetcode.medium;

public class SmallestStringWithAGivenNumericValue {

    public String getSmallestString(int n, int k) {

        Map<Integer, Character> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 'a'; i <= 'z'; i++) {
            map.put(i - (int) 'a' + 1, (char) i);
        }

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sb.append("a");
            sum++;
        }

        while (sum < k) {
            n--;
            sb.setCharAt(n, 'z');
            sum += 25;
        }

        if (sum > k) {
            sb.setCharAt(n, map.get(26 - (sum - k)));
        }

        return sb.toString();

    }
}
