import javax.swing.JOptionPane;

public class TwoNumber {
    public static void main(String[] args) {
        String strNum1, strNum2;
        String strNotification = "Ket qua:\n " ;

        strNum1 = JOptionPane.showInputDialog(null,
                "Nhap so thu nhat: ", "Input the first number",
                JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);


        strNum2 = JOptionPane.showInputDialog(null,
                "Nhap so thu hai: ", "Input the second number",
                JOptionPane.INFORMATION_MESSAGE);
        double num2 = Double.parseDouble(strNum2);

        strNotification += "Tong=" +(num1+num2)+ "\n";
        strNotification += "Hieu=" +(num1-num2)+ "\n";
        strNotification += "Tich=" +(num1*num2)+ "\n";

        if(num2==0){
                JOptionPane.showMessageDialog(null, "khong the chia",
                "Canh bao", JOptionPane.INFORMATION_MESSAGE);
        } else{
                strNotification += "Thuong=" +(num1/num2);
        }
        JOptionPane.showMessageDialog(null, strNotification,
                "Show two numbers", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}

