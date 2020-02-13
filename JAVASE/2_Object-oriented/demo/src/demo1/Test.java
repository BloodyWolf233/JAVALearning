package demo1;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Lord lord = new Lord("The great lord", 200);
        Scanner sc = new Scanner(System.in);
        System.out.println("Please type in the amount you want send:");
        Double money = sc.nextDouble();
        System.out.println("Please type in the number your Red Pocket has:");
        int count = sc.nextInt();

        //send
        ArrayList<Double> sendList = lord.send(money, count);
        if (sendList == null) {
            System.out.println("Sorry, you don't have enough money...\n");
            return;
        }
        Member m1 = new Member("m1");
        Member m2 = new Member("m2");
        Member m3 = new Member("m3");
        //open
        m1.openRedPacket(sendList);
        m2.openRedPacket(sendList);
        m3.openRedPacket(sendList);
        //show
        lord.show();
        m1.show();
        m2.show();
        m3.show();
    }
}
