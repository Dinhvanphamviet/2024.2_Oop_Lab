import java.util.Scanner;

public class AddTwoMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap so hang cua ma tran: ");
        int hang = scanner.nextInt();

        System.out.print("Nhap so cot cua ma tran: ");
        int cot = scanner.nextInt();

        double[][] matA = new double[hang][cot]; 
        double[][] matB = new double[hang][cot];
        double[][] matC = new double[hang][cot]; 

        System.out.println("\n Cac phan tu trong ma tran A: ");
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < cot; j++) {
                matA[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("\n Cac phan tu trong ma tran B: ");
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < cot; j++) {
                matB[i][j] = scanner.nextDouble();
            }
        }

        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < cot; j++) {
                matC[i][j] = matA[i][j] + matB[i][j];
            }
        }

        System.out.println("\nmatA + matB bang: ");
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < cot; j++) {
                System.out.print(matC[i][j] + " ");
            }
            System.out.println(); 
        }
        scanner.close();
    }
}