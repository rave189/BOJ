import java.util.Scanner;

public class Main {

	public static boolean done = false;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[][] arr = new int[9][9];
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				arr[i][j] = input.nextInt();
		Sdoku(arr, 0, 0);
	}

	public static void Sdoku(int[][] arr, int x, int y) {
		if (x != 9) {
			if (arr[x][y] == 0) {
				for (int i = 0; i < 9; i++) {
					arr[x][y] = i + 1;
					if (Check(arr, x, y, i + 1)) {
						if (y + 1 >= 9)
							Sdoku(arr, x + 1, 0);
						else
							Sdoku(arr, x, y + 1);
					}
					arr[x][y] = 0;
				}
			} else if (y + 1 >= 9)
				Sdoku(arr, x + 1, 0);
			else
				Sdoku(arr, x, y + 1);
		} else if (FinalCheck(arr) && !done) {
			Print(arr);
			done = true;
		}
	}

	public static boolean Check(int[][] arr, int x, int y, int num) {
		for (int i = 0; i < 9; i++)
			if (i != y && arr[x][i] == num)
				return false;
		for (int i = 0; i < 9; i++)
			if (i != x && arr[i][y] == num)
				return false;
		int tmpX = 3 * (x / 3);
		int tmpY = 3 * (y / 3);
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (i + tmpX != x && j + tmpY != y && arr[tmpX + i][tmpY + j] == num)
					return false;
		return true;
	}

	public static boolean FinalCheck(int[][] arr) {
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				if (!Check(arr, i, j, arr[i][j]))
					return false;
		return true;
	}

	public static void Print(int[][] arr) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}
}
