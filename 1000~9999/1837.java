package BOJ.Day5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 두 소수 p와 q를 곱하여 암호를 만들었다.
 * 하지만 소수가 작은 경우 브루트포스로 탐색이 가능하기 때문에
 * p와 q중에서 하나라도 k보다 작으면 좋지 않은 암호로 간주하기로 했다.
 * 암호가 좋으면 GOOD, 아니라면 BAD와 p, q중 작은 소수를 출력하는 문제
 */
public class Main {

    /**
     * BigInteger를 사용하면 쉽지만 재미없으므로 구현한다.
     * 실제 사람이 하는 나누기 연산은 100000/3 이어도 앞에 3/10, 3/10, 3/10 과 같은 방식으로 잘라서 계산하는 걸
     * 코드로 구현한다.
     * 나머지 값을 저장하는 int를 선언하고 자른 값을 k로 나누며 나머지를 더해간다.
     * 또한 p와 q는 소수이기 때문에 에라토스테네스의 체를 구해놓은 후
     * 소수인 수만 나머지 연산을 수행해본다.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String p = st.nextToken();
        int k = Integer.parseInt(st.nextToken());
        boolean[] isNotPrime = new boolean[k];
        for (int i = 2; i < k; i++) {
            if (!isNotPrime[i])
                for (int j = i + i; j < k; j += i)
                    isNotPrime[j] = true;
        }
        for (int i = 2; i < k; i++) {
            if (!isNotPrime[i] && mod(p, i) == 0) {
                System.out.printf("%s %d", "BAD", i);
                return;
            }
        }
        System.out.println("GOOD");
    }

    public static int mod(String p, int k) {
        int mod = 0;
        for (char ch : p.toCharArray()) {
            mod += ch - '0';
            mod %= k;
            mod *= 10;
        }
        return mod;
    }
}
