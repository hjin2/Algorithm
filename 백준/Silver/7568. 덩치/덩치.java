import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Person{
    int w;
    int h;
    public Person(int w, int h){
        this.w = w;
        this.h = h;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());


        Person[] persons = new Person[n];
        int[] result = new int[n];

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            persons[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                if(persons[i].w > persons[j].w && persons[i].h > persons[j].h){
                    result[j]++;
                }else if(persons[i].w < persons[j].w && persons[i].h < persons[j].h){
                    result[i]++;
                }
            }
        }


        for(int i = 0 ; i < n ; i++){
            System.out.print((result[i] + 1) + " ");
        }
    }
}