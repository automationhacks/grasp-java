package utils;

import java.io.InputStream;
import java.util.Scanner;

public class FileUtils {
    public static void main(String[] args) {
        // This code requires weather.json to be in the resources folder of either main/test
        // depending on which package this util is present at
        // TODO: Find out how to read a file in test resources from a file present in main
        // Hint: Probably using absolute paths and below link to find the absolute url may work
        // https://www.baeldung.com/junit-src-test-resources-directory-path#classloader

        String filePath = "weather/weather.json";
        InputStream is = FileUtils.class.getClassLoader().getResourceAsStream(filePath);

        Scanner scanner;
        StringBuilder sb = new StringBuilder();
        if (is != null) {
            scanner = new Scanner(is);
            while (scanner.hasNext()) {
                sb.append(scanner.next());
            }
            System.out.println(sb);
        }

        System.out.println();
    }
}
