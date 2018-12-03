package day3;

import sun.awt.Symbol;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class Main {

    static Map<Integer, Integer> suit = new HashMap<>();



    public static void main(String[] args) throws IOException {
        String[] input = readFile("2018\\src\\day3\\inputDay3.txt").replaceAll("#", "").split("\n");

        for(int i = 0; i < 999999; i++){
            suit.put(i, 0);
        }


        for(String str : input){

            String[] claim = str.replace(":", "")
                                .replace("@", "")
                                .replaceAll("  ", " ")
                                .split(" ");

            int id = Integer.valueOf(claim[0]);

            String[] coord = claim[1].split(",");
            String[] size = claim[2].split("x");

            for(int i = 0; i < Integer.valueOf(size[0]); i++){
                for(int j = 0; j < Integer.valueOf(size[1]); j++){
                    int x = Integer.valueOf(coord[0]);
                    int y = Integer.valueOf(coord[1]);
                    int position = (x+i) + (y+j-1)*1000 - 1;
                    suit.replace(position, suit.get(position)+1);

                }
            }


        }

        int counter = 0;
        for(int i = 0; i < 999999; i++){
            if(suit.get(i) > 1) counter++;
        }

        System.out.println(counter);

    }



    static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded);
    }

}
