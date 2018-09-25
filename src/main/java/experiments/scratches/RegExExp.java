package experiments.scratches;

import java.util.regex.Pattern;

public class RegExExp {

    public static void main(String[] args) {

        String pattern = "Driver will get your package by ([0-2][1-9]):[0-5][0-9](\\s)?(?i)(AM|PM)";
        String targetStr = "Driver will get your package by 12:30 PM";
        String another = "Driver will get your package by 12:60 PM";

        System.out.println(another.matches(pattern));
    }
}