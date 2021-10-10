package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * �� ������ �� ���̼� �ϴ� �����̴�.
 * N���� ���� ���� ��, ����̿� â���̰� �����ư��� 1�� �Ǵ� 3���� ���� ������ �� �ִ�.
 * ������ ���� �������� ����� ���ӿ��� �й��Ѵ�.
 * �� ����� �Ϻ��ϰ� ������ ���� ��, �̱�� ����� ���ϴ� ����
 * ������ ����̰� ���� �����Ѵ�.
 * @author Rave
 *
 */
public class Main {

	/**
	 * ����̰� ó�� �����ϹǷ� 1�� �Ǵ� 3���� ������ â���̰� �̱��.
	 * 2�� �Ǵ� 4���� ����̰� ������ �̱��.
	 * �� ��Ģ�� ��� �ǹǷ� n���� ���� 2�� ���� �������� 0�̸� ����̰�, �ƴ϶�� â���̰� �̱��.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(n % 2 == 0 ? "SK" : "CY");
	}
}