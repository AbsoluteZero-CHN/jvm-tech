package cn.noload.reference;


import java.lang.ref.WeakReference;
import java.util.ArrayList;


/**
 * JVM 参数
 * -Xmx300m -XX:+PrintGCDetails
 * 弱引用的 GC 时机伴随着 Young GC
 * */
public class WeakReferenceDemo {
    // 1m
    private static int _1M = 1024 * 1024 * 1;


    public static void main(String[] args) throws InterruptedException {
        ArrayList<Object> objects = new ArrayList<Object>();
        int count = 1;
        while (true) {
            Thread.sleep(100);
            // 获取 jvm 空闲的内存为多少 m
            long meme_free = Runtime.getRuntime().freeMemory() / _1M;
            if ((meme_free - 10) >= 0) {
                Demo demo = new Demo(count);
                WeakReference<Demo> demoWeakReference = new WeakReference<>(demo);
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
