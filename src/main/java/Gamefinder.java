import modelo.Juego;
import modelo.Usuario;

import java.io.*;
import java.util.Scanner;

public class Gamefinder {
    public static void main(String[] args) {
        //agregarJuego("Valorant", 2021, "Shooter", "Riot_Games", modelo.Juego.F2P.Gratis);
        //agregarJuego("League_of_Leguends", 2013, "Moba", "Riot_Games", modelo.Juego.F2P.Gratis);
        //agregarJuego("Call of Duty ",2022,"Shooter","Activision", modelo.Juego.F2P.Pago);
        filtrarNombre("Valorant");
        filtraGenero("Moba");
        filtrarFreeToPlay(String.valueOf(Juego.F2P.Gratis));
        borrarJuego("Gamefinder.txt", "Valorant");
        //agregarUsuario("Benja", modelo.Usuario.Rol.Administrador);
        //agregarUsuario("Guga", modelo.Usuario.Rol.Administrador);
        //agregarUsuario("Diego", modelo.Usuario.Rol.modelo.Usuario);
        //agregarUsuario("Samuel", modelo.Usuario.Rol.Administrador);
        leer("Gamefinder.txt");
        buscarPorAño("2021");
        leerAdiministrador("Administrador");
    }

    // CAMBIAR ENCAPSULAMIENTO MÉTODOS!!!!

    private static void filtrarFreeToPlay(String free2Play) {
        try {
            try (BufferedReader br = new BufferedReader(new FileReader("Gamefinder.txt"))) {
                System.out.println("Juegos Free to Play");
                String linea;
                while ((linea = br.readLine()) != null) {
                    if (linea.contains(free2Play)) {
                        System.out.println(linea);
                    }
                }
                System.out.println("");
            }
        } catch (Exception ignored) {
            System.out.println("error");
        }
    }


    private static void filtraGenero(String genero) {
        try {
            try (BufferedReader br = new BufferedReader(new FileReader("Gamefinder.txt"))) {
                System.out.println("Juegos de genero: " + genero);
                String linea;
                while ((linea = br.readLine()) != null) {
                    if (linea.contains(genero)) {
                        System.out.println(linea);
                    }
                }
                System.out.println("");
            }
        } catch (Exception ignored) {
            System.out.println("error");
        }
    }

    private static void filtrarNombre(String nombre) {
        try {
            try (BufferedReader br = new BufferedReader(new FileReader("Gamefinder.txt"))) {
                System.out.println("Caracteristicas de: " + nombre);
                String linea;
                while ((linea = br.readLine()) != null) {
                    if (linea.contains(nombre)) {
                        System.out.println(linea);
                    }
                }
                System.out.println("");
            }
        } catch (Exception ignored) {
            System.out.println("error");
        }
    }

    private static void agregarJuego(String nombre, int año, String genero, String distribuidora, Juego.F2P freeTP) {
        Juego newGame = new Juego(nombre, año, genero, distribuidora, freeTP);
        try {
            FileWriter archivo = new FileWriter("GameFinder.txt", true);
            try (BufferedWriter bw = new BufferedWriter(archivo)) {
                bw.write(newGame.getNombre() + " " + newGame.getAño() + " " + newGame.getGenero() + " " + newGame.getDistribuidora() + " " + newGame.isFreeTP() + "\n");
            }
            archivo.close();
        } catch (Exception ignored) {
        }
    }

    private static void agregarUsuario(String nombre, Usuario.Rol rol) {
        Usuario newUsuario = new Usuario(nombre, rol);
        try {
            FileWriter archivo = new FileWriter("GameFinderUsuarios.txt.txt", true);
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
                for (int i = 0; i < 1; i++) {
                    System.out.println(x);
                }
                if (temp == null)
                    break;
            }
        } catch (Exception e) {
            System.out.println();
        }
    }

    public static void buscarPorAño(String año) {
        try {
            try (BufferedReader br = new BufferedReader(new FileReader("Gamefinder.txt"))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    if (linea.contains(año)) {
                        System.out.println(linea);
                    }
                }
            }
        } catch (Exception ignored) {
            System.out.println("error");
        }
    }

    public static void leerAdiministrador(String rol) {
        try {
            try (BufferedReader br = new BufferedReader(new FileReader("GamefinderUsuarios.txt"))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    if (linea.contains(rol)) {
                        System.out.println(linea);
                    }
                }
            }
        } catch (Exception ignored) {
            System.out.println("error");
        }
    }

    private static void filtrarDistribuidora(String distribuidora) {
        try {
            try (BufferedReader br = new BufferedReader(new FileReader("Gamefinder.txt"))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    if (linea.contains(distribuidora)) {
                        System.out.println(linea);
                    }
                }
                System.out.println("");
            }
        } catch (Exception ignored) {
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
            System.out.println("(1) Ingresar Datos");
            System.out.println("(2) Mostar juegos por año de lanzamiento");
            System.out.println("(3) Mostrar juegos por genero");
            System.out.println("(4) Mostrar juegos por distribuidora");
            System.out.println("(5) Salir");
            int opcion = intro.nextInt();
            switch (opcion) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                default:
                    System.out.println("La opcion escogida no es valida, seleccione una nuevamente");
            }
        } while (seguir);
    }

    public static void borrarJuego(String nombreArchivo, String nombreJuego) {
        try {
            File inFile = new File(nombreArchivo);
            if (!inFile.isFile()) {
                System.out.println("no hay file");
                return;
            }
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
            String line = null;
            while ((line = br.readLine()) != null) {

                if (!line.trim().contains(nombreJuego)) {

                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}




