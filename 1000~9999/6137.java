package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * N���� ���ڷ� �̷���� ���ڿ��� �־�����.
 * �� ���ڿ��� ���ڿ� T�� ������� �Ѵ�.
 * T�� ����� ��Ģ�� ������ ����.
 * 1. S�� �� �� ���� �ϳ��� T�� �߰��Ѵ�.
 * 2. S�� �� �� ���� �ϳ��� T�� �߰��Ѵ�.
 * �� ��Ģ���� ���� �� �ִ� ���ڿ� T �� ���������� ���� ���� ���ڿ��� ����ϴ� ����
 * ��� �� 80���ڸ��� ���๮�ڸ� �־��ش�.
 * @author Rave
 *
 */
public class Main {

	/**
	 * �� �հ� �� �� ���ڸ� ���Ѵ�. ������ ũ�ų� ���� ���� ���� ���ڸ� T�� �߰����ش�.
	 * �׷��� �� �� ���� ������ ��� �ݺ������� ��� ������ ���� ������ ���غ���.
	 * �� ���� ���ڸ� ���� ���� �߰��ϸ� ���� ���ڸ� T�� �߰��ϰ� �����Ѵ�.
	 * �ƹ� ���ڵ� �߰����� ���Ѵٸ� ���� ���ڸ� �߰��Ѵ�.
	 * 
	 * result�� StringBuilder�� ����Ͽ� ������ Ǯ������.
	 * StringBuilder�� ũ�Ⱑ 80�� ������ ���� ���ڸ� �ֵ��� for�� �ȿ� if���� ����Ͽ���.
	 * ������ ���� ���ڵ� �ϳ��� �����̱� ������ ��Ȯ�� 80���ڸ��� ������ ���� ����.
	 * ���� List�� �ٲ� �� ��� �� 80���ڸ��� �����ϵ��� ����.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder input = new StringBuilder();
		ArrayList<Character> result = new ArrayList<>();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++)
			input.append(br.readLine().charAt(0));
		for (int left = 0, right = input.length() - 1; left <= right;) {
			// ������ ũ�ų� ���� ���
			if (input.charAt(left) < input.charAt(right))
				result.add(input.charAt(left++));
			else if (input.charAt(left) > input.charAt(right))
				result.add(input.charAt(right--));
			else {
				// �� ���ڰ� ���� ��� ���� ���ڵ��� ���غ���.
				int i = left, j = right, length = result.size();
				for (; i <= j; i++, j--) {
					if (input.charAt(i) < input.charAt(j)) {
						result.add(input.charAt(left++));
						break;
					} else if (input.charAt(i) > input.charAt(j)) {
						result.add(input.charAt(right--));
						break;
					}
				}
				// �ƹ��͵� �߰����� ���ϸ� �� �� ���ڸ� �߰��Ѵ�.
				if (length == result.size())
					result.add(input.charAt(left++));
			}
		}
		// 80�ٸ��� ������ �־ ����Ѵ�.
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i));
			if ((i + 1) % 80 == 0)
				System.out.println();
		}
	}
}