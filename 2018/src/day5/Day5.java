package day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day5 {

    public static void main(String[] args) throws IOException {
        String input = readFile("2018\\src\\day5\\inputDay5.txt").replace(" ", "").replace("\n", "").replace("\r", "");
        for(int i = 0; i < input.length(); i++){
            if(input.length()==2){
                char c = input.charAt(0);
                char n = input.charAt(1);
                if(canReact(c,n)){
                    input = "";
                    i = 0;
                    continue;
                }
            }
            if(i == input.length()-1){
                continue;
            }
            char c = input.charAt(i);
            char n = input.charAt(i+1);
                if(canReact(c,n)){
                    input = new StringBuilder(input).delete(i,i+2).toString();
                    i = 0;
                }
            }
        System.out.println("Part 1: " + (input.length()-2));



        int[] values = new int[26];

        for(int i = 0; i < 26; i++) {
            String temp = input.replace(Character.toString((char) (65 + i)), "").replace(Character.toString((char) (97 + i)), "");
            for (int j = 0; j < temp.length(); j++) {
                if (temp.length() == 2) {
                    char c = temp.charAt(0);
                    char n = temp.charAt(1);
                    if (canReact(c, n)) {
                        temp = "";
                        j = 0;
                        continue;
                    }
                }
                if (j == temp.length() - 1) {
                    continue;
                }
                char c = temp.charAt(j);
                char n = temp.charAt(j + 1);
                if (canReact(c, n)) {
                    temp = new StringBuilder(temp).delete(j, j + 2).toString();
                    j = 0;
                }
            }

            values[i] = temp.length();


        }


        int temp = 999999999, letter = 0;
        for(int i = 0; i < values.length; i++){
            if(values[i] < temp){
                temp = values[i];
                letter = 65+i;
            }
        }

        System.out.println("Removing " + Character.toString((char) (letter)) + " procudes the best result of " + temp);

    }


    static boolean canReact(char a, char b){
        char tempA = Character.toLowerCase(a);
        char tempB = Character.toLowerCase(b);
        return tempA == tempB && ((Character.isUpperCase(a) && !Character.isUpperCase(b))||((!Character.isUpperCase(a) && Character.isUpperCase(b))));
    }


    static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded);
    }

}
