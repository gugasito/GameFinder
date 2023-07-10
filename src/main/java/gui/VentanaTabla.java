package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
/**
 * Ventana que genera una tabla desplegable
 * @author Benjamin Cruzado
 * @version 6 de julio
 */
public class VentanaTabla extends JFrame {
    private String[][] datos;
    private String[] nombreColumnas;

    /**
     * Constructor VentanaTabla
     * @param datos datos a mostrar
     * @param nombreColumnas cantidad de columnas de la tabla
     */
    public VentanaTabla(String[][] datos, String[] nombreColumnas) {
        super("Lista de datos");
        this.datos = datos;
        this.nombreColumnas = nombreColumnas;
        generarTabla();
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        this.pack();
        this.setVisible(true);
        ImageIcon icono = new ImageIcon("src/main/java/imagenes/logo.PNG");
        super.setIconImage(icono.getImage());
    }

    /**
     * Metodo que indica que la celda no es editable
     * @param row línea de la tabla
     * @param column columna de la tabla
     * @return indicacion de que la celda no se puede editar
     */
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    /**
     * Metodo que genera y muestra la tabla
     */
    public void generarTabla() {
        DefaultTableModel dtm = new DefaultTableModel(this.datos, this.nombreColumnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        final JTable tabla = new JTable(dtm);

        tabla.setPreferredScrollableViewportSize(new Dimension(800, 600));
        JScrollPane scrollPane = new JScrollPane(tabla);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
            }
        });
    }

    /**
     * Metodo para cerrar la ventana
     */
    private void cerrarVentana() {
        this.dispose();
    }
}