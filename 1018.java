import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int min = (int) (Math.pow(50, 2));
	static String[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		arr = new String[n][m];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++)
				arr[i][j] = line.substring(j, j + 1);
		}
		for (int i = 0; i <= n - 8; i++) {
			for (int j = 0; j <= m - 8; j++) {
				searchMin("B", i, j, i + 8, j + 8);
				searchMin("W", i, j, i + 8, j + 8);
			}
		}
		bw.write(Integer.toString(min));
		bw.flush();
	}

	public static void searchMin(String next, int rowStart, int colStart, int rowEnd, int colEnd) {
		int count = 0;
		String colNext = next;
		for (int i = rowStart; i < rowEnd; i++) {
			for (int j = colStart; j < colEnd; j++) {
				if (!next.equals(arr[i][j]))
					count++;
				if (next.equals("B"))
					next = "W";
				else
					next = "B";
			}
			if (colNext.equals("B")) {
				next = "W";
				colNext = "W";
			} else {
				next = "B";
				colNext = "B";

			}
		}
		if (count < min)
			min = count;
	}
}
