package modelo.datos;

import modelo.Usuario;

import java.io.*;
import java.util.ArrayList;

/**
 * @author Diego Marillan
 * @version 6 de julio
 */

public class GestorArchivos {

    /**
     * Este metodo lee las líneas del archivo
     * @param rutaArchivo Ubicacion del archivo
     * @return Cantidad de líneas escritas en el archivo
     */
    public static int contarLineas(String rutaArchivo) {
        int contador = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            while (br.readLine() != null) {
                contador++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contador + 1;
    }

    /**
     * Metodo para registrar los datos de los objetos
     * @param objeto Datos del objeto a registrar
     * @param direccionArchivo La ubicacion del archivo
     */
    public static void registrarDato(Object objeto, String direccionArchivo) {
        try {
            File file = new File(direccionArchivo);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(objeto.toString());
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    /**
     * Metodo que lee los nombres de los usuarios administradores
     * @param direccionArchivo Ubicacion del archivo
     * @return La lista de usuarios
     */
    public static ArrayList<String> leerUsuarios(String direccionArchivo) {
        String textoArchivo = "";
        ArrayList<String> usuarios = new ArrayList<String>();
        try {
            File archivo = new File(direccionArchivo);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            while ((textoArchivo = br.readLine()) != null) {
                String[] data = textoArchivo.split(",");
                Usuario usuarioAdmin = new Usuario(data[0], data[1]);
                usuarios.add(usuarioAdmin.getNombre());
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Documento no disponible, favor contactar con administrador");
        }
        return usuarios;
    }

    /**
     * Metodo para leer las contraseñas en el archivo correspondiente
     * @param direccionArchivo La ubicacion del archivo
     * @return Una lista con las contraseña de los administradores
     */
    public static ArrayList<String> leerContraseñas(String direccionArchivo) {
        String textoArchivo = "";
        ArrayList<String> contraseñas = new ArrayList<>();
        try {
            File archivo = new File(direccionArchivo);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            while ((textoArchivo = br.readLine()) != null) {
                String[] data = textoArchivo.split(",");
                Usuario usuariooAdmin = new Usuario(data[0], data[1]);
                contraseñas.add(usuariooAdmin.getContraseña());
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("error");
            System.out.println("Documento no disponible, favor contactar con administrador");
        }
        return contraseñas;
    }

    /**
     * Metodo que elimina un juego de la lista
     * @param direccionArchivo La ubicacion del archivo
     * @param nombreJuego Nombre del juego a ser borrado
     */
    public static void borrarJuego(String direccionArchivo, String nombreJuego) {
        try {
            File archivo = new File(direccionArchivo);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            File temp = new File("temp.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                String trimmedLine = currentLine.trim().toLowerCase();
                if (trimmedLine.contains(nombreJuego.toLowerCase())) continue;
                bw.write(currentLine + System.getProperty("line.separator"));
            }
            bw.close();
            br.close();
            archivo.delete();
            temp.renameTo(archivo);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Documento no disponible, favor contactar con administrador");
        }
    }

    /**
     * Indica si el juego esta presente en el archivo o no
     * @param direccionArchivo La ubicacion del archivo
     * @param nombreJuego Nombre de videojuego a ser buscado
     * @return Respuesta respecto a la existencia del videojuego
     */

    public static boolean revisarJuegos(String direccionArchivo, String nombreJuego) {
        boolean juegoExiste = false;
        File archivo = null;
        FileReader Fr = null;
        BufferedReader br = null;
        String linea;
        String delimiter = ", ";
        try {
            archivo = new File("src/main/java/modelo/datos/GameFinder.txt");
            Fr = new FileReader(archivo.toString());
            br = new BufferedReader(Fr);
            while (((linea = br.readLine()) != null)) {
                String a[] = linea.split(delimiter);
                if (a[0].equalsIgnoreCase(nombreJuego)) {
                    juegoExiste = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != Fr) {
                    Fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return juegoExiste;
    }

    /**
     * Filtra juegos por nombre y si es gratis o pago
     * @param nombre Nombre del juego a encontrar
     * @param precio Se refiere si el juego es gratis o pago
     * @return Juegos que cumplen los requisitos
     */
    public static String[][] filtrarNombre(String nombre, String precio) {
        File archivo = null;
        FileReader Fr = null;
        BufferedReader br = null;
        String linea;
        String delimiter = ", ";
        String matriz[][] = new String[contarLineas("src/main/java/modelo/datos/GameFinder.txt")][5];
        int numlinea = 0;
        try {
            archivo = new File("src/main/java/modelo/datos/GameFinder.txt");
            Fr = new FileReader(archivo.toString());
            br = new BufferedReader(Fr);
            while (((linea = br.readLine()) != null)) {
                String a[] = linea.split(delimiter);
                if (a[0].equalsIgnoreCase(nombre) || nombre.equalsIgnoreCase("")) {
                    if (a[4].contains(precio)) {
                        matriz[numlinea][0] = a[0];
                        matriz[numlinea][1] = a[1];
                        matriz[numlinea][2] = a[2];
                        matriz[numlinea][3] = a[3];
                        matriz[numlinea][4] = a[4];
                        numlinea++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != Fr) {
                    Fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return matriz;
    }

    /**
     * Metodo que filtra juegos por año y si es gratis o no
     * @param año Año de lanzamiento del juego
     * @param precio Se refiere si el videojuego es gratis o pago
     * @return Juegos que cumplen los requisitos
     */
    public static String[][] filtrarAño(int año, String precio) {
        File archivo = null;
        FileReader Fr = null;
        BufferedReader br = null;
        String linea;
        String delimiter = ", ";
        String matriz[][] = new String[contarLineas("src/main/java/modelo/datos/GameFinder.txt")][5];
        int numlinea = 0;
        try {
            archivo = new File("src/main/java/modelo/datos/GameFinder.txt");
            Fr = new FileReader(archivo.toString());
            br = new BufferedReader(Fr);
            while (((linea = br.readLine()) != null)) {
                String a[] = linea.split(delimiter);
                if (a[1].equalsIgnoreCase(String.valueOf(año))) {
                    if (a[4].contains(precio)) {
                        matriz[numlinea][0] = a[0];
                        matriz[numlinea][1] = a[1];
                        matriz[numlinea][2] = a[2];
                        matriz[numlinea][3] = a[3];
                        matriz[numlinea][4] = a[4];
                        numlinea++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != Fr) {
                    Fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return matriz;
    }

    /**
     * Filtra y muestra juegos por genero y precio
     * @param genero Genero de videojuego a buscar
     * @param precio Se refiere si el juego gratis o pago
     * @return Juegos que cumplen los requisitos
     */

    public static String[][] filtrarGenero(String genero, String precio) {
        File archivo = null;
        FileReader Fr = null;
        BufferedReader br = null;
        String linea;
        String delimiter = ", ";
        String matriz[][] = new String[contarLineas("src/main/java/modelo/datos/GameFinder.txt")][5];
        int numlinea = 0;
        try {
            archivo = new File("src/main/java/modelo/datos/GameFinder.txt");
            Fr = new FileReader(archivo.toString());
            br = new BufferedReader(Fr);
            while (((linea = br.readLine()) != null)) {
                String a[] = linea.split(delimiter);
                if (a[2].equalsIgnoreCase(genero) || genero.equalsIgnoreCase("")) {
                    if (a[4].contains(precio)) {
                        matriz[numlinea][0] = a[0];
                        matriz[numlinea][1] = a[1];
                        matriz[numlinea][2] = a[2];
                        matriz[numlinea][3] = a[3];
                        matriz[numlinea][4] = a[4];
                        numlinea++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != Fr) {
                    Fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return matriz;
    }

    /**
     * Metodo para filtrar juegos por desarrolladora
     * @param distribuidora Distribuidora de videojuego a filtrar
     * @param precio Se refiere si el juego es gratis o pago
     * @return Juegos que cumplen los requisitos
     */
    public static String[][] filtrarDistribuidora(String distribuidora, String precio) {
        File archivo = null;
        FileReader Fr = null;
        BufferedReader br = null;
        String linea;
        String delimiter = ", ";
        String matriz[][] = new String[contarLineas("src/main/java/modelo/datos/GameFinder.txt")][5];
        int numlinea = 0;
        try {
            archivo = new File("src/main/java/modelo/datos/GameFinder.txt");
            Fr = new FileReader(archivo.toString());
            br = new BufferedReader(Fr);
            while (((linea = br.readLine()) != null)) {
                String a[] = linea.split(delimiter);
                if (a[3].equalsIgnoreCase(distribuidora) || distribuidora.equalsIgnoreCase("")) {
                    if (a[4].contains(precio)) {
                        matriz[numlinea][0] = a[0];
                        matriz[numlinea][1] = a[1];
                        matriz[numlinea][2] = a[2];
                        matriz[numlinea][3] = a[3];
                        matriz[numlinea][4] = a[4];
                        numlinea++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != Fr) {
                    Fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return matriz;
    }
}
