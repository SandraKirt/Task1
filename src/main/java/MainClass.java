import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

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

        try {
            File inputFile = new File(path);
            Scanner inputScanner = new Scanner(inputFile);
            int i = 0;

            while ( inputScanner.hasNextLine()) {

                if (inputScanner.hasNextInt()){
                    int b =  inputScanner.nextInt();
                    digits.add(b);

                }else{
                    String data = inputScanner.nextLine();
                    rows.add(data);

                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

//      1. Все строки склеенные в одну
//        System.out.println(rows.size());

        String concatAll = "";

        for (int k = 0;k < rows.size();k++)
        {
            concatAll += rows.get(k);
        }
        System.out.println();
        System.out.println("1. All lines are concatenated to one: " + concatAll);

//      2. Сумма всех чисел
        int sum = 0;

        for (int j=0;j < digits.size();j++)
        {
            sum += digits.get(j);
        }
        System.out.println();
        System.out.println("2. Total is  " + sum);

//      3. Количество чётных чисел
        int n = 0;
        int c = 0;
        while(n < digits.size()){
            int k = digits.get(n);
            int rest = k%2;
            n++;
            if (rest==0)
            {
                c++;
            }
        }
        System.out.println();
        System.out.println("3. The number of even numbers is " + c);

    }
}
