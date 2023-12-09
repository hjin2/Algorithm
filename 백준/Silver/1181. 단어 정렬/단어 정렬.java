import java.util.*;
import java.io.*;
public class Main
{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Integer,List<String>> map = new HashMap<Integer,List<String>>();
        for(int i = 0 ; i < n; i++){
            String word = br.readLine();
            int wordLength = word.length();
            List<String> tmp = map.get(wordLength);
            if(tmp != null){ // NullPointerException
                tmp.add(word);
            }else{
                tmp = new ArrayList<>();
                tmp.add(word);
            }
            map.put(wordLength,tmp);
        }

        // key값 내에서 알파벳 순으로 정렬

        // 크기가 작은 순부터 하나씩 출력
        for(int i = 0 ; i < 20000; i++){
            if(map.get(i)==null){
                continue;
            }
            List<String> result = map.get(i);
            Collections.sort(result);
            Set<String> sortedSet = new TreeSet<>(result);
            for (String word : sortedSet) {
                System.out.println(word);
            }
        }
    }
}