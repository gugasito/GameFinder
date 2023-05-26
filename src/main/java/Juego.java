public class Juego {
    private String nombre;
    private int año;
    private String genero;
    private String distribuidora;
    public enum F2P{Gratis,Pago}
    private F2P freeTP;

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

    public F2P isFreeTP() {
        return freeTP;
    }

    public Juego(String nombre, int año, String genero, String distribuidora, F2P freeTP) {
        this.nombre = nombre;
        this.año = año;
        this.genero = genero;
        this.distribuidora = distribuidora;
        this.freeTP = freeTP;
    }


}
