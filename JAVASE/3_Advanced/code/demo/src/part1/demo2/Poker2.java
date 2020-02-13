package part1.demo2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class Poker2 {
    public static void main(String[] args) {
        //1. create cards
        //1.1 create Map
        HashMap<Integer, String> pokerMap = new HashMap<>();
        //1.2 create color and number list
        ArrayList<String> colors = new ArrayList<>();
        ArrayList<String> numbers = new ArrayList<>();
        //1.3 add
        Collections.addAll(colors, "♦", "♣", "♥", "♠");
        Collections.addAll(numbers, "2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");

        int count = 1;
        pokerMap.put(count++, "Red Joker");
        pokerMap.put(count++, "Black Joker");
        //1.4 add into map
        for (String number : numbers) {
            for (String color : colors) {
                String card = color + number;
                pokerMap.put(count++, card);
            }
        }

        //2. shuffle the cards
        Set<Integer> numberSet = pokerMap.keySet();
        ArrayList<Integer> numberList = new ArrayList<>();
        numberList.addAll(numberSet);
        Collections.shuffle(numberList);

        //3 deal the cards
        ArrayList<Integer> noP1 = new ArrayList<>();
        ArrayList<Integer> noP2 = new ArrayList<>();
        ArrayList<Integer> noP3 = new ArrayList<>();
        ArrayList<Integer> noDark = new ArrayList<>();

        for (int i = 0; i < numberList.size(); i++) {
            Integer no = numberList.get(i);
            if (i < 51) {
                if (i % 3 == 0) {
                    noP1.add(no);
                } else if (i % 3 == 1) {
                    noP2.add(no);
                } else {
                    noP3.add(no);
                }
            } else {
                noDark.add(no);
            }
        }

        //show the card
        Collections.sort(noP1);
        Collections.sort(noP2);
        Collections.sort(noP3);
        Collections.sort(noDark);

        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> dark = new ArrayList<>();

        for (Integer i : noP1) {
            String card = pokerMap.get(i);
            player1.add(card);
        }
        for (Integer i : noP2) {
            String card = pokerMap.get(i);
            player2.add(card);
        }
        for (Integer i : noP3) {
            String card = pokerMap.get(i);
            player3.add(card);
        }
        for (Integer i : noDark) {
            String card = pokerMap.get(i);
            dark.add(card);
        }

        System.out.println("player1:"+player1);
        System.out.println("player2:"+player2);
        System.out.println("player3:"+player3);
        System.out.println("dark:"+dark);

    }
}
