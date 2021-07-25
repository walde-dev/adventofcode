package timer;

public class Timer {

    long startTime = 0;

    public void start(){
        startTime = System.nanoTime();
    }

    public void finish(){
        System.out.print("Runtime: " + (System.nanoTime()-startTime) / 1000000 + "ms");
    }

}
