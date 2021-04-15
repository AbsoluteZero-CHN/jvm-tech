package cn.noload.oom;

/**
 * @author hao.caosh@ttpai.cn
 * @date 2020-12-08 16:03
 */
public class Test {
    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 20; i++) {
                int index = i;
                new Thread(() -> System.out.println(index)).start();
            }
        }
    }
}
