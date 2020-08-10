import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		Queen(arr, 0, n);
		bw.write(Integer.toString(count));
		bw.flush();
	}

	public static void Queen(int[][] arr, int x, int queen) {
		if (queen == 0)
			count++;
		else {
			for (int i = 0; i < arr.length; i++) {
				arr[x][i] = 1;
				if (Check(arr, x, i))
					Queen(arr, x + 1, queen - 1);
				arr[x][i] = 0;
			}
		}
	}

	public static boolean Check(int[][] arr, int x, int y) {
		for (int i = 0; i < arr.length; i++)
			if (i != x && arr[i][y] == 1)
				return false;
		for (int i = 0; i < arr[0].length; i++)
			if (i != y && arr[x][i] == 1)
				return false;
		if (x >= y) {
			for (int i = x - y, j = 0; i < arr.length; i++, j++)
				if (i != x && j != y && arr[i][j] == 1)
					return false;
		}
		int tmpX = x;
		int tmpY = y;
		while (--tmpX >= 0 && --tmpY >= 0)
			if (arr[tmpX][tmpY] == 1)
				return false;
		tmpX = x;
		tmpY = y;
		while (--tmpX >= 0 && ++tmpY < arr.length)
			if (arr[tmpX][tmpY] == 1)
				return false;
		tmpX = x;
		tmpY = y;
		while (++tmpX < arr.length && --tmpY >= 0)
			if (arr[tmpX][tmpY] == 1)
				return false;
		tmpX = x;
		tmpY = y;
		while (++tmpX < arr.length && ++tmpY < arr.length)
			if (arr[tmpX][tmpY] == 1)
				return false;
		return true;
	}
}
