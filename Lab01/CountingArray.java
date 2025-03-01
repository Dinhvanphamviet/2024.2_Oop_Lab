import java.util.Scanner;
import java.util.Arrays; 

public class CountingArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        while (true) {
            System.out.print("\n So phan tu cua mang la: ");
            n = scanner.nextInt();

            if (n <= 0) {
                System.out.print("So phan tu cua mang khong hop le");
            }else{
                break;
            }
        }
        
        double[] arr = new double[n]; 

        for (int i = 0; i < n; i++) {
            System.out.print("Gia tri arr[" + i + "]: ");
            arr[i] = scanner.nextDouble();
        }

        Arrays.sort(arr);

        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        double avg = sum / n;

        System.out.println("Mang sau khi sap xep la: ");
        for (double i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("\n Tong cac phan tu trong mang la " + sum);
        System.out.print("Trung binh cong cac phan tu trong mang la: " + avg);
        scanner.close();
    }
}