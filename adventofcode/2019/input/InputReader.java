package input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InputReader {

    public String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded);
    }

}
