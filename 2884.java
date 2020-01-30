import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int hour = s.nextInt();
		int minute = s.nextInt();
		minute-=45;
		if(minute < 0)
		{
			minute += 60;
			hour -= 1;
			if(hour < 0)
				hour += 24;
		}
		System.out.println(hour+" "+minute);
	}
}
