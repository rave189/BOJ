import java.io.IOException;

public class Main {
	public static int[] array = new int[10000];

	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 10000; i++)
			selfNumber(Integer.toString(i + 1));
		for (int i = 0; i < 9999; i++)
			if (array[i] == 0)
				System.out.println(i + 1);
	}

	public static void selfNumber(String n) {
		if (n.length() < 5) {
			int nextNum;
			nextNum = Integer.parseInt(n) + sum(n, n.length());
			if (nextNum < 10000)
				array[nextNum - 1]++;
			selfNumber(Integer.toString(nextNum));
		};
	}

	public static int sum(String n, int num) {
		int sum = 0;
		for (int i = 0; i < num; i++)
			sum += Integer.parseInt(n.substring(i, i + 1));
		return sum;
	}
}
