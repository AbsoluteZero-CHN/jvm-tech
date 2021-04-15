package cn.noload.oom;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author hao.caosh@ttpai.cn
 * @date 2020-11-11 16:43
 */
public class ByteCode extends ByteCodeFather {
    private char _1 = 'a';
    private int _2 = 0;
    private long _3 = 0L;

    public static void main(String[] args) {
        System.out.println(ClassLayout.parseInstance(new ByteCode()).toPrintable());
    }
}

class ByteCodeFather {
    private char _1 = 'a';
    private int _2 = 0;
    private long _3 = 0L;
}
