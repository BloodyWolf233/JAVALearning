package demo3;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        RedPacket rp = new RedPacket("红包");
        rp.setOwnerName("我是群主");
        rp.setOpenWay(new Common());
        //rp.setOpenWay(new Lucky());
    }
}
