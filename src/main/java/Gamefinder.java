import java.io.*;
import java.util.List;

public class Gamefinder {
    public static void main(String[] args) {
        agregarJuego("Valorant", 2021, "Shooter", "RiotGames", true);
        agregarJuego("League of Leguends", 2013, "Moba", "Riot Games", true);
        agregarUsuario("Benja", Usuario.Rol.Administrador);
        agregarUsuario("Guga", Usuario.Rol.Administrador);
        agregarUsuario("Diego", Usuario.Rol.Usuario);
        agregarUsuario("Samuel", Usuario.Rol.Administrador);
        leer("Gamefinder.txt");
        buscarPorAño("2021");
        leerAdiministrador("Administrador");
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
    private static void agregarUsuario(String nombre, Usuario.Rol rol) {
        Usuario newUsuario = new Usuario(nombre, rol);
        try {
            FileWriter archivo = new FileWriter("GameFinderUsuarios.txt", true);
            try (BufferedWriter bw = new BufferedWriter(archivo)) {
                bw.write("\n" + newUsuario.getNombre() + " " + newUsuario.isRol());
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
    public static void buscarPorAño(String año){
        try{
            try (BufferedReader br = new BufferedReader(new FileReader("Gamefinder.txt"))){
                String linea;
                while ((linea = br.readLine()) != null){
                    if(linea.contains(año)){
                        System.out.println(linea);
                    }
                }
            }
        }catch (Exception ignored){
            System.out.println("error");
        }
    }
    public static void leerAdiministrador(String rol){
        try{
            try (BufferedReader br = new BufferedReader(new FileReader("GamefinderUsuarios.txt"))){
                String linea;
                while ((linea = br.readLine()) != null){
                    if(linea.contains(rol)){
                        System.out.println(linea);
                    }
                }
            }
        }catch (Exception ignored){
            System.out.println("error");
        }
    }


    public static void borrarJuego() {

    }
}













