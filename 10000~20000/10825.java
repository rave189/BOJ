package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * �����̳� �� �л����� �־��� ���ǿ� �°� �����ϴ� ����
 * ������ ������ ����.
 * 1.���� ������ �����ϴ� ������
 * 2.���� ������ ������ ���� ������ �����ϴ� ������
 * 3.���� ������ ���� ������ ������ ���� ������ �����ϴ� ������
 * 4.��� ������ ������ �̸��� ���� ������ �����ϴ� ������
 *   (��, �ƽ�Ű �ڵ忡�� �빮�ڴ� �ҹ��ں��� �����Ƿ� ���������� �տ� �´�.)
 * ������ �Ϸ��� �Ŀ� �л����� �̸��� ����Ѵ�.
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Student> pq = new PriorityQueue<>();
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int korean = Integer.parseInt(st.nextToken());
			int english = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			pq.add(new Student(name, korean, english, math));
		}
		while (!pq.isEmpty())
			sb.append(pq.poll().name + "\n");
		System.out.print(sb);
	}
}

class Student implements Comparable<Student> {
	String name;
	int korean, math, english;

	public Student(String _name, int _korean, int _english, int _math) {
		this.name = _name;
		this.korean = _korean;
		this.english = _english;
		this.math = _math;
	}

	@Override
	public int compareTo(Student o) {
		if (korean > o.korean)
			return -1;
		else if (korean == o.korean) {
			if (english < o.english)
				return -1;
			else if (english == o.english) {
				if (math > o.math)
					return -1;
				else if (math == o.math)
					return name.compareTo(o.name);
			}
		}
		return 1;
	}
}