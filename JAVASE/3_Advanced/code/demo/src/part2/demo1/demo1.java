package part2.demo1;

public class demo1 {
    public static void main(String[] args) {
//        MyThread1 mt = new MyThread1("新的线程");
//        mt.start();
        MyRunnalbe mr = new MyRunnalbe();
        Thread t = new Thread(mr, "线程");
        t.start();
    }
}
