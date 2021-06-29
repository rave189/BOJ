package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * �ϰ� �����̴� �������� ���� �Ϸ� ����.
 * ��� �� ��ȩ �����̰� ���ƿԴ�.
 * ������ �鼳���ִ� �����̵��� ���ڿ� ���� ���� 100�� �ǵ��� ���ڸ� ������Ҵ�.
 * �� ��, �ϰ� �����̸� ã�� ����
 * @author Rave
 *
 */
public class Main {

	static int[] dwarf;
	static ArrayList<Integer> answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dwarf = new int[9];
		answer = new ArrayList<>();
		for (int i = 0; i < dwarf.length; i++)
			dwarf[i] = Integer.parseInt(br.readLine());
		BruteForce(0, 0);
	}

	/**
	 * ���Ʈ������ ����Ͽ� �ϰ� �����̸� ���Ѵ�.
	 * @param cur Ž���� ������ ������
	 * @param sum ������� �����̵��� ������ ��
	 */
	public static void BruteForce(int cur, int sum) {
		if (answer.size() == 7) {
			if (sum == 100) {
				for (int i = 0; i < answer.size(); i++)
					System.out.println(answer.get(i));
				System.exit(0);
			}
			return;
		}
		for (int i = cur; i < dwarf.length; i++) {
			answer.add(dwarf[i]);
			BruteForce(i + 1, sum + dwarf[i]);
			answer.remove(answer.size() - 1);
		}
	}
}