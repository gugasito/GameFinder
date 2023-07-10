package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Ventana de bienvenida del proyecto
 * @author Samuel Alvarez
 * @version 6 de julio
 */

public class VentanaBienvenida extends Ventana {

    private JButton botonAdministrador, botonFiltrado, botonSalida;

    /**
     * Constructor de la ventana
     * @param nombre nombre de la ventana
     * @param largoX tamaño en relacion a eje X
     * @param largoY tamaño en relacion a eje Y
     */
    public VentanaBienvenida(String nombre, int largoX, int largoY) {
        super(nombre, largoX, largoY);
        generarVentana();
    }
    /**
     * Metodo para generar la ventana
     */
    public void generarVentana() {
        generarLogo();
        generarBotonAdministrador();
        generarBotonFiltrado();
        generarBotonSalida();
        generarImagenFondoGrande();
    }

    /**
     * Metodo que muestra el logo del proyecto
     */
    private void generarLogo() {
        JLabel labelLogo = new JLabel();
        labelLogo.setIcon(new ImageIcon("src/main/java/imagenes/GFsinFondo.png"));
        labelLogo.setBounds(275, 50, 250,250);
        this.add(labelLogo);
    }

    /**
     * Metodo que genera el boton para ingreso de administradores
     */
    public void generarBotonAdministrador() {
        this.botonAdministrador = super.generarBoton("Administrador", 300, 350, 200, 40);
        this.botonAdministrador.setForeground(Color.WHITE);
        this.botonAdministrador.setBackground(Color.BLACK);
        this.add(this.botonAdministrador);
        this.botonAdministrador.addActionListener(this);
    }
    /**
     * Metodo que genera el boton para ir a la ventana de filtrado
     */

    public void generarBotonFiltrado() {
        this.botonFiltrado = super.generarBoton("Opciones de Filtrado", 300, 400, 200, 40);
        this.botonFiltrado.setForeground(Color.WHITE);
        this.botonFiltrado.setBackground(Color.BLACK);
        this.add(this.botonFiltrado);
        this.botonFiltrado.addActionListener(this);
    }

    /**
     * Metodo para generar el boton de salida y cierre del proyecto
     */
    public void generarBotonSalida() {
        this.botonSalida = super.generarBoton("Salir", 350, 500, 100, 40);
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