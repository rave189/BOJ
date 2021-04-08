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
		int[] arr = new int[++num];
		arr[1] = 1;
		for (int i = 1; i < num; i++) {
			for (int j = 1; j * j <= i; j++) {
				int index = i - j * j;
				if (arr[i] == 0 || arr[index] + 1 < arr[i])
					arr[i] = arr[index] + 1;
			}
		}
		System.out.println(arr[num - 1]);
	}
}
