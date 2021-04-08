import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		Stack<String> st = new Stack<String>();
		int pCnt = 0;
		for (int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);
			if (ch == 'P') {
				pCnt++;
				st.add(ch + "");
				continue;
			}
			try {
				char next = line.charAt(i + 1);
				if (next == 'P') {
					st.pop();
					st.pop();
					pCnt -= 2;
				} else {
					System.out.println("NP");
					return;
				}
			} catch (Exception e) {
				System.out.println("NP");
				return;
			}
		}
		if (st.size() == 1)
			System.out.println("PPAP");
		else
			System.out.println("NP");
	}
}
