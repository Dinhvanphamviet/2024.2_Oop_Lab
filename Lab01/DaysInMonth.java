import java.util.Scanner;

public class DaysInMonth{

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String month;
		int year;
		int monthNumber;
		while(true) {
		System.out.print("Nhap thang: ");
		month = scanner.next();
		System.out.print("Nhap nam: ");
		year = scanner.nextInt();
		monthNumber = getMonthNumber(month);
		if(year>=1000 && monthNumber!=-1) {
			break;
		}else{
			System.out.println("Cu phap ko hop le, vui long nhap lai");
			}
		
		}
		int day = getDaysInMonth(monthNumber, year);
			System.out.print("So ngay trong thang "+ month + ", nam " + year+ " la " + day);
		scanner.close();
        }

	public static int getMonthNumber(String month) {
        String[][] monthNames = {
            {"January", "Jan.", "Jan", "1"},
            {"February", "Feb.", "Feb", "2"},
            {"March", "Mar.", "Mar", "3"},
            {"April", "Apr.", "Apr", "4"},
            {"May", "May", "May", "5"},
            {"June", "June", "Jun", "6"},
            {"July", "July", "Jul", "7"},
            {"August", "Aug.", "Aug", "8"},
            {"September", "Sept.", "Sep", "9"},
            {"October", "Oct.", "Oct", "10"},
            {"November", "Nov.", "Nov", "11"},
            {"December", "Dec.", "Dec", "12"}
        };
        
        for (int i = 0; i < monthNames.length; i++) {
            for (int k =0; k<=3; k++) {
                if (month.equalsIgnoreCase(monthNames[i][k])) {
                    return i + 1;
                }
            }
        }
        return -1;
    }
    public static int getDaysInMonth(int month, int year) {
        int[] daysInCommonYear = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] daysInLeapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        return isLeapYear ? daysInLeapYear[month - 1] : daysInCommonYear[month - 1];
    }
}
	
	

 