package part1.demo1;

import java.util.ArrayList;
import java.util.Collections;

public class Poker {
    public static void main(String[] args) {
        //1. prepare
        //1.1 create a poke box to put cards
        ArrayList<String> pokerBox = new ArrayList<>();
        //1.2 create a color list
        ArrayList<String> colors = new ArrayList<>();
        //1.3 create a number list
        ArrayList<String> numbers = new ArrayList<>();

        //1.4 add elements
        colors.add("♥");
        colors.add("♦");
        colors.add("♠");
        colors.add("♣");

        for (int i = 2; i <= 10; i++) {
            numbers.add(i + "");
        }
        numbers.add("J");
        numbers.add("Q");
        numbers.add("K");
        numbers.add("A");

        //1.5 create cards
        for (String color : colors) {
            for (String number : numbers) {
                String card = color + number;
                pokerBox.add(card);
            }
        }
        pokerBox.add("Red Joker");
        pokerBox.add("Black Joker");

        //2. shuffle the cards
        Collections.shuffle(pokerBox);
        //3. deal the cards
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> dark = new ArrayList<>();

        for(int i =0;i<pokerBox.size();i++){
            String card = pokerBox.get(i);
            if(i<51){
                if(i%3==0){
                    player1.add(card);
                }else if(i%3==1){
                    player2.add(card);
                }else{
                    player3.add(card);
                }
            }else{
                dark.add(card);
            }
        }

        //show
        System.out.println("player1:"+player1);
        System.out.println("player2:"+player2);
        System.out.println("player3:"+player3);
        System.out.println("dark:"+dark);
    }
}
