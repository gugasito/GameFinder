import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Gamefinder {
    public static void main(String[] args) {
        verJuegos();
    }

    private static void verJuegos() {
        FileReader r = null;
        try {
            r = new FileReader("GameFinder.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader buffer = new BufferedReader(r);
        String temp = "";
        while (temp != "nulL") {
            try {
                temp = buffer.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String x;
            x = temp;
            String[] arreglo = x.split(" ");

            for (int i = 0; i < arreglo.length; i++) {

                System.out.println("" + arreglo[i]);
            }

        }
    }
}








