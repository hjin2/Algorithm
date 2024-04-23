import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 중복 제거하기
        Set<String> set = new HashSet<>();
        List<String> words = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            String word = br.readLine();
            if(set.contains(word)){
                continue;
            }
            set.add(word);
            words.add(word);
        }

        // list에는 이제 중복없는 단어들이 저장되어 있을것이다.
        int[] results = new int[words.size()]; // 내가 접두사가 될 수 있는 단어의 개수 : results[i] = 3이면 내 단어를 포함한 단어가 3개라는 뜻
        for(int i = 0 ; i < words.size() ; i++){ // n으로 하면안되고 n개 중에서 중복된거 제거했을 수도 있으니까 words리스트의 크기로 범위 설정해야함. 그거 안해서 오류남
            for(int j = 0 ; j < words.size() ; j++){
                // 나랑 똑같은 단어이면 pass
                if(i == j) {
                    continue;
                }
                // 1. 만약에 단어의 길이가 나보다 작다면 패스하기
                if(words.get(j).length() < words.get(i).length()){ //            < 기준 단어
                    continue;
                }else{ // 같거나 큰 경우
                    boolean same = true;
                    for(int k = 0 ; k < words.get(i).length() ; k++){
                        if(words.get(i).charAt(k) != words.get(j).charAt(k)){
                            same = false;
                        }
                    }
                    if(same){
                        results[i]++;
                    }
                }
            }
        }

        int answer = 0;
        for(int i = 0 ; i < words.size() ; i++){
            if(results[i] == 0){
                answer++;
            }
        }
        System.out.println(answer);
    }

}