import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Long> asum = new ArrayList<>();
        List<Long> bsum = new ArrayList<>();

        int target = Integer.parseInt(br.readLine());

        int aLen = Integer.parseInt(br.readLine());
        int[] a = new int[aLen+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= aLen ; i++){
            int tmp = Integer.parseInt(st.nextToken());
            a[i] = a[i-1] + tmp;
        }

        int bLen = Integer.parseInt(br.readLine());
        int[] b = new int[bLen+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= bLen ; i++){
            int tmp = Integer.parseInt(st.nextToken());
            b[i] = b[i-1] + tmp;
        }


        for(int i = 1 ; i <= aLen ; i++){
            for(int j = 0 ; j < i ; j++){
                asum.add((long)a[i] - a[j]);
//                System.out.printf("i : %d    j : %d     a[%d]- a[%d] = %d \n", i, j, i, j, a[i] - a[j]);
            }
        }
//        for(int i = 0 ; i < asum.size() ; i++){
//            System.out.print(asum.get(i) + "   ");
//        }


        for(int i = 1 ; i <= bLen ; i++){
            for(int j = 0 ; j < i ; j++){
                bsum.add((long)b[i] - b[j]);
            }
        }
//        System.out.println("하..");
//        for(int i = 0 ; i < bsum.size() ; i++){
//            System.out.print(bsum.get(i) + "   ");
//        }
//        System.out.println();
//        int cnt = 0;
//        for(int i = 0 ; i < asum.size() ; i++){
//            for(int j = 0 ; j < bsum.size() ; j++){
//                if(asum.get(i) + bsum.get(j) == target){
//                    System.out.println(asum.get(i) + "    +     " + bsum.get(j));
//                    cnt++;
//                }
//            }
//        }

        Collections.sort(asum);
        Collections.sort(bsum);

        //이중배열 투포인터
        int aSize = asum.size();
        int bSize = bsum.size();

        //왼쪽은 왼쪽부터, 오른쪽은 오른쪽부터 배열을 진행한다.
        long cnt = 0;
        int leftPointer = 0;
        int rightPointer = bsum.size() - 1;

        //정렬을 했기 때문에, 왼쪽 + 오른쪽 합이 크면 오른쪽에서 <- , 작으면 왼쪽에서 -> 으로 가서 크기를 비교한다.
        while (leftPointer < aSize && rightPointer >= 0) {
            long sum = asum.get(leftPointer) + bsum.get(rightPointer);

            //같을시에 정렬을 했기 때문에 같은 수는 일렬로 쭈르륵 있을것이다.
            //그럼 연속된 같은 수는 묶어서 A배열의 개수 * B 배열의 개수 를 더해 counting 해준다.
            //ex A[1,1,1,2,3,4], B[1,3,3,4] 일 경우, 합 4를 찾으면
            //ACnt = 연속된 1이 3개 = 3, BCnt = 연속된 3이 2개 = 2
            //Cnt += 3*2 (6가지 경우가 나오므로)
            if (sum == target) {

                long a1 = asum.get(leftPointer);
                long b1 = bsum.get(rightPointer);
                long leftCnt = 0;
                long rightCnt = 0;

                while(leftPointer < aSize && asum.get(leftPointer) == a1){
                    leftCnt++;
                    leftPointer++;
                }
                while(rightPointer >= 0 && bsum.get(rightPointer) == b1){
                    rightCnt++;
                    rightPointer--;
                }
                cnt += leftCnt * rightCnt;
                //작으면 -> 가서 크기를 키운다
            } else if (sum < target) {
                leftPointer++;
                //크면 <- 가서 크기를 줄인다.
            } else if (sum > target) {
                rightPointer--;
            }
        }


        System.out.println(cnt);



    }
}