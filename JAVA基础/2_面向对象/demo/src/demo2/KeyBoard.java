package demo2;

public class KeyBoard implements USB {
    @Override
    public void open() {
        System.out.println("USB: keyboard open success.\n");
    }

    @Override
    public void close() {
        System.out.println("USB: keyboard close success.\n");
    }

    public void type() {
        System.out.println("keyboard type in.\n");
    }
}
