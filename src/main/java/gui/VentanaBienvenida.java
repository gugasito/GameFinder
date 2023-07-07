package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaBienvenida extends Ventana {

    private JButton botonAdministrador, botonFiltrado, botonSalida;

    public VentanaBienvenida(String nombre, int largoX, int largoY) {
        super(nombre, largoX, largoY);
        generarVentana();
    }

    public void generarVentana() {
        generarLogo();
        generarBotonAdministrador();
        generarBotonFiltrado();
        generarBotonSalida();
        generarImagenFondoGrande();
    }

    private void generarLogo() {
        JLabel labelLogo = new JLabel();
        labelLogo.setIcon(new ImageIcon("src/main/java/imagenes/GFsinFondo.png"));
        labelLogo.setBounds(275, 50, 250,250);
        this.add(labelLogo);
    }


    public void generarBotonAdministrador() {
        this.botonAdministrador = super.generarBoton("Administrador", 300, 350, 200, 40);
        this.botonAdministrador.setForeground(Color.WHITE);
        this.botonAdministrador.setBackground(Color.BLACK);
        this.add(this.botonAdministrador);
        this.botonAdministrador.addActionListener(this);
    }

    public void generarBotonFiltrado() {
        this.botonFiltrado = super.generarBoton("Opciones de Filtrado", 300, 400, 200, 40);
        this.botonFiltrado.setForeground(Color.WHITE);
        this.botonFiltrado.setBackground(Color.BLACK);
        this.add(this.botonFiltrado);
        this.botonFiltrado.addActionListener(this);
    }


    public void generarBotonSalida() {
        this.botonSalida = super.generarBoton("Salir", 350, 500, 100, 40);
        this.botonSalida.setBackground(Color.RED);
        this.botonSalida.setForeground(Color.WHITE);
        this.add(this.botonSalida);
        this.botonSalida.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonFiltrado) {
            VentanaFiltrado ventanaRegistoCarrera = new VentanaFiltrado("⭐ Filtrado de Juegos ⭐", 800, 600);
            this.dispose();
        }
        if (e.getSource() == this.botonAdministrador) {
            VentanaCredenciales ventanaRegistroEstudiante = new VentanaCredenciales("⭐ Inicio de sesión ⭐", 500, 520);
            this.dispose();
        }
        if (e.getSource() == this.botonSalida) {
            this.dispose();
            System.exit(0);
        }
    }
}