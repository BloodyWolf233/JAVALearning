package demo1;

import java.util.ArrayList;

public class Lord extends User {
    public Lord() {
    }

    public Lord(String username) {
        super(username);
    }

    public Lord(String username, double leftMoney) {
        super(username, leftMoney);
    }
    /*
     * When the Wechat group owner send a Average Red Packet
     * 1. check the owner's wallet balance, if enough then continue
     * else return null and give a note.
     * 2. change the owner's money.
     * 3. split the money if it is divisible then split
     * else put the remainder into the last split.
     */

    public ArrayList<Double> send(Double money, int count) {
        //check the owner's wallet
        double leftMoney = this.getLeftMoney();
        if (money > leftMoney) {
            return null;
        }
        //change the wallet
        this.setLeftMoney(leftMoney - money);
        ArrayList<Double> list = new ArrayList<>();
        //Enlaged 100 times to accurate to 0.01
        money = money * 100;
        Double m = money / count;
        Double l = money % count;
        for (int i = 0; i < count - 1; i++) {
            list.add(m / 100.0);
        }
        if (l == 0) {
            list.add(m / 100.0);
        } else {
            list.add((m + l) / 100.0);
        }
        return list;
    }

}
