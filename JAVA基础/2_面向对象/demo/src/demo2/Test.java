package demo2;

public class Test {
    public static void main(String[] args) {
        Laptop lt = new Laptop();
        lt.run();
        USB u = new Mouse();
        lt.useUSB(u);
        KeyBoard kb = new KeyBoard();
        lt.useUSB(kb);
        lt.shutDown();
    }
}
