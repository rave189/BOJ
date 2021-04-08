import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		for(int i=0; i<num; i++) {
			int n = input.nextInt();
			int[][] arr = new int[2][n];
			for(int j=0; j<2;j++)
				for(int t=0; t<n; t++)
					arr[j][t] = input.nextInt();
			int[][] destiArr = new int[3][n];
			destiArr[1][0] = arr[0][0];
			destiArr[2][0] = arr[1][0];
			for(int j=1; j<n;j++) {
				destiArr[0][j] = Math.max(destiArr[0][j-1], Math.max(destiArr[1][j-1], destiArr[2][j-1]));
				destiArr[1][j] = Math.max(destiArr[0][j-1], destiArr[2][j-1]) + arr[0][j];
				destiArr[2][j] = Math.max(destiArr[0][j-1], destiArr[1][j-1]) + arr[1][j];
			}
			System.out.println(Math.max(Math.max(destiArr[0][n-1], destiArr[1][n-1]), destiArr[2][n-1]));
		}
	}
}
