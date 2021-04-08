import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		for (int i = 0; i < n; i++)
			arr[i] = br.readLine();
		String[] ans = new String[arr[0].length()];
		for (int i = 0; i < arr[0].length(); i++) {
			char ch = arr[0].charAt(i);
			for (int j = 1; j < n; j++)
				if (ch != arr[j].charAt(i)) {
					ans[i] = "?";
					break;
				}
			if (ans[i] == null)
				ans[i] = String.valueOf(ch);
		}
		for (int i = 0; i < ans.length; i++)
			bw.write(ans[i]);
        bw.flush();
	}
}
