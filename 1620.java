import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashMap<Integer, String> intMap = new HashMap<Integer, String>();
		HashMap<String, Integer> stringMap = new HashMap<String, Integer>();
		for (int i = 0; i < n; i++) {
			String pokemon = br.readLine();
			intMap.put(i + 1, pokemon);
			stringMap.put(pokemon, i + 1);
		}
		for (int i = 0; i < m; i++) {
			String line = br.readLine();
			char ch = line.charAt(0);
			if (48 <= ch && ch <= 57)
				sb.append(intMap.get(Integer.parseInt(line)));
			else
				sb.append(stringMap.get(line));
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
