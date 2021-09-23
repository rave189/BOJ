package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1������ ���� ����ִ� ���� N���� �ִ�.
 * �� ������ K�� ���Ϸ� ����� �ٸ� ������ ������ �ű���� �Ѵ�.
 * �� ������ ��ġ���� ���� ���� ����ִ� ���� �� �� �� �� ������ ���� ��� �ű��.
 * �� ��, �������� ���� ���Ѵ�� ����.
 * @author Rave
 *
 */
public class Main {

	/**
	 * ���� �׻� �� ���� ��ġ�� ������ ���������� ������ ������ ������ �������� ���·� ���´�.
	 * �� ���������� 1�� ������ �� ������ �����̰� �� ���� k���� �۰ų� ���� ������ �ݺ��Ͽ� ������ ���Ѵ�.
	 * 
	 * �׸��� ������� n�� 2�� �����ָ鼭 ������ �κ��� ä���ֵ��� ���ϴٰ� ��û Ʋ�ȴ�.
	 * ������ �� ����� ���� �� ���ĺ��� �ʰ� ���� ������ ������ �����ϴ� ����̹Ƿ� Ʋ�� ����̾���.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		String binaryStr = null;
		int answer = 0;
		while (getOneCount(binaryStr = Integer.toBinaryString(n)) > k) {
			// ���� ���� 1�� ã�� �� ���� �ε����� ���Ѵ�.
			// �� ��, �ε����� �ڿ������� ������� ���� �ε����̴�.
			// length�� 0~ length�����̰� index�� 0~ length-1�����̹Ƿ� length�� 1�� �� ���ش�.
			int buy = (int) Math.pow(2, binaryStr.length() - binaryStr.lastIndexOf('1') - 1);
			answer += buy;
			// �������� �����ִ� �� ��ü�� ������ ������ ���̴� ���̴�.
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