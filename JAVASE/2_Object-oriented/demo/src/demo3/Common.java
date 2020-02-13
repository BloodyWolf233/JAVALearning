package demo3;

import demo3.known.OpenMode;

import java.util.ArrayList;

public class Common implements OpenMode {
    @Override
    public ArrayList<Integer> divide(int totalMoney, int totalCount) {
        ArrayList<Integer> list = new ArrayList<>();
        int money = totalMoney / totalCount;
        for (int i = 0; i < totalCount - 1; i++) {
            list.add(money);
            totalMoney -= money;
        }
        list.add(totalMoney);
        System.out.println("Average Red Pocket amount:" + list);
        return list;
    }
}
