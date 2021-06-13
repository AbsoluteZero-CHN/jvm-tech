package cn.noload.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;


/**
 * JVM 参数
 * -Xmx300m -XX:+PrintGCDetails
 * 虚引用目的是让用户只到对象被 GC 了, 在 Java8 下只会伴随 Full GC 回收, Java9 后修复掉了
 * <a href="https://zhuanlan.zhihu.com/p/306795513">参考链接</a>
 * */
public class PhantomReferenceDemo {
    // 1m
    private static int _1M = 1024 * 1024 * 1;

    private static ReferenceQueue referenceQueue = new ReferenceQueue();

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Object> objects = new ArrayList<>();
        int count = 1;
        new Thread(() -> {
            while (true) {
                try {
                    Reference remove = referenceQueue.remove();
                    // objects 可达性分析，可以到达 PhantomReference<Demo>，内存是不能及时释放的，我们需要在队里中拿到那个 Demo 被回收了，然后
                    // 从 objects 移除这个对象
                    if (objects.remove(remove)) {
                        System.out.println("移除元素: " + remove.get());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        while (true) {
            Thread.sleep(500);
            // 获取 jvm 空闲的内存为多少 m
            long meme_free = Runtime.getRuntime().freeMemory() / _1M;
            if ((meme_free - 10) > 40) {
                Demo demo = new Demo(count);
                PhantomReference<Demo> demoWeakReference = new PhantomReference<>(demo, referenceQueue);
                objects.add(demoWeakReference);
                count++;
                demo = null;
            }
            System.out.println("jvm 空闲内存" + meme_free + " m");
            System.out.println(objects.size());
        }
    }

    static class Demo {
        private byte[] a = new byte[_1M * 10];
        private String str;

        public Demo(int i) {
            this.str = String.valueOf(i);
        }
    }
}
