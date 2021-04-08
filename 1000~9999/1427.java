import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		int[] arr = new int[s.length()];
		for (int i = 0; i < s.length(); i++)
			arr[i] = Integer.parseInt(s.substring(i, i + 1));
		for (int i = 0; i < s.length(); i++) {
			for(int j=1; j<s.length(); j++) {
				if(arr[j-1] < arr[j]) {
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for (int i = 0; i < arr.length; i++)
			bw.write(Integer.toString(arr[i]));
		bw.flush();
	}
}
