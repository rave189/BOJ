import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		if (n % 2 != 0)
			System.out.println(0);
		else {
			long[] arr = new long[n + 1];
			arr[0] = 1;
			arr[2] = 3;
			for (int i = 4; i <= n; i += 2) {
				arr[i] = arr[i - 2] * 3;        // 이전 경우에서 3*2 타일을 추가했을 때의 경우.
				for (int j = 4; j <= i; j += 2)
					arr[i] += arr[i - j] * 2;     // 각각의 고유 모양들이 뒤에 있을 경우를 추가하여 준다.(고유 모양 + 뒤집은 고유 모양)
			}
			System.out.println(arr[n]);
		}
	}
}
