import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sudoku(0, 0);
    }

    public static void sudoku(int x, int y) {
        if (y == 9) {
            sudoku(x + 1, 0);
            return;
        }
        if (x == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(arr[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.println(sb);
            System.exit(0);
        }

        if (arr[x][y] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (possible(x, y, i)) {
                    arr[x][y] = i;
                    sudoku(x, y + 1);
                }
            }
            arr[x][y] = 0;
            return;
        }
        sudoku(x, y + 1);
    }

    public static boolean possible(int x, int y, int num) {
        // 가로 확인
        for (int j = 0; j < 9; j++) {
            if (arr[x][j] == num) {
                return false;
            }
        }

        // 세로 확인
        for (int i = 0; i < 9; i++) {
            if (arr[i][y] == num) {
                return false;
            }
        }

        int i = (x / 3) * 3;
        int j = (y / 3) * 3;
        for (int k = i; k < i + 3; k++) {
            for (int h = j; h < j + 3; h++) {
                if (arr[k][h] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
