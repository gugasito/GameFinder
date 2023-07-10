package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Clase con las bases para la generacion de ventanas
 * @author Samuel Alvarez
 * @version 6 de julio
 */

public class Ventana extends JFrame implements ActionListener {
    private final Font fuenteTitulo;
    private final Font fuenteTexto;

    /**
     * Constructor de la ventana
     * @param nombre Nombre de la ventana
     * @param largoX El largo dentro del eje X de la ventana
     * @param largoY El largo dentro del eje Y de la ventana
     */
    protected Ventana(String nombre, int largoX, int largoY) {
        super(nombre);
        super.setVisible(true);
        super.setDefaultCloseOperation(0);
        super.setSize(largoX, largoY);
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        this.setLayout(null);
        this.fuenteTitulo = new Font("Unispace", 3, 20);
        this.fuenteTexto = new Font("Unispace", 1, 13);
        ImageIcon icono = new ImageIcon("src/main/java/imagenes/GFsinFondo.png");
        super.setIconImage(icono.getImage());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo base para generar botones
     * @param texto Texto dentro del boton
     * @param posicionX Posicion del boton respecto al eje X
     * @param posicionY Posicion del boton respecto al eje Y
     * @param largoX Largo del boton respecto al eje X
     * @param largoY Largo del boton respecto al eje y
     * @return Boton generado
     */
    protected JButton generarBoton(String texto, int posicionX, int posicionY, int largoX, int largoY) {
        JButton boton = new JButton(texto);
        boton.setBounds(posicionX, posicionY, largoX, largoY);
        boton.setFont(this.fuenteTexto);
        return boton;
    }

    /**
     * Metodo base para generar etiquetas
     * @param label Etiqueta a generar
     * @param texto Texto dentro de etiqueta
     * @param posicionX Posicion de la etiqueta respecto al eje X
     * @param posicionY Posicion de la etiqueta respecto al eje Y
     * @param largoX Largo de la etiqueta respecto al eje X
     * @param largoY Largo de la etiqueta respecto al eje Y
     */
    protected void generarJLabel(JLabel label, String texto, int posicionX, int posicionY, int largoX, int largoY) {
        label = new JLabel(texto);
        label.setBounds(posicionX, posicionY, largoX, largoY);
        label.setFont(this.fuenteTexto);
        this.add(label);
    }

    /**
     * Metodo para generar un campo de texto
     * @param posicionX Posicion en relacion al eje X
     * @param posicionY Posicion en relacion al eje Y
     * @param largoX Tamaño en relacion al eje X
     * @param largoY Tamaño en relacion al eje Y
     * @return campo de texto
     */
    protected JTextField generarJTextField(int posicionX, int posicionY, int largoX, int largoY) {
        JTextField textField = new JTextField();
        textField.setBounds(posicionX, posicionY, largoX, largoY);
        return textField;
    }

    /**
     * Metodo para generar listas desplegables
     * @param datosLista Lista de datos del objeto
     * @param posicionX Posicion en relacion al eje X
     * @param posicionY Posicion en relacion al eje Y
     * @param largoX Tamaño en relacion al eje X
     * @param largoY Tamaño en relacion al eje Y
     * @return lista desplegable
     */
    protected JComboBox generarListaDesplegable(Object[] datosLista, int posicionX, int posicionY, int largoX, int largoY) {
        JComboBox lista = new JComboBox(datosLista);
        lista.setBounds(posicionX, posicionY, largoX, largoY);
        return lista;
    }

    /**
     * Metodo para generar el campo para ingreso de contraseñas
     * @param posicionX Posicion en relacion al eje X
     * @param posicionY Posicion en relacion al eje Y
     * @param largoX Tamaño en relacion al eje X
     * @param largoY Tamaño en relacion al eje Y
     * @return campo de ingreso de contraseñas
     */
    protected JPasswordField generarJPasswordField(int posicionX, int posicionY, int largoX, int largoY) {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(posicionX, posicionY, largoX, largoY);
        return passwordField;
    }


    /**
     * Metodo para mostrar la imagen de fondo de tamaño pequeño
     */
    protected void generarImagenFondoChica(){
        ImageIcon imagenFondo = new ImageIcon("src/main/java/imagenes/Fondo(500 × 520 px).png");
        Image imagen = imagenFondo.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH);
        JLabel etiquetaFondo = new JLabel(new ImageIcon(imagen));
        etiquetaFondo.setBounds(0, 0, 500, 520);
        this.add(etiquetaFondo);
    }

    /**
     * Metodo para mostrar la imagen de fondo de tamaño grande
     */
    protected void generarImagenFondoGrande(){
        ImageIcon imagenFondo = new ImageIcon("src/main/java/imagenes/Fondo(800 × 600 px).png");
        Image imagen = imagenFondo.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH);
        JLabel etiquetaFondo = new JLabel(new ImageIcon(imagen));
        etiquetaFondo.setBounds(0, 0, 800, 600);
        this.add(etiquetaFondo);
    }

    /**
     * Metodo para procesar la action del usuario
     * @param e el evento a ser procesado
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}