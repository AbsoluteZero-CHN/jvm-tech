package cn.noload.oom;

/**
 * @author hao.caosh@ttpai.cn
 * @date 2020-11-27 17:35
 */
public class AssignmentTest {
    private Integer i = 3;
    private static int a = 9;

    public AssignmentTest() {
        short s = 7;
    }

    {
        System.out.println(i);
    }

    public void add(int a, int b) {
        AssignmentTest test = this;
        int z = a + b;
        int x = 3;
    }

    public static void main(String[] args) {
        AssignmentTest test = new AssignmentTest();
        test.add(2, 3);
    }
}
