package demo3.known;

import java.util.ArrayList;

public interface OpenMode {
    /*
    * Please split the totalMoney into count, and save them into the ArrayList<Integer>, and return.
    *
    * @param totalMoney          The total amount has enlarged 100 times for convenience of calculation.
    * @param totalCount          the number of Red Packet.
    * @return ArrayList<Integer> the element is each red packet's money, sum is totalMoney.
    */
    ArrayList<Integer> divide(int totalMoney,int totalCount);
}
