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
        Thread thread1 = Thread.ofVirtual().unstarted(fn);
//        for (int i=0;i<100;i++){
//            Thread t = Thread/
//        }
        thread.start();
        thread1.start();
        //join到当前线程上，否则可能会由于主线程先退出而导致无法显示内容
        System.out.println("Start");
        try {
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
