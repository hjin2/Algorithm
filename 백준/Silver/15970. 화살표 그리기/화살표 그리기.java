import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[100001];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[idx] = c;
        }


        int result = 0;
        for (int i = 0; i < 100001; i++) {
            if (arr[i] != 0) {
                // 나보다 왼쪽으로 가기
                int lefttmp = -1;
                int righttmp = -1;
//                if (i != 0) {
                    for (int left = i - 1; left >= 0; left--) {
                        if (arr[left] == arr[i]) {
                            lefttmp = i - left;
                            break;
                        }
                    }
//                }

                // 나보다 오른쪽으로 가기
//                if (i != n - 1) {
                    for (int right = i + 1; right < 100001 ; right++) {
                        if (arr[right] == arr[i]) {
                            righttmp = right - i;
                            break;
                        }
//                    }
                }

                int choice = righttmp < lefttmp ? righttmp : lefttmp;

                if(lefttmp < 0 ){ // 음수라는 것은 해당 방향에 같은 색의 점이 없다는 뜻
                    choice = righttmp;
                }
                if(righttmp < 0){
                    choice = lefttmp;
                }


                result += choice;
                //System.out.println("i : " + i + " lefttmp : " + lefttmp + " righttmp : " + righttmp + " choice : " + choice + " result : " + result);
            }
        }
        System.out.println(result);
    }
}