import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		for(int i=0; i<num; i++) {
			int H = input.nextInt();
			int W = input.nextInt();
			int N = input.nextInt();
			int number = 0;
			int floor = 0;
			if(N%H == 0) {
				floor = H;
				number = N/H;
			}
			else {
				floor = N%H;
				number = N/H+1;
			}
			String room;
			if(number < 10)
				room = floor+"0"+number;
			else
				room = floor+""+number;
			System.out.println(room);
		}
	}
}
