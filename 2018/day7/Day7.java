package day7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;

public class Day7 {

    static final int day = 7;
    static String result = "";

    public static void main(String[] args) throws IOException {
        String[] input = readFile("2018\\src\\input\\inputDay" + day + ".txt").split("\n");



        for(String str : input){
            String[] rule = {str.substring(5,6), str.substring(36,37)};

            new Step(rule[1],rule[0]);
        }

        Step.fill();
        Collections.sort(Step.list, new Step.StepComparator());

        int k = 0;
        int counter = 0;
        System.out.println(Step.list.size());
        while(k != 1){
            System.out.println(k);
            for(int j = 0; j < Step.list.size(); j++){
                System.out.println("kek");

                if(Step.list.get(j).getReq().contains("")){
                    Step.list.get(j).execute();
                    Step.list.get(j).getReq().remove("");
                    j = 0;
                }
                for(int i = 0; i < Step.list.get(j).getReq().size(); i++){
                    if(Step.done.contains(Step.list.get(j).getName())) continue;

                    if(Step.done.contains(Step.list.get(j).getReq().get(i))) counter++;
                }
                if(counter == Step.list.get(j).getReq().size()){
                    Step.list.get(j).execute();
                    j = 0;
                }
            }
            k++;
        }



        System.out.println("Result " + result);


    }


    static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded);
    }

}
