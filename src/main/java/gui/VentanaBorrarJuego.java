package gui;

import modelo.datos.GestorArchivos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Ventana para la eliminacion de juegos
 * @author Gustavo Soto
 * @version 6 de julio
 */

public class VentanaBorrarJuego extends Ventana {

    private JLabel textoNombreJuego;
    private JTextField nombreJuego;
    private JButton borrar, cancelar;
    private JComboBox precioJuego;

    /**
     * Constructor de la ventana
     * @param nombre nombre de la ventana
     * @param largoX tamaño en relacion a eje X
     * @param largoY tamaño en relacion a eje Y
     */
    public VentanaBorrarJuego(String nombre, int largoX, int largoY) {
        super(nombre, largoX, largoY);
        generarVentanaBorrarJuego();
    }

    /**
     * Metodo para generar la ventana
     */
    public void generarVentanaBorrarJuego() {
        generarBotonBorrar();
        generarBotonCancelar();
        generarNombreJuego();
        generarImagenFondoChica();
    }
    /**
     * Metodo para generar la etiqueta y campo de texto del nombre del juego
     */
    public void generarNombreJuego() {
        String texto = "Nombre de juego:";
        super.generarJLabel(this.textoNombreJuego, texto, 30, 37, 200, 50);
        this.nombreJuego = super.generarJTextField(200, 50, 200, 30);
        this.add(this.nombreJuego);
    }
    /**
     * Metodo para generar el boton para confirmar la eliminacion de un juego
     */
    public void generarBotonBorrar() {
        this.borrar = super.generarBoton("Borrar", 130, 425, 100, 30);
        this.borrar.setForeground(Color.WHITE);
        this.borrar.setBackground(Color.BLACK);
        this.add(this.borrar);
        this.borrar.addActionListener(this);
    }
    /**
     * Metodo para generar el boton para cancelar la eliminacion de un juego
     */
    public void generarBotonCancelar() {
        this.cancelar = super.generarBoton("Cancelar", 260, 425, 100, 30);
        this.cancelar.setBackground(Color.RED);
        this.cancelar.setForeground(Color.WHITE);
        this.add(this.cancelar);
        this.cancelar.addActionListener(this);
    }

    /**
     * Metodo para confirmar la existencia del juego en la lista
     * @return booleano que indica la existencia o no existencia del juego en la lista
     */
    private boolean borrar() {
        if (this.nombreJuego.getText().length() == 0) {
            return false;
        } else {
            return true;
        }
    }
    /**
     * Metodo para procesar la action del usuario
     * @param e el evento a ser procesado
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.borrar) {
            if (borrar()) {
                if (GestorArchivos.revisarJuegos("src/main/java/modelo/datos/GameFinder.txt", nombreJuego.getText())) {
                    GestorArchivos.borrarJuego("src/main/java/modelo/datos/GameFinder.txt", nombreJuego.getText());
                    JOptionPane.showMessageDialog(this, "Juego eliminado correctamente", "Mensaje de confirmación",
                            JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "El juego seleccionado, no existe", "Mensaje de confirmación",
                            JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Complete todos los datos", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
            }
            VentanaBorrarJuego ventanaBorrarJuego = new VentanaBorrarJuego("🕹️🎮 Borrar Juego [Administrador] 🎮🕹️", 500, 520);
            this.dispose();
        }

        if (e.getSource() == this.cancelar) {
            VentanaAdministrador ventanaAdministrador = new VentanaAdministrador("🕹️🎮 [GameFinder][Administrador] 🎮🕹️", 800, 600);
            this.dispose();
        }
    }

}