import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] arrX = new int[3];
		int[] arrY = new int[3];
		for(int i=0; i<3; i++) {
			arrX[i] = input.nextInt();
			arrY[i] = input.nextInt();
		}
		String ans = "";
		if(arrX[0] == arrX[1])
			ans += arrX[2];
		else {
			if(arrX[0] == arrX[2])
				ans += arrX[1];
			else
				ans += arrX[0];
		}
		if(arrY[0] == arrY[1])
			ans += " "+arrY[2];
		else {
			if(arrY[0] == arrY[2])
				ans += " "+arrY[1];
			else
				ans += " "+arrY[0];
		}
		System.out.println(ans);
	}
}
