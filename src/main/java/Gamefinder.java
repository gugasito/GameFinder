import java.io.*;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Gamefinder {
    public static void main(String[] args) {
        agregarJuego("Valorant", 2021, "Shooter", "RiotGames", true);
        agregarJuego("League of Leguends", 2013, "Moba", "RiotGames", true);
        leer("Gamefinder.txt");
    }

    private static void agregarJuego(String nombre, int año, String genero, String distribuidora, boolean freeTP) {
        Juego newGame = new Juego(nombre, año, genero, distribuidora, freeTP);
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

    public static void borrarJuego() {

    }

    private static void filtrarDistribuidora(String distribuidora) {
        try {
            try (BufferedReader br = new BufferedReader(new FileReader("Gamefinder.txt"))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    if(linea.contains(distribuidora)){
                        System.out.println(linea);
                    }
                }
                System.out.println("");
            }
        }catch (Exception ignored){
            System.out.println("error");
        }
    }


    public static void introduccion() {
        double[][] game_finder = new double[10][7];
        menu(game_finder);
    }

    public static void menu(double[][] game_finder) {
        boolean seguir = true;
        Scanner intro = new Scanner(System.in); //metodo de menu
        do {
            System.out.println("Bienvenido al menu GameFinder, por favor,  ingrese su opcion");
            System.out.println("(1) Ingresar Datos”);
                    System.out.println("(2) Mostar juegos por año de lanzamiento“);
                            System.out.println("(3) Mostrar juegos por genero”);
                                    System.out.println("(4) Mostrar juegos por distribuidora”);
                                            System.out.println("(5) Salir");
            int opcion = intro.nextInt();
            switch (opcion) {
                case 1:
                    llenarArreglo(game_finder);
                    break;
                case 2:
                    buscarJuegosPorAñoLanzamiento(game_finder);
                    break;
                case 3:
                    buscarJuegosPorGenero(game_finder);
                    break;
                case 4:
                    buscarJuegosPorDistribuidora(game_finder);
                    break;
                case 5:
                    salir();
                    break;
                default:

                    System.out.println("La opcion escogida no es valida, seleccione una nuevamente");
            }
        } while (seguir);
    }

}















