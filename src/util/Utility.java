package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Utility {

    public static List<String> readLine(String folder, Input input) throws IOException {
        String dir = System.getProperty("user.dir");
        String inputPath = String.format("%s/src/%s/%s", dir, folder, input.file);
        return Files.readAllLines(Paths.get(inputPath));
    }
}
