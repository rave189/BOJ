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
		double[] arr = new double[num];
		for (int i = 0; i < num; i++)
			arr[i] = Double.parseDouble(br.readLine());
		double[] result = new double[num];
		result[0] = arr[0];
		double max = 0;
		for (int i = 1; i < num; i++) {
			double tmpMax = Math.max(arr[i], arr[i] * result[i - 1]);
			if (tmpMax > max)
				max = tmpMax;
			if (tmpMax == arr[i])
				result[i] = arr[i];
			else
				result[i] = result[i - 1] * arr[i];
		}
		System.out.printf("%.3f", Math.round(max * 1000) / 1000.0);
	}
}
