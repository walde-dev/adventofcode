package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    static String input;

    public static void main(String[] args) throws IOException {
        input = readFile("");

    }















    static String readFile(String path)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded);
    }

}
