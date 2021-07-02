package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * �����̴� �мǿ� �ΰ��Ͽ� �� �� �Ծ��� �ʵ��� ������ �ٽ� ���� �ʴ´�.
 * �����̰� ���� ���� �̸��� ������ �־����� ��
 * �����̰� ���� �� �ִ� ���� ����� ���� ���ϴ� ����
 * ��, �ƹ��͵� ���� �ʴ� ���� �����Ѵ�.
 * @author Rave
 *
 */
public class Main {

	static HashMap<String, Integer> hash = new HashMap<>();

	/**
	 * ���� ������ ���� ������ ���� �ʴ� ��츦 1 ���� ��
	 * ��� ����� ���� ���Ͽ� ���� �� �ִ�.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {
			int n = Integer.parseInt(br.readLine());
			hash.clear();
			while (n-- > 0) {
				String[] split = br.readLine().split(" ");
				hash.put(split[1], hash.getOrDefault(split[1], 0) + 1);
			}
			int answer = 1;
			for (String key : hash.keySet())
				answer *= hash.get(key) + 1;
			sb.append(answer - 1 + "\n");
		}
		System.out.println(sb);
	}
}