package demo1;

import java.util.ArrayList;
import java.util.Random;

public class Member extends User {
    public Member(String username) {
        super(username);
    }

    public Member(String username, double leftMoney) {
        super(username, leftMoney);
    }

    //open a Red Packet
    public void openRedPacket(ArrayList<Double> list) {
        Random r = new Random();
        int index = r.nextInt(list.size());
        Double money = list.remove(index);
        this.setLeftMoney(super.getLeftMoney() + money);
    }
}
