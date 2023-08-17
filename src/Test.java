import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press base number: ");
        int i = scanner.nextInt();
        System.out.println("Press power number: ");
        int j = scanner.nextInt();

        power(i, j);
    }

//        public static void power(int a, int b) {
//        int result = 1;
//        for (int i =1; i < b ; i++) {
//            result *= a;
//        }
//        System.out.println("result: " + result);
//    }

    public static void power(int a, int b) {
        double result = Math.pow(a, b);
        System.out.println("result: " + result);
    }
}
