import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static int blueCount = 0;
	static int whiteCount = 0;

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
		bw.write(whiteCount + "\n" + blueCount);
		bw.flush();
	}

	public static void DnC(int sRow, int sCol, int eRow, int eCol) {
		if (sRow == eRow && sCol == eCol)
			return;
		if (Check(sRow, sCol, eRow, eCol, 1)) {
			blueCount++;
		} else if (Check(sRow, sCol, eRow, eCol, 0)) {
			whiteCount++;
		} else {
			int midRow = (sRow + eRow) / 2;
			int midCol = (sCol + eCol) / 2;
			DnC(sRow, sCol, midRow, midCol);
			DnC(sRow, midCol, midRow, eCol);
			DnC(midRow, sCol, eRow, midCol);
			DnC(midRow, midCol, eRow, eCol);
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
