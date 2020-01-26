import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int month = input.nextInt();
		int day = input.nextInt();
		int sum = 0;
		if (month != 1) {
			for (int i = 1; i < month; i++) {
				if (i <= 7)
					if (i == 2)
						sum += 28;
					else if (i % 2 == 0)
						sum += 30;
					else
						sum += 31;
				else if (i % 2 == 0)
					sum += 31;
				else
					sum += 30;
			}
		}
		switch ((sum + day)%7) {
		case 1: System.out.println("MON");break;
		case 2: System.out.println("TUE");break;
		case 3: System.out.println("WED");break;
		case 4: System.out.println("THU");break;
		case 5: System.out.println("FRI");break;
		case 6: System.out.println("SAT");break;
		case 0: System.out.println("SUN");break;
		}
	}
}
