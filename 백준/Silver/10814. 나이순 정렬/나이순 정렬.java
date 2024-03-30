import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Person implements Comparable<Person>{
    String name;
    int age;
    int num;
    public Person(int age, String name, int num){
        this.age = age;
        this.name = name;
        this.num = num;
    }
    @Override
    public int compareTo(Person p){
        if(this.age == p.age){
            return this.num - p.num;
        }
        return this.age - p.age;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        List<Person> personList = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            personList.add(new Person(Integer.parseInt(st.nextToken()), st.nextToken(), i));
        }


        Collections.sort(personList);

        for(int i = 0 ; i < n ; i++){
            System.out.println(personList.get(i).age + " " + personList.get(i).name);
        }



    }
}