import java.io.*;

public class Gamefinder {
    public static void main(String[] args) {
        //agregarJuego("Valorant", 2021, "Shooter", "Riot_Games", Juego.F2P.Gratis);
        //agregarJuego("League_of_Leguends", 2013, "Moba", "Riot_Games", Juego.F2P.Gratis);
        //agregarJuego("Call of Duty ",2022,"Shooter","Activision", Juego.F2P.Pago);
        filtrarNombre("Valorant");
        filtraGenero("Moba");
        filtrarFreeToPlay(String.valueOf(Juego.F2P.Gratis));
        borrarJuego("Gamefinder.txt", "Valorant");
        leer("Gamefinder.txt");
    }

    // CAMBIAR ENCAPSULAMIENTO MÉTODOS

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
                bw.write(newGame.getNombre() + " " + newGame.getAño() + " " + newGame.getGenero() + " " + newGame.getDistribuidora() + " " + newGame.isFreeTP() + "\n");
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

    public static boolean grabar(String[] datos) {
        try {
            FileWriter archivo = new FileWriter("GameFinder.txt", true);
            try (BufferedWriter bw = new BufferedWriter(archivo)) {
                for (int i = 0; i < datos.length; i++) {
                    bw.write(datos[0] + " " + datos[1] + " " + datos[2] + " " + datos[3] + " " + datos[4] + "\n");
                }
                bw.close();
            }
            archivo.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void borrarJuego(String nombrearchivo, String lineToRemove) {
        try {

            File inFile = new File(nombrearchivo);

            if (!inFile.isFile()) {
                System.out.println("no hay file");
                return;
            }

            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

            BufferedReader br = new BufferedReader(new FileReader(nombrearchivo));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            //Read from the original file and write to the new
            //unless content matches data to be removed.
            while ((line = br.readLine()) != null) {

                if (!line.trim().contains(lineToRemove)) {

                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();

            //Delete the original file
            if (!inFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }

            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile)) {
                System.out.println("Could not rename file");

            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}




