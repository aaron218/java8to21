package java21.nf.vt;


/**
 * 虚拟线程基础的样例
 */
public class VTDemo {

    static Runnable fn = () -> {
        System.out.println("1");
        System.out.println("2");
    };

    static class Fn implements Runnable {
        public void run() {
            System.out.println("AA");
        }
    }


    public static void main(String[] args) {
        Thread thread = Thread.ofVirtual().unstarted(new Fn());
        Thread thread1 = Thread.ofPlatform().start(fn);
        thread.start();
        //join到当前线程上，否则可能会由于主线程先退出而导致无法显示内容
        try {
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
