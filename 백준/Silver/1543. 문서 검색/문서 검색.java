
import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws IOException{
	    Scanner sc = new Scanner(System.in);

	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String words = br.readLine();
	    String word = br.readLine();
	    
	    int result = 0;
	    int wordLength = word.length();
	    for(int i = 0 ; i <= words.length()-wordLength ; i++){
	        if(words.substring(i,i+wordLength).equals(word)){
	            result += 1;
	            i += (wordLength-1);
	        }
	    }
	    System.out.println(result);
	}
}
