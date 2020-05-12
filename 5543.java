import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		int[] burger = new int[3];
		int[] beverage = new int[2];
		int min = 100000;
		for(int i=0; i<3; i++)
			burger[i] = input.nextInt();
		for(int i=0; i<2; i++)
			beverage[i] = input.nextInt();
		for(int i=0; i<3; i++)
			for(int j=0; j<2; j++)
				if(min > burger[i] + beverage[j])
					min = burger[i] + beverage[j];
		System.out.println(min-50);
	}
}
