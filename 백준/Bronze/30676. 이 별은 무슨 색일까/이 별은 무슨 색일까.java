import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 파장 입력 받기
        int wavelength = scanner.nextInt();
        
        // 별의 색 판별하기
        String color = determineColor(wavelength);
        
        // 결과 출력
        System.out.println(color);
        
        scanner.close();
    }

    public static String determineColor(int wavelength) {
        if (wavelength >= 620 && wavelength <= 780) {
            return "Red";
        } else if (wavelength >= 590 && wavelength < 620) {
            return "Orange";
        } else if (wavelength >= 570 && wavelength < 590) {
            return "Yellow";
        } else if (wavelength >= 495 && wavelength < 570) {
            return "Green";
        } else if (wavelength >= 450 && wavelength < 495) {
            return "Blue";
        } else if (wavelength >= 425 && wavelength < 450) {
            return "Indigo";
        } else if (wavelength >= 380 && wavelength < 425) {
            return "Violet";
        } else {
            return "Unknown"; 
        }
    }
}