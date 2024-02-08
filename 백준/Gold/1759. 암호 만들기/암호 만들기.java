import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static StringBuilder sb;
    static String[] alphas;

    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        alphas = new String[C];
        for (int i = 0; i < C; i++) {
            alphas[i] = st.nextToken();
        }

        Arrays.sort(alphas);

        recur("", 0, 0, 0);
        System.out.println(sb);
    }

    public static void recur(String str, int m, int z, int rec) {
        if(rec == C){

            if(str.length() == L){
                if(m >= 1 && z >= 2){
                    sb.append(str);
                    sb.append("\n");
                }
            }
            return;
        }


        // 모음 선택
        if (alphas[rec].equals("a") || alphas[rec].equals("e") || alphas[rec].equals("i") || alphas[rec].equals("o") || alphas[rec].equals("u")) {
            recur(str + alphas[rec], m + 1, z, rec + 1);
        }
        // 자음 선택
        else {
            recur(str + alphas[rec], m, z + 1, rec + 1);
        }
        // 선택안하고 다음 알파벳
        recur(str, m, z, rec + 1);


    }
}