package App;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests funcionales para la clase Operador.
 */
public class OperadorTest {

    private Operador operador;
    private Jugador jugador;

    @BeforeEach
    public void setUp() {
        operador = new Operador();
        jugador = new Jugador();
        jugador.setNombre("JugadorPrueba");
    }

    @Test
    public void testRegistrarDatos() {
        operador.registrarDatos("admin1", "Carlos", "securepass");
        assertEquals("Carlos", operador.getNombre());
        assertNotNull(operador.getNick()); // generado por hashCode
        assertEquals("securepass", operador.getPassword());
    }

    @Test
    public void testEditarPersonajeJugadorExistente() {
        // Aquí simulamos la edición de un personaje (aunque no haya lógica real aún)
        assertDoesNotThrow(() -> operador.editarPersonaje(jugador));
    }

    @Test
    public void testEditarPersonajeJugadorNull() {
        assertDoesNotThrow(() -> operador.editarPersonaje(null));
    }

    @Test
    public void testBloquearJugador() {
        operador.bloquearJugador(jugador);
        assertTrue(jugador.isBloqueado());
    }

    @Test
    public void testDesbloquearJugador() {
        jugador.bloquear();
        operador.desbloquearJugador(jugador);
        assertFalse(jugador.isBloqueado());
    }
}
