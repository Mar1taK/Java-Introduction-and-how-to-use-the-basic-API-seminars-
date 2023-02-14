package Homework2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
 
public class task {
    public static void main(String[] args) {
        String data = "";

        File file = new File("input.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while ((line = br.readLine()) != null) {
                data += line + " ";

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] array = data.replace("b ","").replace(" a", "").split(" ");
        int a = Integer.parseInt(array[1]);
        int b = Integer.parseInt(array[0]);

        double result = factor(a, b);

        try(FileWriter writer = new FileWriter("output.txt", true))
        {
           // запись всей строки
            String text = a + " in degree " + b + " = " + result + "\n";
            writer.write(text);

             
            writer.flush();
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 

    }

    static double factor(int a, int b) {
        double result = 1;
        if (a == 0) return 0;    
        if ((b % 2 == 0) && (b >= 0)) {
            for (int i = 0; i < b / 2; i++) {
                result *= a;
            }
            result *= result;
            return result;
        } else if ((b % 2 != 0) && (b > 0)) {
            b = b - 1;
            for (int i = 0; i < b / 2; i++) {
                result *= a;
            }
            result = (result * result) * a;
            return result;
        } else if (b < 0) {
            for (int i = 0; i > b; i--) {
                result *= a;
            }
            result = 1 / result;
            return result;
        }
        return 0;
    }
}