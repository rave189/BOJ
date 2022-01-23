package BOJ.Day5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 파티에 친구들을 부르고 사탕을 공평하게 나누어 주려고 한다.
 * 파티에 K명이 참여한다면 K*X개의 사탕을 사야 한다.
 * 하지만 적어도 한 명은 사탕을 잃어버리기 때문에 K*X+1개를 구매하려고 한다.
 * 한 봉지에 사탕은 C개 들어있을 때, 구매해야 하는 사탕 봉지의 개수를 구하는 문제
 */
public class Main {
    /**
     * 확장 유클리드 호제법을 사용하는 문제
     * 확장 유클리드 호제법을 이용하여 k의 범위가 나온다.
     * 이 문제는 아무거나 출력이기 때문에 가장 큰 k의 값을 기준으로 출력함.
     *
     * a*x + 1 = b * y (ax + by = c로 변환)
     * -ax + by = 1
     * a*(-x) + by = 1
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 1. 해 검증
            // D = gcd(a, b) = extendEuclidGcd(a, b) = Euclid.r
            // ax + by = c 일때 c%d == 0
            // c%d != 0 -> 해가 없음
            // 2.초기 해 구하기
            // x0 = s*c/d
            // y0 = t*c/d
            Euclid euclid = extendEuclidGcd(a, b);
            if (1 % euclid.r != 0)
                answer.append("IMPOSSIBLE");
            else {
                // 3. 일반해 구하기
                // x = x0 + b/d*k
                // y = y0 - a/d*k

                // 4. k의 범위 (소수점 필요함) -> double로 사용
                // d는 1이므로 생략
                // x < 0
                // x0 + bk < 0
                // k < -x0/b
                // 0 < y <= 10^9
                // 0 < y0 - ak <= 10^9
                // -y0 < -ak <= 10^9 - y0
                // y0/a > k >= (-10^9 + y0)/a
                // (-10^9 + y0)/a <= k < y0/a
                //                   k <-x0/b
                // k의 경계값 찾기 <= 라면 floor, < 라면 ceil - 1

                // 5. 만족하는 k가 있는지 찾고 k로 y를 구한다.
                double k1 = euclid.t / (double) a;
                double k2 = -euclid.s / (double) b;
                int min = (int) Math.ceil(Math.min(k1, k2)) - 1;
                if (min >= (-1000000000 + euclid.t) / (double) a)
                    answer.append(euclid.t - a * min);
                else
                    answer.append("IMPOSSIBLE");
            }
            answer.append('\n');
        }
        System.out.print(answer);
    }

    public static Euclid extendEuclidGcd(int a, int b) {
        int s0 = 1, t0 = 0, r0 = a;
        int s1 = 0, t1 = 1, r1 = b;

        while (r1 != 0) {
            int q = r0 / r1;

            int tmp = r0 - r1 * q; // tmp = r0%r1;
            r0 = r1;
            r1 = tmp;

            // tmp가 %를 사용하면 유클리드 호제법이다.
            // 이 아래부터가 확장 유클리드 호제법

            tmp = s0 - s1 * q;
            s0 = s1;
            s1 = tmp;

            tmp = t0 - t1 * q;
            t0 = t1;
            t1 = tmp;
        }
        return new Euclid(s0, t0, r0);
    }
}

class Euclid {
    int s, t, r;

    public Euclid(int s, int t, int r) {
        this.s = s;
        this.t = t;
        this.r = r;
    }

    @Override
    public String toString() {
        return "Euclid{" +
                "s=" + s +
                ", t=" + t +
                ", r=" + r +
                '}';
    }
}