import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		for (int i = 1;; i++) {
			String[] line = input.nextLine().split("");
			if (line[0].equals("-"))
				break;
			Stack<String> st = new Stack<String>();
			int count = 0;
			for (int j = 0; j < line.length; j++) {
				if (line[j].equals("{"))
					st.push("{");
				else {
					if (st.isEmpty()) {
						st.push("{");
						count++;
					} else
						st.pop();
				}
			}
			while (!st.isEmpty()) {
				st.pop();
				st.pop();
				count++;
			}
			System.out.println(i + ". " + count);
		}
	}
}
