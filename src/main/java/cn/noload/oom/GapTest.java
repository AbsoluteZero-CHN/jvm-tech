package cn.noload.oom;

import org.ehcache.sizeof.SizeOf;
import org.ehcache.sizeof.impl.AgentSizeOf;

/**
 * 间隙填充测试
 * @author hao.caosh@ttpai.cn
 * @date 2020-12-07 11:54
 */
public class GapTest {
    public static void main(String[] args) {
        SizeOf sizeOf = new AgentSizeOf();
        System.out.println(sizeOf.sizeOf(new GGGGG()));
    }
}

class GGGGG {
    private GapTest gapTest;
}