package cn.noload.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hao.caosh@ttpai.cn
 * @date 2020-09-21 13:53
 */
public class HeapOverFlowTest {

    private int[] intArr = new int[50];

    public static void main(String[] args) throws InterruptedException {
        List<HeapOverFlowTest> list = new ArrayList<>();
        while (true) {
            Thread.sleep(1);
            list.add(new HeapOverFlowTest());
        }
    }
}
