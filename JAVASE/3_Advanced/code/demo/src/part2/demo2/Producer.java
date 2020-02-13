package part2.demo2;

public class Producer extends Thread {
    private BaoZi bz;

    public Producer(String name, BaoZi bz) {
        super(name);
        this.bz = bz;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (bz) {
                if (bz.flag == true) {
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("BaoZi has sold out, need to make more");
                if (count % 2 == 0) {
                    bz.pi = "冰皮";
                    bz.xian = "五仁";
                } else {
                    bz.pi = "薄皮";
                    bz.xian = "牛肉大葱";
                }
                count++;

                bz.flag = true;
                System.out.println("BaoZi has made:" + bz.pi + bz.xian);
                System.out.println("wait for sell " + count);
                bz.notify();
            }
        }
    }
}
