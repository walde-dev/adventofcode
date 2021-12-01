package day2;

import input.InputReader;
import timer.Timer;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    static final int DAY = 2;

    public static void main(String[] args) throws IOException {

        InputReader ir = new InputReader();
        Timer t = new Timer();
        t.start();

        String[] inputRaw = ir.readFile("adventofcode\\2019\\input\\inputDay" + DAY + ".txt").replaceAll("\n", "").split(",");
        int[] input = new int[inputRaw.length];

        // String[] -> int[]
        for(int i = 0; i < inputRaw.length; i++){
            input[i] = Integer.parseInt(inputRaw[i]);
        }

        boolean found = false;
        int noun = 0, verb = 0;

        // reset state for day 1
        // input[1] = 12;
        // input[2] = 2;

        int[] clean = Arrays.copyOf(input, input.length);

        for(int j = 0; j < 99; j++) {
            for(int h = 0; h < 99; h++) {
                boolean halting = false;
                input = Arrays.copyOf(clean, clean.length);


                // test noun and verb for day2
                input[1] = j;
                input[2] = h;

                //execute intcodes
                for (int i = 0; i < input.length; i += 4) {

                    if(input[i] == 1){
                        input[input[i + 3]] = input[input[i + 1]] + input[input[i + 2]];
                    }else if(input [i] == 2){
                        input[input[i + 3]] = input[input[i + 1]] * input[input[i + 2]];
                    }else if (input [i] == 99){
                        halting = true;
                    }

                    if (halting) break;
                }

                if(input[0] == 19690720){
                    found = true;
                    noun = j;
                    verb = h;
                }
                if(found) break;

            }
            if(found) break;
        }

        System.out.println("Integer at position [0]: " + input[0]);
        System.out.println("[Part 2] solution is: 100 * " + noun + " + " + verb + " = " + (100*noun+verb));

        t.finish();
    }
}
