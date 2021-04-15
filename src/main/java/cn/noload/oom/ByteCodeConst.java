package cn.noload.oom;

/**
 * @author hao.caosh@ttpai.cn
 * @date 2020-11-30 18:08
 */
public class ByteCodeConst {
    public void run() {
        int a = 1;
    }

    public static void main(String[] args) {
        int a = 1;
        new ByteCodeConst().add(a);
    }

    private void add(int i) {
        int a = 1;
    }
    private static void add2(int i) {
        int a = 1;
    }
}
