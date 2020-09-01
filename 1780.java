import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static int minus = 0;
	static int zero = 0;
	static int one = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		DnC(0, 0, n, n);
		bw.write(minus + "\n" + zero + "\n" + one);
		bw.flush();
	}

	public static void DnC(int sRow, int sCol, int eRow, int eCol) {
		if (sRow == eRow && sCol == eCol)
			return;
		if (Check(sRow, sCol, eRow, eCol, 1)) {
			one++;
		} else if (Check(sRow, sCol, eRow, eCol, 0)) {
			zero++;
		} else if (Check(sRow, sCol, eRow, eCol, -1)) {
			minus++;
		} else {
			int divRow = (eRow - sRow) / 3;
			int divCol = (eCol - sCol) / 3;
			for (int i = sRow; i < eRow; i += divRow)
				for (int j = sCol; j < eCol; j += divCol)
					DnC(i, j, i + divRow, j + divCol);
		}
	}

	public static boolean Check(int sRow, int sCol, int eRow, int eCol, int check) {
		for (int i = sRow; i < eRow; i++)
			for (int j = sCol; j < eCol; j++)
				if (arr[i][j] != check)
					return false;
		return true;
	}
}
