package cn.noload.oom;

/**
 * @author hao.caosh@ttpai.cn
 * @date 2020-11-30 14:37
 */
public class VtableTest {

    public static void main(String[] args) {
        Father child = new Child();
        child.run();
    }
}

abstract class Father {
    public Father() {
        run();
    }
    // miranda 方法
    abstract void run();
}

class Child extends Father {

    @Override
    void run() {
        int i = 0;
    }
}
