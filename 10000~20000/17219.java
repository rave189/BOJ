package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 경민이는 메모장에 사이트 주소와 비밀번호를 저장해둔다.
 * 하지만 사이트 수가 많아지면서 비밀번호를 찾는데 애를 먹고있다.
 * 사이트 주소가 주어질 때 비밀번호를 구하는 문제
 * 비밀번호를 찾을 때 사이트 주소는 항상 저장된 사이트 주소가 나온다.
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