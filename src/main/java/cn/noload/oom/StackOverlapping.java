package cn.noload.oom;

/**
 * @author hao.caosh@ttpai.cn
 * @date 2020-12-07 14:31
 */
public class StackOverlapping {

    public void add(int a, int b) {
        StackOverlapping test = this;
        int z = a + b;
        int x = 3;
    }

    public static void main(String[] args) {
        StackOverlapping stackOverlapping = new StackOverlapping();
        stackOverlapping.add(2, 3);
    }
}
