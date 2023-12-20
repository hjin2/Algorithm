import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] x = new int[4];
        int[] y = new int[4];

        x[0] = sc.nextInt();
        y[0] = sc.nextInt();

        for(int i = 1 ; i <= 3; i ++){
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        double result = 0;
        double min = Double.MAX_VALUE;

        for(int a = 1 ; a <= 3; a++){
            for(int b = 1 ; b <= 3 ; b++){
                if (a == b) continue;
                for(int c = 1; c <= 3; c++){
                    if (a == c || b == c) continue;
//                    System.out.printf("a : %d  b : %d  c : %d\n",a,b,c);
                    result = Math.sqrt(Math.pow(x[0] - x[a], 2) + Math.pow(y[0] - y[a], 2)) +
                            Math.sqrt(Math.pow(x[a] - x[b], 2) + Math.pow(y[a] - y[b], 2)) +
                            Math.sqrt(Math.pow(x[b] - x[c], 2) + Math.pow(y[b] - y[c], 2));
//                    System.out.println(result);
                    min = Math.min(min, result);
                }
            }
        }
        System.out.println((int)min);
    }
}