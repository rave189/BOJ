package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ������ �� ���� ���̸� s�� �Ͽ� �Է����� �־��� ������ ����ϴ� ����
 */
public class Main {

	static StringBuffer sb = new StringBuffer();

	/**
	 * �Է� ���� 
	 * 2 1234567890
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		String input = st.nextToken();
		// ���� �̾ ����ؾ� �ϹǷ� ó������ ������ ����ϰ� �ٽ� ���ƿ��� ����� ����Ѵ�.
		for (int i = 0; i < 2 * s + 3; i++) {
			for (int j = 0; j < input.length(); j++) {
				char ch = input.charAt(j);
				Classification(ch, s, i);
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	/**
	 * ���ڸ� �з��Ͽ� ������ �޼ҵ带 �����ϱ� ���� �޼ҵ�
	 */
	public static void Classification(char ch, int s, int index) {
		if (ch == '1')
			One(s, index);
		else if (ch == '2')
			Two(s, index);
		else if (ch == '3')
			Three(s, index);
		else if (ch == '4')
			Four(s, index);
		else if (ch == '5')
			Five(s, index);
		else if (ch == '6')
			Six(s, index);
		else if (ch == '7')
			Seven(s, index);
		else if (ch == '8')
			Eight(s, index);
		else if (ch == '9')
			Nine(s, index);
		else if (ch == '0')
			Zero(s, index);
	}

	public static void One(int s, int index) {
		if (index == 0 || index == s + 1 || index == 2 * s + 2)
			Blank(s);
		else
			Right(s);
	}

	public static void Two(int s, int index) {
		if (0 < index && index < s + 1)
			Right(s);
		else if (s + 1 < index && index < 2 * s + 2)
			Left(s);
		else
			Row(s);
	}

	public static void Three(int s, int index) {
		if (index == 0 || index == s + 1 || index == 2 * s + 2)
			Row(s);
		else
			Right(s);
	}

	public static void Four(int s, int index) {
		if (0 < index && index < s + 1)
			LeftRight(s);
		else if (s + 1 < index && index < 2 * s + 2)
			Right(s);
		else if (index == s + 1)
			Row(s);
		else
			Blank(s);
	}

	public static void Five(int s, int index) {
		if (0 < index && index < s + 1)
			Left(s);
		else if (s + 1 < index && index < 2 * s + 2)
			Right(s);
		else
			Row(s);
	}

	public static void Six(int s, int index) {
		if (0 < index && index < s + 1)
			Left(s);
		else if (s + 1 < index && index < 2 * s + 2)
			LeftRight(s);
		else
			Row(s);
	}

	public static void Seven(int s, int index) {
		if (index == 0)
			Row(s);
		else if (index == s + 1 || index == 2 * s + 2)
			Blank(s);
		else
			Right(s);
	}

	public static void Eight(int s, int index) {
		if (index == 0 || index == s + 1 || index == 2 * s + 2)
			Row(s);
		else
			LeftRight(s);
	}

	public static void Nine(int s, int index) {
		if (0 < index && index < s + 1)
			LeftRight(s);
		else if (s + 1 < index && index < 2 * s + 2)
			Right(s);
		else
			Row(s);
	}

	public static void Zero(int s, int index) {
		if (index == 0 || index == 2 * s + 2)
			Row(s);
		else if (index == s + 1)
			Blank(s);
		else
			LeftRight(s);
	}

	/**
	 * s+1��ŭ�� ������ ��� �� '|'�� ����Ѵ�.
	 */
	public static void Right(int s) {
		for (int i = 0; i <= s; i++)
			sb.append(" ");
		sb.append("|");
	}

	/**
	 * '|'�� ����� �� s+1��ŭ�� ������ ����Ѵ�.
	 */
	public static void Left(int s) {
		sb.append("|");
		for (int i = 0; i <= s; i++)
			sb.append(" ");
	}

	/**
	 * s��ŭ�� ������ ����ϰ�, �� �ڿ� '|'�� ����Ѵ�.
	 */
	public static void LeftRight(int s) {
		sb.append("|");
		for (int i = 0; i < s; i++)
			sb.append(" ");
		sb.append("|");
	}

	/**
	 * �� �ڿ� ������ ����ϰ�, s��ŭ�� '-'�� ����Ѵ�.
	 */
	public static void Row(int s) {
		sb.append(" ");
		for (int i = 0; i < s; i++)
			sb.append("-");
		sb.append(" ");
	}

	/**
	 * ��� ĭ�� �������� ����Ѵ�.
	 */
	public static void Blank(int s) {
		for (int i = 0; i <= s + 1; i++)
			sb.append(" ");
	}
}