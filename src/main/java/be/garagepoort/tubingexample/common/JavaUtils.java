package be.garagepoort.tubingexample.common;

public class JavaUtils {

    public static String compileWords(String[] args, int index) {
        StringBuilder builder = new StringBuilder();

        for (int i = index; i < args.length; i++) {
            builder.append(args[i]).append(" ");
        }

        return builder.toString().trim();
    }
}