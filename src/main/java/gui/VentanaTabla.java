package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class VentanaTabla extends JFrame {
    private String[][] datos;
    private String[] nombreColumnas;

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

    public boolean isCellEditable(int row, int column) {
        return false;
    }

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

    private void cerrarVentana() {
        this.dispose();
    }
}