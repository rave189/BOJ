package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * ����̴� �޸��忡 ����Ʈ �ּҿ� ��й�ȣ�� �����صд�.
 * ������ ����Ʈ ���� �������鼭 ��й�ȣ�� ã�µ� �ָ� �԰��ִ�.
 * ����Ʈ �ּҰ� �־��� �� ��й�ȣ�� ���ϴ� ����
 * ��й�ȣ�� ã�� �� ����Ʈ �ּҴ� �׻� ����� ����Ʈ �ּҰ� ���´�.
 * @author Rave
 *
 */
public class Main {

	static HashMap<String, String> hash = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			hash.put(st.nextToken(), st.nextToken());
		}
		while (m-- > 0)
			sb.append(hash.get(br.readLine()) + "\n");
		System.out.println(sb);
	}
}