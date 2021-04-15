package cn.noload.oom;

/**
 * @author hao.caosh@ttpai.cn
 * @date 2020-11-27 15:13
 */
public class localVariableTableTest {

    public static void main(String[] args) {
        new localVariableTableTest().add(2, 3);
    }

    private void add(int aaa, int bbb) {
        int zzz = aaa + bbb;
        long yyy = zzz + 5;
        int xxx = 3 + zzz;
    }
}
