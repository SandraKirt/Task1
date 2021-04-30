import org.apache.commons.io.FileUtils;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String path;

        if (args.length==0 || args[0].isEmpty()) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter input file name with full path to it : ");
            path = input.nextLine();
        }else {

            path = args[0];
        }
        System.out.println("This is path to input text file " + path);

        try {
            File inputFile = new File(path);
            List<String>  lines = FileUtils.readLines(inputFile, StandardCharsets.UTF_8);

            String concatAll = concatAllTextLines(lines);
            System.out.println();
            System.out.println("1. All text lines are concatenated to one: " + concatAll);

            int sum = sumAllNumberLines(lines);
            System.out.println();
            System.out.println("2. Total is " + sum);

            int c = countEvenNumberLines(lines);
            System.out.println();
            System.out.println("3. The number of even numbers is " + c);
//
        } catch (java.io.IOException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }

    static String concatAllTextLines(List<String> lines){
        String concatString = "";
        for (int p = 0; p < lines.size(); p++) {
            if (!isInteger(lines.get(p))) {
                concatString += lines.get(p);
            }
        }
        return concatString;
    }

    static int sumAllNumberLines(List<String> lines){
        int sum = 0;
        for (int j = 0; j < lines.size(); j++) {
            if (isInteger(lines.get(j))) {
                sum += Integer.parseInt(lines.get(j));
            }
        }
        return sum;
    }

    static int countEvenNumberLines(List<String> lines){
        int c = 0;
        for (int n = 0; n < lines.size(); n++){
            if (isInteger(lines.get(n))) {
                if (Integer.parseInt(lines.get(n))%2 ==0) {
                    c++;
                }
            }
        }
        return c;
    }

    static boolean isInteger(Object object) {
        if(object instanceof Integer) {
            return true;
        } else {
            String string = object.toString();

            try {
                Integer.parseInt(string);
            } catch(Exception e) {
                return false;
            }
        }

        return true;
    }
}
