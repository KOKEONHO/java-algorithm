# Java Algorithm

## 📝 풀이 목록

### LeetCode

#### easy

##### 1. Two Sum
`HashMap`: 내부적으로 해시 테이블로 구현되어 있음  
이 경우 조회는 평균적으로 O(1) 가능  
최악의 경우에는 O(n)이 될 수 있지만, 그럴 가능성 희박

##### 125. Valid Palindrome
`Character.isLetterOrDigit()`: 특정 문자가 영숫자인지 판별  

`StringBuilder`: 스레드 안전(Thread Safe)하지 않음  
`reverse()` 메서드 존재 → 문자열 뒤집기에 사용