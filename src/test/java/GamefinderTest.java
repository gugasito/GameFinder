import modelo.datos.GestorArchivos;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GamefinderTest {
    @Test
    void contarLineasTest() {
        String rutaArchivo = "src/main/java/modelo/datos/GameFinder.txt";
        int resultado = GestorArchivos.contarLineas(rutaArchivo);
        assertEquals(105, resultado);
    }

    @Test
    void registrarDatoTest() {
        String direccionArchivo = "src/main/java/modelo/datos/GameFinder.txt";
        String objeto = "Objeto1";
        GestorArchivos.registrarDato(objeto, direccionArchivo);
        int resultado = GestorArchivos.contarLineas(direccionArchivo);
        assertEquals(106, resultado);
        GestorArchivos.borrarJuego(direccionArchivo, objeto);
    }

    @Test
    void leerUsuariosTest() {
        String direccionArchivo = "src/main/java/modelo/datos/GameFinderUsuarios.txt";
        ArrayList<String> usuariosEsperados = new ArrayList<>();
        usuariosEsperados.add("Benja");
        usuariosEsperados.add("Guga");
        usuariosEsperados.add("Diego");
        usuariosEsperados.add("Samuel");
        ArrayList<String> usuarios = GestorArchivos.leerUsuarios(direccionArchivo);
        assertEquals(usuariosEsperados, usuarios);
    }

    @Test
    void leerContraseñasTest() {
        String direccionArchivo = "src/main/java/modelo/datos/GameFinderUsuarios.txt";
        ArrayList<String> contraseñasEsperadas = new ArrayList<>();
        contraseñasEsperadas.add("1234b");
        contraseñasEsperadas.add("1234g");
        contraseñasEsperadas.add("1234d");
        contraseñasEsperadas.add("1234s");
        ArrayList<String> contraseñas = GestorArchivos.leerContraseñas(direccionArchivo);
        assertEquals(contraseñasEsperadas, contraseñas);
    }

    @Test
    void revisarJuegosTest() {
        String direccionArchivo = "src/main/java/modelo/datos/GameFinder.txt";
        String nombreJuego = "Robocraft";
        boolean resultado = GestorArchivos.revisarJuegos(direccionArchivo, nombreJuego);
        assertTrue(resultado);
    }
}

