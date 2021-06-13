package cn.noload.reference;


import java.lang.ref.SoftReference;
import java.util.ArrayList;


/**
 * JVM 参数
 * -Xmx300m -XX:+PrintGCDetails
 * 配置了老年代占用 30% 开始 CMS 回收, 但是实测下来频繁 CMS GC, 但弱引用对象并没有被 GC 掉
 * 初步估计弱引用不在 CMS 要扫描的 GC Roots 里, 所以尽量不要用
 * */
public class SoftReferenceDemo {
    // 1m
    private static int _1M = 1024 * 1024 * 1;
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Object> objects = new ArrayList<>();
        int count = 1;
        while (true) {
            Thread.sleep(500);
            // 获取 jvm 空闲的内存为多少 m
            long meme_free = Runtime.getRuntime().freeMemory() / _1M;
            if ((meme_free - 10) >= 0) {
                Demo demo = new Demo(count);
                SoftReference<Demo> demoSoftReference = new SoftReference<>(demo);
                objects.add(demoSoftReference);
                count++;
                // demo 为 null,只有 demoSoftReference 一条引用到达 Demo 的实例，GC 将会在 oom 之前回收 Demo 的实例
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