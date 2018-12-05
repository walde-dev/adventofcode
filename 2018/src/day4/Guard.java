package day4;

import java.util.HashMap;
import java.util.Map;

public class Guard{

    int id, minutesAsleep;

    static Map<Integer, Integer> minutes = new HashMap<>();



    public Guard(int id, int minutesAsleep) {
        this.id = id;
        this.minutesAsleep = minutesAsleep;
        Main.list.add(this);
        for(int i = 0; i < 60; i++){
            minutes.put(i,0);
        }
    }

    void sleep(int minute){
        this.minutesAsleep += minute;
    }

    void addMinute(int minute){
        minutes.replace(minute, minutes.get(minute)+1);
    }

    int[] getHighestMinute(){
        int[] temp = new int[2];
        for(int i = 0; i < minutes.size(); i++){
            if(temp[0] < minutes.get(i)){
                temp[0] = minutes.get(i);
                temp[1] = i;
            }
        }
        return temp;
    }

    int getHighestAsleep(){

        int temp = 0;
        for(int i  = 0; i < minutes.size(); i++){
            if(temp < minutes.get(i)) temp = minutes.get(i);
        }
        for(int i  = 0; i < minutes.size(); i++){
            if(minutes.get(i) == temp) return i-1;
        }
        return -1;
    }

    int getId(){
        return this.id;
    }

    public int getMinutesAsleep() {
        return minutesAsleep;
    }
}