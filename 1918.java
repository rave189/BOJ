import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		String[] array = input.nextLine().split("");
		Stack<Character> st = new Stack<Character>();
		for(int i=0; i<array.length; i++) {
			char ch = array[i].charAt(0);
			if(ch >= 65 && ch <= 90)
				System.out.print(ch);
			else if(ch == '(')
				st.push(ch);
			else if(ch == ')') {
				while(!st.isEmpty()) {
					if(st.peek() == '(') {
						st.pop();
						break;
					}
					else
						System.out.print(st.pop());
				}
			}
			else if(ch == '+' || ch == '-') {
				while(!st.isEmpty()) {
					if(st.peek() == '(')
						break;
					System.out.print(st.pop());
				}
				st.push(ch);
			}
			else if(ch == '*' || ch == '/') {
				while(!st.isEmpty()) {
					if(st.peek() == '+' || st.peek() == '-' || st.peek() == '(')
						break;
					System.out.print(st.pop());
				}
				st.push(ch);
			}
		}
		while(!st.isEmpty())
			System.out.print(st.pop());
	}
}
