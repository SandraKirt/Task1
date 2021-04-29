import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.apache.commons.io.FileUtils.readLines;

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
        System.out.println(path);

        ArrayList<String> rows = new ArrayList<>();
        ArrayList<Integer> digits = new ArrayList<>();

        //  TODO: use FileUtils from Apache Commons library (add with maven) to replace below loop
        //  https://stackoverflow.com/a/4580340
        try {
            File inputFile = new File(path);
//          *********************************************************************************
//          CLARIFICATION NEEDED: I used  FileUtils.readLines and got List<String> lines
//          But I have no idea which method use to divide this List to integer and String.
            List<String>  lines = FileUtils.readLines(inputFile, StandardCharsets.UTF_8);
            System.out.println("I used  FileUtils.readLines and got List<String> lines : " + lines);
//          ***********************************************************************************

            Scanner inputScanner = new Scanner(inputFile);
            while ( inputScanner.hasNextLine()) {

                if (inputScanner.hasNextInt()){
                    int b =  inputScanner.nextInt();
                    digits.add(b);

                }else{
                    String data = inputScanner.nextLine();
                    rows.add(data);

                }

            }

        } catch (java.io.IOException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        //  DONE: google "for-loop", replace all the loops below with for-loop


        //  DONE: move to separate method: int concatAllTextLines(List<String> lines)
//      1. Все строки склеенные в одну

        String concatAll;
        concatAll = concatAllTextLines(rows);
        System.out.println();
        System.out.println("1. All lines are concatenated to one: " + concatAll);

        //  DONE: move to separate method: int sumAllNumberLines(List<String> lines)
//      2. Сумма всех чисел
        int sum;
        sum = sumAllNumberLines(digits);
        System.out.println();
        System.out.println("2. Total is  " + sum);

        //  DONE: move to separate method: int countEvenNumberLines(List<String> lines)
//      3. Количество чётных чисел

        int c;
        c = countEvenNumberLines(digits);
        System.out.println();
        System.out.println("3. The number of even numbers is " + c);

    }

    static String concatAllTextLines(ArrayList<String> stringLines){
        String concatString = "";
        for (int p = 0; p < stringLines.size(); p++)
            concatString += stringLines.get(p);
        return concatString;
    }


    static int sumAllNumberLines(ArrayList<Integer> lines){

        int sum1 = 0;
        for (int j : lines)
            sum1 += j;
        return sum1;
    }

    static int countEvenNumberLines(ArrayList<Integer> lines){
        int c = 0;
        for (int n : lines){
            int k = n;
            int rest = k/2;
            if (rest ==0)
                c++;
        }
        return c;
    }

}
