import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		int[] arr = new int[num];
		int[] sumArr = new int[10001];
		for (int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sumArr[arr[i]]++;
		}
		for (int i = 0; i < sumArr.length; i++) {
			if (sumArr[i] != 0) {
				for (int j = 0; j < sumArr[i]; j++)
					bw.write(i + "\n");
			}
		}
		bw.flush();
	}
}
