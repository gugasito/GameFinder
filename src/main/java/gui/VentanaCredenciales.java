package gui;

import modelo.datos.GestorArchivos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class VentanaCredenciales extends Ventana {
    private JButton botonInicioSesion, botonSalida;
    private JTextField usuario;
    private JPasswordField contraseña;
    private JLabel textoUsuario, textoContraseña;

    public VentanaCredenciales(String nombre, int largoX, int largoY) {
        super(nombre, largoX, largoY);
        generarVentana();
    }

    public void generarVentana() {
        generarUsuario();
        generarContraseña();
        generarBotonSalida();
        generarInicioSesion();
        generarImagenFondoChica();
    }

    private void generarInicioSesion() {
        this.botonInicioSesion = super.generarBoton("Iniciar Sesión", 175, 150, 150, 40);
        this.botonInicioSesion.setForeground(Color.WHITE);
        this.botonInicioSesion.setBackground(Color.BLACK);
        this.add(this.botonInicioSesion);
        this.botonInicioSesion.addActionListener(this);
    }

    public void generarUsuario() {
        String texto = "Usuario:";
        super.generarJLabel(this.textoUsuario, texto, 30, 37, 200, 50);
        this.usuario = super.generarJTextField(200, 50, 200, 30);
        this.add(this.usuario);
    }

    public void generarContraseña() {
        String texto = "Contraseña:";
        super.generarJLabel(this.textoContraseña, texto, 30, 87, 200, 50);
        this.contraseña = super.generarJPasswordField(200, 100, 200, 30);
        this.add(this.contraseña);
    }

    public void generarBotonSalida() {
        this.botonSalida = super.generarBoton("Atrás", 150, 425, 200, 40);
        this.botonSalida.setBackground(Color.RED);
        this.botonSalida.setForeground(Color.WHITE);
        this.add(this.botonSalida);
        this.botonSalida.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonInicioSesion) {
            if (administrador(usuario.getText(), new String(contraseña.getPassword()))) {
                JOptionPane.showMessageDialog(this, "Sesión iniciada correctamente", "Notifiación",
                        JOptionPane.INFORMATION_MESSAGE);
                VentanaAdministrador ventanaAdministrador = new VentanaAdministrador("🕹️🎮 [GameFinder][Administrador] 🎮🕹️", 800, 600);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al intentar autentificar su cuenta\ninténtelo nuevamente", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                VentanaCredenciales ventanaRegistroEstudiante = new VentanaCredenciales("⭐ Inicio de sesión ⭐", 500, 520);
            }
            this.dispose();
        }
        if (e.getSource() == this.botonSalida) {
            VentanaBienvenida ventanaBienvenida = new VentanaBienvenida("🕹️🎮 [GameFinder] 🎮🕹️", 800, 600);
            this.dispose();
        }
    }

    public boolean administrador(String usuario, String contraseña) {
        boolean userAdmitido = false;
        ArrayList<String> usuariosAdmitidos = GestorArchivos.leerUsuarios("src/main/java/modelo/datos/GameFinderUsuarios.txt");
        ArrayList<String> contraseñasAdmitidas = GestorArchivos.leerContraseñas("src/main/java/modelo/datos/GameFinderUsuarios.txt");
        for (int i = 0; i < usuariosAdmitidos.size(); i++) {
            if(usuariosAdmitidos.get(i).equalsIgnoreCase(usuario) && contraseñasAdmitidas.get(i).equals(contraseña) ){
                userAdmitido = true;
            }
        }

        return userAdmitido;
    }
}