public class Juego {
    private String nombre;
    private int año;
    private String genero;
    private String distribuidora;
    private boolean freeTP;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }

    public boolean isFreeTP() {
        return freeTP;
    }

    public void setFreeTP(boolean freeTP) {
        this.freeTP = freeTP;
    }

    public Juego(String nombre, int año, String genero, String distribuidora, boolean freeTP) {
        this.nombre = nombre;
        this.año = año;
        this.genero = genero;
        this.distribuidora = distribuidora;
        this.freeTP = freeTP;
    }


}
