package gui;

import modelo.Juego;
import modelo.datos.GestorArchivos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VentanaRegistroJuego extends Ventana {

    private JLabel textoNombreJuego, textoAñoJuego, textoGeneroJuego, textoDistribuidoraJuego, textoPrecioJuego;
    private JTextField nombreJuego, añoJuego, generoJuego, distribuidoraJuego;
    private JButton registrar, cancelar;
    private JComboBox precioJuego;

    public VentanaRegistroJuego(String nombre, int largoX, int largoY) {
        super(nombre, largoX, largoY);
        generarVentanaRegistroJuego();
    }

    public void generarVentanaRegistroJuego() {
        generarBotonRegistrar();
        generarBotonCancelar();
        generarNombreJuego();
        generarAñoJuego();
        generarGenero();
        generarDistribuidora();
        generarF2P();
        generarImagenFondoChica();
    }

    public void generarF2P() {
        String texto = "Precio:";
        super.generarJLabel(this.textoPrecioJuego, texto, 30, 227, 200, 50);
        String[] precios = {"Gratis", "Pago"};
        this.precioJuego = super.generarListaDesplegable(precios, 200, 250, 200, 30);
        this.add(this.precioJuego);
    }

    public void generarDistribuidora() {
        String texto = "Distribuidor/a:";
        super.generarJLabel(this.textoDistribuidoraJuego, texto, 30, 187, 200, 50);
        this.distribuidoraJuego = super.generarJTextField(200, 200, 200, 30);
        this.add(this.distribuidoraJuego);
    }

    public void generarGenero() {
        String texto = "Género:";
        super.generarJLabel(this.textoGeneroJuego, texto, 30, 137, 200, 50);
        this.generoJuego = super.generarJTextField(200, 150, 200, 30);
        this.add(this.generoJuego);
    }

    public void generarAñoJuego() {
        String texto = "Año:";
        super.generarJLabel(this.textoAñoJuego, texto, 30, 87, 200, 50);
        this.añoJuego = super.generarJTextField(200, 100, 200, 30);
        this.add(this.añoJuego);
    }

    public void generarNombreJuego() {
        String texto = "Nombre de juego:";
        super.generarJLabel(this.textoNombreJuego, texto, 30, 37, 200, 50);
        this.nombreJuego = super.generarJTextField(200, 50, 200, 30);
        this.add(this.nombreJuego);
    }

    public void generarBotonRegistrar() {
        this.registrar = super.generarBoton("Registrar", 130, 425, 100, 30);
        this.add(this.registrar);
        this.registrar.addActionListener(this);
    }

    public void generarBotonCancelar() {
        this.cancelar = super.generarBoton("Cancelar", 260, 425, 100, 30);
        this.cancelar.setBackground(Color.RED);
        this.cancelar.setForeground(Color.WHITE);
        this.add(this.cancelar);
        this.cancelar.addActionListener(this);
    }

    private boolean registrar() {
        if (this.nombreJuego.getText().length() == 0 || this.añoJuego.getText().length() == 0 || this.generoJuego.getText().length() == 0 || this.distribuidoraJuego.getText().length() == 0) {
            return false;
        } else {

            return true;
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.registrar) {
            if (registrar()) {
                Juego juego = new Juego(nombreJuego.getText().toLowerCase(), Integer.parseInt(añoJuego.getText()), generoJuego.getText().toLowerCase(), distribuidoraJuego.getText().toLowerCase(), String.valueOf(precioJuego.getSelectedItem()));
                GestorArchivos.registrarDato(juego, "src/main/java/modelo/datos/GameFinder.txt");
                JOptionPane.showMessageDialog(this, "Juego registrada correctamente", "Mensaje de confirmación",
                        JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Complete todos los datos", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
            }
            VentanaRegistroJuego ventanaRegistroJuego = new VentanaRegistroJuego("🕹️🎮 Añadir Juego [Administrador] 🎮🕹️", 500, 520);
            this.dispose();
        }

        if (e.getSource() == this.cancelar) {
            VentanaAdministrador ventanaAdministrador = new VentanaAdministrador("🕹️🎮 [GameFinder][Administrador] 🎮🕹️", 800, 600);
            this.dispose();
        }
    }

}