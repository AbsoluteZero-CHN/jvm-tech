package cn.noload.oom;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib 向元空间写入数据
 * @author hao.caosh@ttpai.cn
 * @date 2020-09-21 11:08
 */
public class MetaspaceOverFlowTest {

    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MetaspaceOverFlowTest.class);
            // 开启缓存后, metaspace 不会增长
            enhancer.setUseCache(false);
            MethodInterceptor callback = (Object o, Method m, Object[] params, MethodProxy proxy) -> proxy.invokeSuper(o, params);
            enhancer.setCallback(callback);
            enhancer.create();
        }
    }
}
