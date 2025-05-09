package leetcode.easy;

public class Maximum69Number {
  public int maximum69Number(int num) {

    String numString = String.valueOf(num);
    StringBuilder sb = new StringBuilder(numString);

    for (int i = 0; i < sb.length(); i++) {
      if (sb.charAt(i) == '6') {
        sb.setCharAt(i, '9');
        break;
      }
    }

    return Integer.parseInt(sb.toString());

  }
}
