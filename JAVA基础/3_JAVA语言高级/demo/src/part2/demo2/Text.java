package part2.demo2;


public class Text {
    public static void main(String[] args) {
        BaoZi bz = new BaoZi();
        Consumer c1 = new Consumer("c1", bz);
        Producer pp = new Producer("pp", bz);

        c1.start();
        pp.start();


    }
}
