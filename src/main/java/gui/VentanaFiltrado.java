package gui;

import modelo.datos.GestorArchivos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class VentanaFiltrado extends Ventana {
    private JButton botonSalida, botonFiltradoAño, botonFiltradoGenero, botonFiltradoNombre, botonFiltradoDistribuidora;
    private JLabel textoParametroFiltrado;
    private JTextField parametroFiltrado;
    private JComboBox precioJuego;


    public VentanaFiltrado(String nombre, int largoX, int largoY) {
        super(nombre, largoX, largoY);
        generarVentana();
    }

    public void generarVentana() {
        geneararBotonFiltradoAño();
        generarBotonFiltradoGenero();
        generarBotonFiltradoNombre();
        generarBotonFiltradoDistribuidora();
        generarPrecioJuego();
        generarParametroFiltrado();
        generarBotonSalida();
        generarImagenFondoGrande();
    }

    private void generarParametroFiltrado() {
        String texto = "Entrada de filtrado:";
        super.generarJLabel(this.textoParametroFiltrado, texto, 100, 37, 200, 50);
        this.parametroFiltrado = super.generarJTextField(300, 50, 200, 30);
        this.add(this.parametroFiltrado);
    }

    private void generarPrecioJuego() {
        String texto = "Precio:";
        super.generarJLabel(this.textoParametroFiltrado, texto, 100, 87, 200, 50);
        String[] precios = {"Gratis", "Pago"};
        this.precioJuego = super.generarListaDesplegable(precios, 300, 100, 200, 20);
        this.add(this.precioJuego);
    }

    private void generarBotonFiltradoDistribuidora() {
        this.botonFiltradoDistribuidora = super.generarBoton("Filtrar por distribuidora", 300, 350, 200, 40);
        this.botonFiltradoDistribuidora.setForeground(Color.WHITE);
        this.botonFiltradoDistribuidora.setBackground(Color.BLACK);
        this.add(this.botonFiltradoDistribuidora);
        this.botonFiltradoDistribuidora.addActionListener(this);
    }

    private void generarBotonFiltradoGenero() {
        this.botonFiltradoGenero = super.generarBoton("Filtrar por género", 300, 300, 200, 40);
        this.botonFiltradoGenero.setForeground(Color.WHITE);
        this.botonFiltradoGenero.setBackground(Color.BLACK);
        this.add(this.botonFiltradoGenero);
        this.botonFiltradoGenero.addActionListener(this);
    }

    private void geneararBotonFiltradoAño() {
        this.botonFiltradoAño = super.generarBoton("Filtrar por año", 300, 250, 200, 40);
        this.botonFiltradoAño.setForeground(Color.WHITE);
        this.botonFiltradoAño.setBackground(Color.BLACK);
        this.add(this.botonFiltradoAño);
        this.botonFiltradoAño.addActionListener(this);
    }

    private void generarBotonFiltradoNombre() {
        this.botonFiltradoNombre = super.generarBoton("Filtrar por nombre", 300, 200, 200, 40);
        this.botonFiltradoNombre.setForeground(Color.WHITE);
        this.botonFiltradoNombre.setBackground(Color.BLACK);
        this.add(this.botonFiltradoNombre);
        this.botonFiltradoNombre.addActionListener(this);
    }

    public void generarBotonSalida() {
        this.botonSalida = super.generarBoton("Atrás", 300, 425, 200, 40);
        this.botonSalida.setBackground(Color.RED);
        this.botonSalida.setForeground(Color.WHITE);
        this.add(this.botonSalida);
        this.botonSalida.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonFiltradoNombre) {
            String[] nombreDatos = new String[]{"Nombre", "Año", "Género", "Distribuidor/a", "Precio"};
            VentanaTabla ventanaTabla = new VentanaTabla(GestorArchivos.filtrarNombre(parametroFiltrado.getText(), precioJuego.getSelectedItem().toString()),nombreDatos);
        }
        if (e.getSource() == this.botonFiltradoDistribuidora) {
            String[] nombreDatos = new String[]{"Nombre", "Año", "Género", "Distribuidor/a", "Precio"};
            VentanaTabla ventanaTabla = new VentanaTabla(GestorArchivos.filtrarDistribuidora(parametroFiltrado.getText(), precioJuego.getSelectedItem().toString()),nombreDatos);
        }
        if (e.getSource() == this.botonFiltradoAño) {
            String[] nombreDatos = new String[]{"Nombre", "Año", "Género", "Distribuidor/a", "Precio"};
            try {
                VentanaTabla ventanaTabla = new VentanaTabla(GestorArchivos.filtrarAño(Integer.parseInt(parametroFiltrado.getText()), precioJuego.getSelectedItem().toString()), nombreDatos);
            }catch (Exception exception){
                JOptionPane.showMessageDialog(this, "Error al ingresar el año, revise e intente nuevamente", "Mensaje de error", JOptionPane.ERROR_MESSAGE);

            }
        }
        if (e.getSource() == this.botonFiltradoGenero) {
            String[] nombreDatos = new String[]{"Nombre", "Año", "Género", "Distribuidor/a", "Precio"};
            VentanaTabla ventanaTabla = new VentanaTabla(GestorArchivos.filtrarGenero(parametroFiltrado.getText(), precioJuego.getSelectedItem().toString()),nombreDatos);
        }
        if (e.getSource() == this.botonSalida) {
            VentanaBienvenida ventanaBienvenida = new VentanaBienvenida("🕹️🎮 [GameFinder] 🎮🕹️", 800, 600);
            this.dispose();
        }
    }

}