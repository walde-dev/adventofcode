package day6;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class Day6 {

    static HashMap<Integer, Point> points = new HashMap<>();

    public static void main(String[] args) throws IOException {
        String[] input = readFile("2018\\src\\day6\\inputDay6.txt").replace(" ","").split("\n");

        int counter = 0, xMax = 0, yMax = 0;

        for(String str : input){
            int x  = Integer.valueOf(str.split(",")[0]);
            int y  = Integer.valueOf(str.split(",")[1]);

            points.put(counter, new Point(x, y));
            counter++;

            if(x > xMax) xMax = x;
            if(y > yMax) yMax = y;


        }

        int[][] map = new int[xMax+1][yMax+1];


        for(int i = 0; i < xMax; i++){
            for(int j = 0; j < yMax; j++){

                int smallestDistance = 99999999;
                int bestPoint = 0;

                for(int k = 0; k < counter; k++){

                    Point p = points.get(k);

                    int distance = Math.abs(i-p.x) + Math.abs(j-p.y);

                    if(distance < smallestDistance) {
                        smallestDistance = distance;
                        bestPoint = k;
                    }else if( distance == smallestDistance){
                        bestPoint = -1;
                    }



                }

                map[i][j] = bestPoint;


            }
        }

        HashMap<Integer, Integer> size = new HashMap<>();

        for(int i = 0; i < counter; i++){
            int areaCounter = 0;
            for(int x = 0; x < xMax; x++){
                for(int  y = 0; y < yMax; y++){
                    if(map[x][y] == i) areaCounter++;
                }
            }
            size.put(i,areaCounter);
        }

        for (int x = 0; x <= xMax; x++) {
            size.remove(map[x][0]);
            size.remove(map[x][yMax]);
        }
        for (int y = 0; y <= yMax; y++) {
            size.remove(map[0][y]);
            size.remove(map[xMax][y]);
        }

        int best = 0;
        for(int i : size.values()){
            if (i > best){
                best = i;
            }


        }


        System.out.println("Highest Area: " + best);





    }


    static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded);
    }
}
