import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int asize = Integer.parseInt(st.nextToken());
        int bsize = Integer.parseInt(st.nextToken());

        long[] a = new long[asize];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < asize ; i++){
            a[i] = Long.parseLong(st.nextToken());
        }

        long[] b = new long[bsize];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < bsize ; i++){
            b[i] = Long.parseLong(st.nextToken());
        }

        int aidx = 0;
        int bidx = 0;
        while(aidx < asize && bidx < bsize){
            if(a[aidx] < b[bidx]){
                sb.append(a[aidx] + " ");
                aidx++;
            }else if(a[aidx] > b[bidx]){
                sb.append(b[bidx] + " ");
                bidx++;
            }else{
                sb.append(a[aidx] + " " + b[bidx] + " ");
                aidx++;
                bidx++;
            }
        }
        if(aidx == asize){
            for(int i = bidx ; i < bsize ; i++){
                sb.append(b[i]+ " ");
            }
        }else{
            for(int i = aidx ; i < asize ; i++){
                sb.append(a[i]+ " ");
            }
        }
        System.out.println(sb);

    }
}