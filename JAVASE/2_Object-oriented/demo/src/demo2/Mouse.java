package demo2;

public class Mouse implements USB {
    @Override
    public void open() {
        System.out.println("USB: mouse open success.\n");
    }

    @Override
    public void close() {
        System.out.println("USB: mouse close success.\n");
    }

    public void click() {
        System.out.println("mouse click.\n");
    }
}
