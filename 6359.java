import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		for(int i=0; i<n; i++) {
			int num = input.nextInt();
			int[] arr = new int[num+1];
			for(int j=2; j<=num; j++)
				for(int t=1; t*j<=num; t++)
					arr[t*j]++;
			int count = 0;
			for(int j=1; j<=num; j++)
				if(arr[j]%2 == 0)
					count++;
			System.out.println(count);
		}
	}
}
