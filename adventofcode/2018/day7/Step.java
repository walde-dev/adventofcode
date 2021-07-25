package day7;

import java.util.*;

public class Step {

    String name;
    List<String> req = new ArrayList<>();

    static List<Step> list = new ArrayList<>();
    static List<String> done = new ArrayList<>();

    public Step(String name, String req) {
        boolean found = false;
        for(Step s : list){
            if(s.getName().equals(name)){
                s.getReq().add(req);
                found = true;
            }
        }
        if(!found){
            this.name = name;
            this.req.add(req);
            list.add(this);
        }

    }

    public String getName() {
        return name;
    }

    public List<String> getReq() {
        return req;
    }

    void execute(){
        done.add(this.getName());
        Day7.result = Day7.result+this.getName();
    }

    static void fill(){
        List<Integer> toFill = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            int counter = 0;
            for(int j = 0; j < list.size(); j++){
                if((int)list.get(j).getName().charAt(0) != (i+65)) counter++;
            }
            if(counter == 24){
                toFill.add(65+i);
            }
        }

        for(int i : toFill){
            new Step(String.valueOf((char) (i)), "");
        }

    }

    static class StepComparator implements Comparator<Step> {
        @Override
        public int compare(Step a, Step b){
            return a.getName().charAt(0) - b.getName().charAt(0);
        }
    }
}
