import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book); // 전화번호를 정렬

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                // 다음 번호가 현재 번호의 접두사인 경우
                return false;
            }
        }

        return true; // 모든 번호가 서로의 접두사가 아닌 경우
    }
}