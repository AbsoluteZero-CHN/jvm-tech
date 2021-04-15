package cn.noload.oom;

/**
 * @author hao.caosh@ttpai.cn
 * @date 2020-11-23 14:41
 */
public class Main {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        add(a, b);
        add(a, a, a);
    }

    public static void add(int m, int n) {
        int a = m + n;
    }

    public static void add(int m, int n, int x) {
        int a = m + n + x;
    }
}
