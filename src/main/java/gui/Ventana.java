package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Ventana extends JFrame implements ActionListener {
    private final Font fuenteTitulo;
    private final Font fuenteTexto;

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

    protected JButton generarBoton(String texto, int posicionX, int posicionY, int largoX, int largoY) {
        JButton boton = new JButton(texto);
        boton.setBounds(posicionX, posicionY, largoX, largoY);
        boton.setFont(this.fuenteTexto);
        return boton;
    }

    protected void generarJLabel(JLabel label, String texto, int posicionX, int posicionY, int largoX, int largoY) {
        label = new JLabel(texto);
        label.setBounds(posicionX, posicionY, largoX, largoY);
        label.setFont(this.fuenteTexto);
        this.add(label);
    }

    protected JTextField generarJTextField(int posicionX, int posicionY, int largoX, int largoY) {
        JTextField textField = new JTextField();
        textField.setBounds(posicionX, posicionY, largoX, largoY);
        return textField;
    }

    protected JComboBox generarListaDesplegable(Object[] datosLista, int posicionX, int posicionY, int largoX, int largoY) {
        JComboBox lista = new JComboBox(datosLista);
        lista.setBounds(posicionX, posicionY, largoX, largoY);
        return lista;
    }

    protected JPasswordField generarJPasswordField(int posicionX, int posicionY, int largoX, int largoY) {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(posicionX, posicionY, largoX, largoY);
        return passwordField;
    }


    protected void generarImagenFondoChica(){
        ImageIcon imagenFondo = new ImageIcon("src/main/java/imagenes/Fondo(500 × 520 px).png");
        Image imagen = imagenFondo.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH);
        JLabel etiquetaFondo = new JLabel(new ImageIcon(imagen));
        etiquetaFondo.setBounds(0, 0, 500, 520);
        this.add(etiquetaFondo);
    }

    protected void generarImagenFondoGrande(){
        ImageIcon imagenFondo = new ImageIcon("src/main/java/imagenes/Fondo(800 × 600 px).png");
        Image imagen = imagenFondo.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH);
        JLabel etiquetaFondo = new JLabel(new ImageIcon(imagen));
        etiquetaFondo.setBounds(0, 0, 800, 600);
        this.add(etiquetaFondo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}