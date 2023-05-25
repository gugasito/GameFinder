import java.io.*;
import java.util.List;

public class Gamefinder {
    public static void main(String[] args) {
        leer("GameFinder.txt");
        agregarJuego();
        leer("Gamefinder.txt");
    }

    private static void agregarJuego() {
        Juego newGame = new Juego("Valorant", 2021, "fps", "RiotGames", true);
        try {
            FileWriter archivo = new FileWriter("GameFinder.txt", true);
            try (BufferedWriter bw = new BufferedWriter(archivo)) {
                bw.write("\n" + newGame.getNombre() + " " + newGame.getAño() + " " + newGame.getGenero() + " " + newGame.getDistribuidora() + " " + newGame.isFreeTP());
            }
            archivo.close();
        } catch (Exception ignored) {
        }

    }


    public static void leer(String nombrearchivo) {
        try {

            FileReader r = new FileReader(nombrearchivo);
            BufferedReader buffer = new BufferedReader(r);

            String temp = "";

            while (temp != null) {

                temp = buffer.readLine();
                String x;
                x = temp;
                String[] arreglo = x.split(" ");
                for (int i = 0; i < arreglo.length; i++) {
                    System.out.println("" + arreglo[i]);
                }
                if (temp == null)
                    break;
            }
        } catch (Exception e) {
            System.out.println();
        }
    }

    public static boolean grabar(List<Juego> Datos) {
        try {
            FileWriter archivo = new FileWriter("GameFinder.txt", true);
            try (BufferedWriter bw = new BufferedWriter(archivo)) {
                for (Juego dato : Datos) {
                    bw.write(dato + "\n");
                }
                bw.close();
            }
            archivo.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }


}













