import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = br.readLine();
		String[] arr = new String[5000];
		int count = 0;
		for (int i = 0; i < line.length(); i++)
			if (line.charAt(i) == ' ' || line.charAt(i) == '-') {
				arr[count++] = line.substring(0, i);
				line = line.substring(i + 1, line.length());
				i = 0;
			}
		arr[count++] = line;
		int ans = 0;
		for (int i = 0; i < count; i++) {
			String word = arr[i];
			for (int j = 0; j < word.length(); j++)
				if (word.charAt(j) == '\'')
					if (vowelCheck(word.charAt(j + 1)))
						if (wordCheck(word.substring(0, j)))
							ans++;
			ans++;
		}
		bw.write(Integer.toString(ans));
		bw.flush();
	}

	public static boolean vowelCheck(char ch) {
		char[] vowel = { 'a', 'e', 'i', 'o', 'u', 'h' };
		for (int i = 0; i < vowel.length; i++)
			if (vowel[i] == ch)
				return true;
		return false;
	}

	public static boolean wordCheck(String front) {
		String[] compare = { "c", "j", "n", "m", "t", "s", "l", "d", "qu" };
		for (int i = 0; i < compare.length; i++)
			if (compare[i].equals(front))
				return true;
		return false;
	}
}
