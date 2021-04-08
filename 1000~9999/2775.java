import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		for(int i=0; i<num; i++) {
			int k = input.nextInt();
			int n = input.nextInt();
			int[][] arr = new int[k+1][n];
			for(int j=0; j<n;j++)
				arr[0][j] = j+1;
			for(int j=1; j<k+1;j++) {
				for(int t=0; t<n; t++) {
					if(t > 0)
						arr[j][t] = arr[j-1][t] + arr[j][t-1];
					else
						arr[j][t] = 1;
				}
			}
			System.out.println(arr[k][n-1]);
		}
	}
}
