package modelo;
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


    public Juego(String nombre, int año, String genero, String distribuidora, String freeTP) {
        this.nombre = nombre;
        this.año = año;
        this.genero = genero;
        this.distribuidora = distribuidora;
        this.freeTP = freeTP;
    }

    @Override
    public String toString() {
        return nombre + ", " + año + ", " + genero + ", " + distribuidora + ", " + freeTP;
    }
}