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
		String[] arr = new String[num];
		for (int i = 0; i < num; i++)
			arr[i] = br.readLine();
		for (int i = 0; i < num; i++) {
			int index = i;
			for (int j = i + 1; j < num; j++) {
				if (arr[index].length() > arr[j].length())
					index = j;
				else if (arr[index].length() == arr[j].length())
					for (int t = 0; t < arr[index].length(); t++)
						if (arr[index].charAt(t) > arr[j].charAt(t)) {
							index = j;
							break;
						} else if (arr[index].charAt(t) < arr[j].charAt(t))
							break;
						else if (t == arr[index].length() - 1)
							arr[j] = "N";
			}
			if (i != index) {
				String tmp = arr[index];
				arr[index] = arr[i];
				arr[i] = tmp;
			}
		}
		for (int i = 0; i < num; i++)
			if (!arr[i].equals("N"))
				bw.write(arr[i] + "\n");
		bw.flush();
	}
}
