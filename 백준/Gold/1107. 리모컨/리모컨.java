import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static int min = 0x3f3f3f3f, numInt;

    static Set<String> btnSet = IntStream.range(0,10)
            .mapToObj(String::valueOf)
            .collect(Collectors.toSet());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numInt = Integer.parseInt(br.readLine());
        min = Math.min(min, Math.abs(100 - numInt));

        if("0".equals(br.readLine()) == false){
            Arrays.stream(br.readLine().split(" "))
                    .forEach(btnSet::remove);
        }

        if(btnSet.isEmpty() == false){
            find("");
        }
        System.out.println(min);
        br.close();
    }
    public static void find(String num){
        for(String btn : btnSet){
            String tmpNum = num + btn;
            min = Math.min(min, Math.abs(numInt - Integer.parseInt(tmpNum)) + tmpNum.length());
            
            if(tmpNum.length() < 6){
                find(tmpNum);
            }
        }
    }

}