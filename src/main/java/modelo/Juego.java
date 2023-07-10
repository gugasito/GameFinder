package modelo;

/**
 * Clase contenedora de objeto Juego
 * @author Diego Marillan
 * @version 6 de julio
 */
public class Juego {
    private String nombre;
    private int año;
    private String genero;
    private String distribuidora;
    private String freeTP;

    public String getNombre() {
        return nombre;
    }

    public int getAño() {
        return año;
    }

    public String getGenero() {
        return genero;
    }

    public String getDistribuidora() {
        return distribuidora;
    }

    /**
     * Constructor del objeto Juego
     * @param nombre Nombre del juego
     * @param año Año de lanzamiento
     * @param genero Genero del videojuego
     * @param distribuidora Distribuidora del videojuego
     * @param freeTP Se refiere si es gratis o pago
     */
    public Juego(String nombre, int año, String genero, String distribuidora, String freeTP) {
        this.nombre = nombre;
        this.año = año;
        this.genero = genero;
        this.distribuidora = distribuidora;
        this.freeTP = freeTP;
    }

    /**
     * Metodo que muestra la informacion de un juego
     * @return Datos del juego
     */
    @Override
    public String toString() {
        return nombre + ", " + año + ", " + genero + ", " + distribuidora + ", " + freeTP;
    }
}