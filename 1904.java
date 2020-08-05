import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	final static int devide = 15746;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		int[] arr = new int[num];
		arr[0] = 1;
		if (num >= 2)
			arr[1] = 2;
		for (int i = 2; i < num; i++)
			arr[i] = ((arr[i - 1] % devide) + (arr[i - 2] % devide)) % devide;
		bw.write(Integer.toString(arr[num - 1]));
		bw.flush();
	}
}
