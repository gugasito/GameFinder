 package modelo;

 /**
  * Clase contenedora de objeto Usuario
  * @author Diego Marillan
  * @version 6 de julio
  */

public class Usuario {

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private String contraseña;

     /**
      * Constructor de objeto Usuario
      * @param nombre Nombre del usuario
      * @param contraseña Contraseña del usuario
      */
    public Usuario(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    public String getContraseña() {
        return contraseña;
    }
}
