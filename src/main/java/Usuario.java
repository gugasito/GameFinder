public class Usuario {
    public enum Rol{
        Usuario,
        Administrador
    }
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private Rol rol;

    public Usuario(String nombre, Rol rol) {
        this.nombre = nombre;
        this.rol = rol;
    }

    public Rol isRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
