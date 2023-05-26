public class Juego {
    private String nombre;
    private int año;
    private String genero;
    private String distribuidora;
    private boolean freeTP;

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

    public boolean isFreeTP() {
        return freeTP;
    }

    public Juego(String nombre, int año, String genero, String distribuidora, boolean freeTP) {
        this.nombre = nombre;
        this.año = año;
        this.genero = genero;
        this.distribuidora = distribuidora;
        this.freeTP = freeTP;
    }


}
