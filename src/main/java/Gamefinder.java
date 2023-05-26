import java.io.*;
import java.util.List;

public class Gamefinder {
    public static void main(String[] args) {
        //agregarJuego("Valorant", 2021, "Shooter", "RiotGames", Juego.F2P.Gratis);
        //agregarJuego("League of Leguends", 2013, "Moba", "Riot Games", Juego.F2P.Gratis);
        //agregarJuego("Call of Duty ",2022,"Shooter","Activision", Juego.F2P.Pago);
        leer("Gamefinder.txt");
        filtrarNombre("Valorant");
        filtraGenero("Moba");
        filtrarFreeToPlay(String.valueOf(Juego.F2P.Gratis));
    }

    private static void filtrarFreeToPlay(String free2Play) {
        try {
            try (BufferedReader br = new BufferedReader(new FileReader("Gamefinder.txt"))) {
                System.out.println("Juegos Free to Play");
                String linea;
                while ((linea = br.readLine()) != null) {
                    if(linea.contains(free2Play)){
                        System.out.println(linea);
                    }
                }
                System.out.println("");
            }
        }catch (Exception ignored){
            System.out.println("error");
        }
    }


    private static void filtraGenero(String genero) {
        try {
            try (BufferedReader br = new BufferedReader(new FileReader("Gamefinder.txt"))) {
                System.out.println("Juegos de genero: "+genero);
                String linea;
                while ((linea = br.readLine()) != null) {
                    if(linea.contains(genero)){
                        System.out.println(linea);
                    }
                }
                System.out.println("");
            }
        }catch (Exception ignored){
            System.out.println("error");
        }
    }

    private static void filtrarNombre(String nombre) {
            try {
                try (BufferedReader br = new BufferedReader(new FileReader("Gamefinder.txt"))) {
                    System.out.println("Caracteristicas de: "+nombre);
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        if(linea.contains(nombre)){
                            System.out.println(linea);
                        }
                    }
                    System.out.println("");
                }
        }catch (Exception ignored){
            System.out.println("error");
        }


    }

    private static void agregarJuego(String nombre, int año, String genero, String distribuidora, Juego.F2P freeTP) {
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
                for (int i = 0; i <1; i++) {
                    System.out.println(x);
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
}













