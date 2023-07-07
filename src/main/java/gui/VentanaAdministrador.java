package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VentanaAdministrador extends Ventana {
    private JButton botonAñadirJuego, botonBorrarJuego, botonSalida;

    public VentanaAdministrador(String nombre, int largoX, int largoY) {
        super(nombre, largoX, largoY);
        generarVentana();
    }

    public void generarVentana() {
        generarBotonAñadirJuego();
        generarBotonBorrarJuego();
        generarBotonSalida();
        generarImagenFondoGrande();
    }

    private void generarBotonAñadirJuego() {
        this.botonAñadirJuego = super.generarBoton("Añadir Juego", 300, 150, 200, 40);
        this.botonAñadirJuego.setForeground(Color.WHITE);
        this.botonAñadirJuego.setBackground(Color.BLACK);
        this.add(this.botonAñadirJuego);
        this.botonAñadirJuego.addActionListener(this);
    }

    private void generarBotonBorrarJuego() {
        this.botonBorrarJuego = super.generarBoton("Borrar Juego", 300, 200, 200, 40);
        this.botonBorrarJuego.setForeground(Color.WHITE);
        this.botonBorrarJuego.setBackground(Color.BLACK);
        this.add(this.botonBorrarJuego);
        this.botonBorrarJuego.addActionListener(this);
    }

    public void generarBotonSalida() {
        this.botonSalida = super.generarBoton("Cerrar Sesión", 300, 425, 200, 40);
        this.botonSalida.setBackground(Color.RED);
        this.botonSalida.setForeground(Color.WHITE);
        this.add(this.botonSalida);
        this.botonSalida.addActionListener(this);
    }

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