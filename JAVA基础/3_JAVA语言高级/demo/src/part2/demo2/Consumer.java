package part2.demo2;

public class Consumer extends Thread {
    private BaoZi bz;

    public Consumer(String name, BaoZi bz) {
        super(name);
        this.bz = bz;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (bz) {
                if (bz.flag == false) {
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Consumer("+this.getName()+") has buy" + bz.pi + bz.xian + "BaoZi");
                    bz.flag = false;
                    bz.notify();
                }
            }
        }
    }
}
