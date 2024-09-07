import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] a = new int[Integer.parseInt(st.nextToken())];
        int[] b = new int[Integer.parseInt(st.nextToken())];
        int[] c = new int[Integer.parseInt(st.nextToken())];

        st = new StringTokenizer(br.readLine());
        for(int i = 0  ; i < a.length ; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0  ; i < b.length ; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0  ; i < c.length ; i++){
            c[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        int aidx = 0;
        int bidx = 0;
        int cidx = 0;

        int result = Integer.MAX_VALUE;
        while(aidx < a.length && bidx < b.length && cidx < c.length){
            int tmp = Math.max(a[aidx], b[bidx]);
            int max = Math.max(tmp, c[cidx]);

            tmp = Math.min(a[aidx], b[bidx]);
            int min = Math.min(tmp, c[cidx]);

            result = result > Math.abs(max - min) ? Math.abs(max - min) : result;
            if(result == 0){
                break;
            }

            if(min == a[aidx]){
                aidx++;
            }else if(min == b[bidx]){
                bidx++;
            }else{
                cidx++;
            }
        }

        System.out.println(result);

    }
}