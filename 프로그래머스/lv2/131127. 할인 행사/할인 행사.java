import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wantMap = new HashMap<>();
        int wantLength = want.length;
        for (int i = 0; i < wantLength; i++) {
            wantMap.put(want[i], number[i]);
        }

        int discountLength = discount.length;
        for (int i = 0; i <= discountLength - 10; i++) {
            Map<String, Integer> discountMap = new HashMap<>();
            for (int j = 0; j < 10; j++) {
                String item = discount[i + j];
                int count = discountMap.getOrDefault(item, 0);
                count++;
                discountMap.put(item, count);
            }

            boolean isSignup = true;
            for (String wantItem : wantMap.keySet()) {
                int wantCount = wantMap.get(wantItem);
                int discountCount = discountMap.getOrDefault(wantItem, 0);
                if (wantCount > discountCount) {
                    isSignup = false;
                    break;
                }
            }

            if (isSignup) {
                answer++;
            }
        }
        return answer;
    }
}