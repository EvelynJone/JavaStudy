package performance.optimization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年05月23日上午12:48]
 */
public class Test {

    private static final Logger LOG = LoggerFactory.getLogger(Test.class);

    public void doTest() {
        double l;

        long start = System.currentTimeMillis();

        for (int i = 0; i < 10; i ++) {
            l = fibImpk1(30);
        }
        long end = System.currentTimeMillis();
        System.out.println("conusming : "+ (end - start));
    }

    public void doTest2() {
        Double l = null;

        long start = System.currentTimeMillis();

        for (int i = 0; i < 10; i ++) {
            l = fibImpk1(30);
        }
        long end = System.currentTimeMillis();
        System.out.println("conusming : "+ (end - start) + "  l : " + l.toString() );
    }

    public double fibImpk1(int n) {
        if (n < 0) throw new IllegalArgumentException("must be > 0");
        if (n == 0) return  0;
        if (n == 1) return  1;
        double d = fibImpk1(n-2) + fibImpk1(n - 1);
        if (Double.isInfinite(d)) throw new ArithmeticException("Overflow");
        return d;
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.doTest();
        test.doTest2();
    }
}
