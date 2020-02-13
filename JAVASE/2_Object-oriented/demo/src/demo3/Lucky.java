package demo3;

import demo3.known.OpenMode;

import java.util.ArrayList;
import java.util.Random;

public class Lucky implements OpenMode {
    @Override
    public ArrayList<Integer> divide(int totalMoney, int totalCount) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        int time = totalCount - 1;
        for (int i = 0; i < time; i++) {
            int money = random.nextInt(totalMoney / totalCount * 2) + 1;
            list.add(money);
            totalMoney -= money;
            totalCount--;
        }
        list.add(totalMoney);
        System.out.println("Lucky Red Pocket amount:" + list);
        return list;
    }
}
