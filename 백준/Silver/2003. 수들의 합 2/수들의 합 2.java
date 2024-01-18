import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int result = 0;
        int[] nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n ; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = 0;
        int sum = nums[s];
        while(s < n) {
            if( sum < target ) {
                e++;
                if( e < n ) {
                    sum += nums[e];
                }else{
                    break;
                }
            }else if (sum > target){
                sum = sum - nums[s];
                s++;
            }else{
                result += 1;
                sum = sum - nums[s];
                s++;
                e++;
                if( e < n)
                    sum += nums[e];
                else
                    break;
            }
        }
        System.out.println(result);
    }
}
