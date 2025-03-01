import java.util.Scanner;

class GiaiPhuongTrinhBacNhat {
    public static void giaiPTBacNhat() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("He so a la: ");
        double a = scanner.nextDouble();
        System.out.print("He so b la: ");
        double b = scanner.nextDouble();
        if (a == 0) {
            if (b == 0) {
                System.out.println("Phuong trinh vo so nghiem");
            } else {
                System.out.println("Phuong trinh vo nghiem.");
            }
        } else {
            double x = -b / a;
            System.out.println("Phuong trinh co nghiem x = " + x);
        }
        scanner.close();
    }
}

class GiaiHePhuongTrinhBacNhatHaiAn{
    public static void giaiHePT() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("He so a1 la: ");
        double a1 = scanner.nextDouble();
        System.out.print("He so b1 la: ");
        double b1 = scanner.nextDouble();
        System.out.print("He so c1 la: ");
        double c1 = scanner.nextDouble();
        System.out.print("He so a2 la: ");
        double a2 = scanner.nextDouble();
        System.out.print("He so b2 la: ");
        double b2 = scanner.nextDouble();
        System.out.print("He so c2 la: ");
        double c2 = scanner.nextDouble();

        double D = a1 * b2 - b1 * a2;
        double Dx = c1 * b2 - b1 * c2;
        double Dy = a1 * c2 - c1 * a2;

        if (D != 0) {
            double x = Dx / D;
            double y = Dy / D;
            System.out.println("He phuong trinh co nghiem duy nhat:");
            System.out.println("x = " + x);
            System.out.println("y = " + y);
        } else {
            if (Dx == 0 && Dy == 0) {
                System.out.println("He phuong trinh co vo so nghiem");
            } else {
                System.out.println("He phuong trinh vo nghiem.");
            }
        }
        scanner.close();
    }
}

class GiaiPhuongTrinhBacHai{
    public static void giaiPTBacHai() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("He so d la: ");
        double d = scanner.nextDouble();
        System.out.print("He so e la: ");
        double e = scanner.nextDouble();
        System.out.print("He so f la: ");
        double f = scanner.nextDouble();

        double Delta = e*e-4*d*f;

        if(Delta<0){
            System.out.println("Phuong trinh vo nghiem");
        } 
        else if (Delta==0){
            System.out.println("Phuong trinh co nghiem duy nhat x="+(-e/(2*d)));
        }
        else{
            double x1 = (-e + Math.sqrt(Delta)) / (2 * d);
            double x2 = (-e - Math.sqrt(Delta)) / (2 * d);
            System.out.println("Phương trình có hai nghiệm phân biệt:");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        }
        scanner.close();
        }
    }

public class GiaiPhuongTrinh{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            
        System.out.println("Hay chon loai phuong trinh can giai");
        System.out.println("1 - Phuong trinh bac nhat mot an");
        System.out.println("2 - He phuong trinh bac nhat hai an ");
        System.out.println("3 - Phuong trinh bac hai mot an ");           
            
        int choice = scanner.nextInt();
        
        switch (choice) {
        case 1:
            GiaiPhuongTrinhBacNhat.giaiPTBacNhat(); 
            break;
        case 2:
                GiaiHePhuongTrinhBacNhatHaiAn.giaiHePT(); 
                break;
        case 3:
            GiaiPhuongTrinhBacHai.giaiPTBacHai(); 
            break;
        default:
            System.out.println("Lua chon sai roi nha.");
        }
        scanner.close();
    }
}

