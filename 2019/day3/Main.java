package day3;

import input.InputReader;
import timer.Timer;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    static final int DAY = 3;




    public static void main(String[] args) throws IOException {

        InputReader ir = new InputReader();
        Timer t = new Timer();
        t.start();

        ArrayList<Point> matches = new ArrayList<>();

        Wire wire1 = new Wire();
        Wire wire2 = new Wire();

        String[] wire1Input = ir.readFile("adventofcode\\2019\\input\\inputDay" + DAY + ".txt").split("\n")[0].split(",");
        String[] wire2Input = ir.readFile("adventofcode\\2019\\input\\inputDay" + DAY + ".txt").split("\n")[1].split(",");


        for(String s : wire1Input){
            if(s.contains("U")){
                int distance = Integer.parseInt(s.replace("U",""));

                for(int i = 0; i < distance; i++){
                    Point temp = wire1.getCurrent().up(1);
                    wire1.visitedPoints.add(temp);
                    wire1.setCurrent(temp);
                }

            }else if(s.contains("R")){
                int distance = Integer.parseInt(s.replace("R",""));

                for(int i = 0; i < distance; i++){
                    Point temp = wire1.getCurrent().right(1);
                    wire1.visitedPoints.add(temp);
                    wire1.setCurrent(temp);
                }
            }else if(s.contains("D")){
                int distance = Integer.parseInt(s.replace("D",""));

                for(int i = 0; i < distance; i++){
                    Point temp = wire1.getCurrent().down(1);
                    wire1.visitedPoints.add(temp);
                    wire1.setCurrent(temp);
                }
            }else if(s.contains("L")){
                int distance = Integer.parseInt(s.replace("L",""));

                for(int i = 0; i < distance; i++){
                    Point temp = wire1.getCurrent().left(1);
                    wire1.visitedPoints.add(temp);
                    wire1.setCurrent(temp);
                }
            }
        }


        for(String s : wire2Input){
            if(s.contains("U")){
                int distance = Integer.parseInt(s.replace("U",""));

                for(int i = 0; i < distance; i++){
                    Point temp = wire2.getCurrent().up(1);
                    wire2.visitedPoints.add(temp);
                    wire2.setCurrent(temp);
                }

            }else if(s.contains("R")){
                int distance = Integer.parseInt(s.replace("R",""));

                for(int i = 0; i < distance; i++){
                    Point temp = wire2.getCurrent().right(1);
                    wire2.visitedPoints.add(temp);
                    wire2.setCurrent(temp);
                }
            }else if(s.contains("D")){
                int distance = Integer.parseInt(s.replace("D",""));

                for(int i = 0; i < distance; i++){
                    Point temp = wire2.getCurrent().down(1);
                    wire2.visitedPoints.add(temp);
                    wire2.setCurrent(temp);
                }
            }else if(s.contains("L")){
                int distance = Integer.parseInt(s.replace("L",""));

                for(int i = 0; i < distance; i++){
                    Point temp = wire2.getCurrent().left(1);
                    wire2.visitedPoints.add(temp);
                    wire2.setCurrent(temp);
                }
            }
        }

        for(int i = 0; i < wire1.visitedPoints.size(); i++){
            for(int j = 0; j < wire2.visitedPoints.size(); j++){
                if(wire1.visitedPoints.get(i).equals(wire2.visitedPoints.get(j))){
                    matches.add(wire1.visitedPoints.get(i));
                }
            }
        }

        Point lowest = new Point(9999999,9999999);
        for(Point p : matches){
            if(p.getDistanceToCenter() < lowest.getDistanceToCenter()){
                lowest = p;
            }
        }

        System.out.println("Closest intersaction at: " + lowest.toString());
        System.out.println("Solution: " + (Math.abs(lowest.getX())+Math.abs(lowest.getY())));

        t.finish();
    }



    static class Wire{

        ArrayList<Point> visitedPoints;
        Point current;

        public Wire() {
            this.visitedPoints = new ArrayList<>();
            current = new Point(0,0);
        }

        public Point getCurrent() {
            return current;
        }

        public void setCurrent(Point current) {
            this.current = current;
        }
    }

    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean equals(Point p){
            return (p.getX() == x && p.getY() == y);
        }

        public String toString(){
            return "X: " + x + " Y: " + y;
        }

        int getDistanceToCenter(){
            return Math.abs(x) + Math.abs(y);
        }

        Point left(int distance){
            return new Point(this.getX()-distance, this.getY());
        }

        Point right(int distance){
            return new Point(this.getX()+distance, this.getY());
        }

        Point up(int distance){
            return new Point(this.getX(), this.getY()+distance);
        }

        Point down(int distance){
            return new Point(this.getX(), this.getY()-distance);
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
