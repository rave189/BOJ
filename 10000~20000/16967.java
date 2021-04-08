import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] input = new int[4];
		for (int i = 0; i < input.length; i++)
			input[i] = Integer.parseInt(st.nextToken());
		int[][] combineMap = new int[input[0] + input[2]][input[1] + input[3]];
		for (int i = 0; i < combineMap.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < combineMap[0].length; j++)
				combineMap[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < input[0]; i++)
			for (int j = 0; j < input[1]; j++)
				try {
					combineMap[i][j] -= combineMap[i - input[2]][j - input[3]];
				} catch (Exception e) {
				}

		for (int i = 0; i < input[0]; i++) {
			for (int j = 0; j < input[1]; j++)
				System.out.print(combineMap[i][j] + " ");
			System.out.println();
		}
	}
}
