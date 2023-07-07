package modelo.datos;

import modelo.Usuario;

import java.io.*;
import java.util.ArrayList;

public class GestorArchivos {
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
