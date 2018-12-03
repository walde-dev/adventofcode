package day3;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {

    static int[][] suit = new int[1000][1000];



    public static void main(String[] args) throws IOException {
        String[] input = readFile("2018\\src\\day3\\inputDay3.txt").replaceAll("#", "").split("\n");

        long start = System.nanoTime();




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
                    suit[x+i][y+j] = suit[x+i][y+j]+1;

                }
            }


        }


        for(String str : input){

            int counter = 0;

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
                    if(suit[x+i][y+j] == 1) counter++;
                }
            }

            if(counter == Integer.valueOf(size[0])*Integer.valueOf(size[1])) System.out.println(id);

        }




        int counter = 0;
        for(int i = 0; i < 1000; i++){
            for(int j = 0; j < 1000; j++){
                if(suit[i][j] > 1) counter++;
            }
        }

        System.out.println(counter);
        System.out.println("Runtime: " + (System.nanoTime()-start) / 1000000 + "ms");

    }



    static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded);
    }

}
