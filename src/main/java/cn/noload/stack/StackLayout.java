package cn.noload.stack;


import org.openjdk.jol.info.ClassLayout;

/**
 * @author hao.caosh@ttpai.cn
 * @date 2021-03-01 11:29
 */
public class StackLayout {
    public static void main(String[] args) {
        long[] objects = new long[2];
        objects[0] = 1;
        objects[0] = 2L;
        System.out.println(ClassLayout.parseInstance(objects).toPrintable());
    }
}
