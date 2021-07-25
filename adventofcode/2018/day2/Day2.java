package day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;

public class Day2 {

    static final int day = 2;

    public static void main(String[] args) throws IOException {
        long kek = System.nanoTime();
        String[] input = readFile("2018\\src\\input\\inputDay" + day + ".txt").split("\n");

        int doubles = 0, triples = 0;

        for(int i = 0; i < input.length; i++){
            for(int j = 0; j < input.length; j++){
                if(i==j) continue;
                int nonSharedChars = 0;
                for(int k = 0; k < input[0].length(); k++){
                    if(input[i].charAt(k) != input[j].charAt(k)){
                        nonSharedChars++;
                    }
                }
                if(nonSharedChars <= 1) System.out.println(input[i] + "  " + input[j]);

            }
        }



        for(String str : input){



            int tripleCounter = 0, doubleCounter = 0;
            for(int i = 0; i < str.length(); i++){
                int temp = countMatches(str, str.substring(i, i+1));
                if(temp == 3 && tripleCounter == 0){
                    tripleCounter++;
                    triples++;
                    str = str.replaceAll(str.substring(i,i+1), "");
                    continue;
                }
                if(temp == 2 && doubleCounter == 0){
                    doubleCounter++;
                    doubles++;
                    str = str.replaceAll(str.substring(i,i+1), "");
                }
            }


        }

        System.out.println("Checksum: " + doubles + " * " + triples + " = " + doubles*triples);
        System.out.println("Runtime: " + (System.nanoTime()-kek)/1000000 + "ms");




    }

    static int countMatches(String str, String sub) {
                  int count = 0, idx = 0;
                  while ((idx = str.indexOf(sub, idx)) != -1) {
                           count++;
                           idx += sub.length();
                        }
                   return count;
    }


    static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded);
    }
}
