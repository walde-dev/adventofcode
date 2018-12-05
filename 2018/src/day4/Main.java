package day4;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static ArrayList<Guard> list = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        String[] input = readFile("2018\\src\\day4\\inputDay4.txt").split("\n");

        input = sort(input);



        Guard curr = new Guard(-1,0);
        double sleep = 0;
        int sleepMinute = 0;
        for(String str : input){
            String[] note = str.replace("[", "").replace("]", "").split(" ");

            if(note[2].charAt(0) == 'G'){
                curr = find(Integer.valueOf(note[3].replace("#", "")));
            }else if(note[2].charAt(0) == 'f'){
                sleep = convertToInt(str);
                sleepMinute = Integer.valueOf(note[1].split(":")[1]);
            }else if(note[2].charAt(0) == 'w'){

                for(int i = 0; i < Integer.valueOf(note[1].split(":")[1]) - sleepMinute; i++){
                    curr.addMinute(sleepMinute+i);
                }

                curr.sleep((int) (convertToInt(str)-sleep) / 60);
            }






        }

        Guard temp = curr;
        for(int i = 0; i < list.size();i++){

           if(i == 0) temp = list.get(0);
           if(list.get(i).getMinutesAsleep() > temp.getMinutesAsleep()){
               temp = list.get(i);
           }
        }
        System.out.println("Most asleep: " + temp.getId() + " with " + temp.getMinutesAsleep() + " minutes asleep");
        System.out.println("Most asleep during minute " + temp.getHighestAsleep());
        System.out.println("Part 1: " + temp.getId()*temp.getHighestAsleep());

        Guard tempG = curr;
        int highestAsleep = 0;
        for(int i = 0; i < list.size(); i++){
            if(highestAsleep < list.get(i).getHighestMinute()[0]){
                highestAsleep = list.get(i).getHighestMinute()[0];
                tempG = list.get(i);
                System.out.println(tempG.getId());
            }

        }

        System.out.println("Most asleep on a single minute: Guard " + tempG.getId() + " on minute " + tempG.getHighestMinute()[1]);
        System.out.println("Part 2: " + tempG.getId()*tempG.getHighestMinute()[1]);

    }






    static Guard find(int id){
        for(Guard g : list){
            if(g.getId() == id) return g;
        }
        return new Guard(id, 0);
    }


    static String[] sort(String[] strA){
        boolean isSorted = false;
        while(!isSorted){
            int counter = 0;
            for(int i = 0; i < strA.length; i++){
                double curr, temp;
                if(i == strA.length-1){
                    curr = convertToInt(strA[i-1]);
                    temp = convertToInt(strA[i]);
                }else{
                    curr = convertToInt(strA[i]);
                    temp = convertToInt(strA[i+1]);
                }

                if(curr > temp){
                    String tempS = strA[i];
                    strA[i] = strA[i+1];
                    strA[i+1] = tempS;
                }else{
                    counter++;
                }
            }
            if(counter == strA.length) isSorted=true;
        }
        return strA;
    }

    static double convertToInt(String timestamp){
        String[] str = timestamp.replace("[", "").replace("]", "").split(" ");
        String[] date = str[0].split("-");
        String[] time = str[1].split(":");

        return Integer.valueOf(date[1])*2.628e+6 + Integer.valueOf(date[2])*86400 + Integer.valueOf(time[0])*3600 + Integer.valueOf(time[1])*60;
    }

    static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded);
    }
}
