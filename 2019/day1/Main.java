package day1;

import input.InputReader;
import timer.Timer;

import java.io.IOException;

public class Main {

    static final int DAY = 1;

    public static void main(String[] args) throws IOException {

        InputReader ir = new InputReader();
        Timer t = new Timer();
        t.start();

        int sumPart1 = 0, sumPart2 = 0;

        String[] input = ir.readFile("adventofcode\\2019\\input\\inputDay" + DAY + ".txt").split("\n");


        for(String s : input){
            int curr = Integer.parseInt(s);

            sumPart1 += (curr/3 - 2);

            while(true){
                curr = (curr/3) - 2;
                if(curr < 0) break;
                sumPart2 += curr;
            }

        }

        System.out.println("[Part 1] fuel required: " + sumPart1);
        System.out.println("[Part 2] fuel required: " + sumPart2);
        t.finish();
    }

}
