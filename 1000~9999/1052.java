package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1리터의 물이 들어있는 물병 N개가 있다.
 * 이 물병을 K개 이하로 만들어 다른 곳으로 물병을 옮기려고 한다.
 * 이 물병을 합치려면 같은 양이 들어있는 물병 두 개 중 한 쪽으로 물을 모두 옮긴다.
 * 이 때, 물병에는 물이 무한대로 들어간다.
 * @author Rave
 *
 */
public class Main {

	/**
	 * 물을 항상 두 개씩 합치기 때문에 최종적으로 나오는 물병의 개수는 이진수의 형태로 나온다.
	 * 이 이진수에서 1의 개수가 곧 물병의 개수이고 이 수가 k보다 작거나 같을 때까지 반복하여 정답을 구한다.
	 * 
	 * 그리디 방식으로 n을 2로 나눠주면서 부족한 부분을 채워주듯이 구하다가 엄청 틀렸다.
	 * 하지만 이 방식은 물을 다 합쳐보지 않고 당장 없으면 무조건 구매하는 방식이므로 틀린 방법이었다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		String binaryStr = null;
		int answer = 0;
		while (getOneCount(binaryStr = Integer.toBinaryString(n)) > k) {
			// 가장 뒤의 1을 찾아 그 때의 인덱스를 구한다.
			// 이 때, 인덱스는 뒤에서부터 계산했을 때의 인덱스이다.
			// length는 0~ length까지이고 index는 0~ length-1까지이므로 length에 1을 더 빼준다.
			int buy = (int) Math.pow(2, binaryStr.length() - binaryStr.lastIndexOf('1') - 1);
			answer += buy;
			// 이진수를 더해주는 것 자체가 물병의 개수를 줄이는 것이다.
			n += buy;
		}
		System.out.println(answer);
	}

	public static int getOneCount(String str) {
		int count = 0;
		for (char ch : str.toCharArray())
			if (ch == '1')
				count++;
		return count;
	}
}