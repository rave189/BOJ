import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] line = br.readLine().split(" ");
		int h = Integer.parseInt(line[0]);
		int y = Integer.parseInt(line[1]);
		int[] year = { 1, 3, 5 };
		double[] interest = { 1.05, 1.2, 1.35 };
		int[] arr = new int[y + 1];
		arr[0] = h;
		for (int i = 0; i <= y; i++)
			for (int j = 0; j < 3; j++)
				if (i + year[j] <= y) {
					int num = (int) (arr[i] * interest[j]);
					if (num >= arr[i + year[j]])
						arr[i + year[j]] = num;
				}
		bw.write(Integer.toString(arr[y]));
		bw.flush();
	}
}
