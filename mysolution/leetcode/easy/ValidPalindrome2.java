package leetcode.easy;

public class ValidPalindrome2 {

    boolean validPalindrome(String s) {

        int head = 0;
        int tail = s.length() - 1;

        while (head < tail) {
            if (s.charAt(head) != s.charAt(tail)) {
                return checkPalindrome(s, head + 1, tail) || checkPalindrome(s, head, tail - 1);
            }
            head++;
            tail--;
        }

        return true;

    }

    private boolean checkPalindrome(
        String s,
        int head,
        int tail
    ) {

        while (head < tail) {
            if (s.charAt(head) != s.charAt(tail)) {
                return false;
            }
            head++;
            tail--;
        }

        return true;

    }
}
