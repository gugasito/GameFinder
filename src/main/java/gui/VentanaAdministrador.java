package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Ventana para uso de administradores
 * @author Samuel Alvarez
 * @version 6 de julio
 */

public class VentanaAdministrador extends Ventana {
    private JButton botonAñadirJuego, botonBorrarJuego, botonSalida;

    /**
     * Constructor de la ventana administrador
     * @param nombre nombre de la ventana
     * @param largoX tamaño en relacion al eje X
     * @param largoY tamaño en relacion al eje Y
     */
    public VentanaAdministrador(String nombre, int largoX, int largoY) {
        super(nombre, largoX, largoY);
        generarVentana();
    }

    /**
     * Metodo para generar la ventana
     */
    public void generarVentana() {
        generarBotonAñadirJuego();
        generarBotonBorrarJuego();
        generarBotonSalida();
        generarImagenFondoGrande();
    }
    /**
     * Metodo para generar el boton para añadir un juego
     */
    private void generarBotonAñadirJuego() {
        this.botonAñadirJuego = super.generarBoton("Añadir Juego", 300, 150, 200, 40);
        this.botonAñadirJuego.setForeground(Color.WHITE);
        this.botonAñadirJuego.setBackground(Color.BLACK);
        this.add(this.botonAñadirJuego);
        this.botonAñadirJuego.addActionListener(this);
    }
    /**
     * Metodo para generar el boton para borrar un juego
     */
    private void generarBotonBorrarJuego() {
        this.botonBorrarJuego = super.generarBoton("Borrar Juego", 300, 200, 200, 40);
        this.botonBorrarJuego.setForeground(Color.WHITE);
        this.botonBorrarJuego.setBackground(Color.BLACK);
        this.add(this.botonBorrarJuego);
        this.botonBorrarJuego.addActionListener(this);
    }
    /**
     * Metodo para generar el boton para el cierre de sesion de administrador
     */
    public void generarBotonSalida() {
        this.botonSalida = super.generarBoton("Cerrar Sesión", 300, 425, 200, 40);
        this.botonSalida.setBackground(Color.RED);
        this.botonSalida.setForeground(Color.WHITE);
        this.add(this.botonSalida);
        this.botonSalida.addActionListener(this);
    }
    /**
     * Metodo para procesar la action del usuario
     * @param e el evento a ser procesado
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonAñadirJuego) {
            VentanaRegistroJuego ventanaRegistroJuego = new VentanaRegistroJuego("🕹️🎮 Añadir Juego [Administrador] 🎮🕹️", 500, 520);
            this.dispose();
        }
        if (e.getSource() == this.botonBorrarJuego) {
            VentanaBorrarJuego ventanaBorrarJuego = new VentanaBorrarJuego("🕹️🎮 Borrar Juego [Administrador] 🎮🕹️", 500, 520);
            this.dispose();
        }
        if (e.getSource() == this.botonSalida) {
            VentanaBienvenida ventanaBienvenida = new VentanaBienvenida("🕹️🎮 [GameFinder] 🎮🕹️", 800, 600);
            this.dispose();
        }
    }
}