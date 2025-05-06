package App;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {

    @Test
    public void testConstructorPorDefecto() {
        Jugador jugador = new Jugador();
        assertNotNull(jugador.getDesafiosPendientes());
        assertEquals(500, jugador.getOro());
        assertEquals(0, jugador.getNumCombatesGanados());
        assertEquals(0, jugador.getNumCombatesPerdidos());
        assertFalse(jugador.isBloqueado());
        assertNotNull(jugador.getHistorialOro());
    }

    @Test
    public void testSetAndGetNombre() {
        Jugador jugador = new Jugador();
        jugador.setNombre("Carlos");
        assertEquals("Carlos", jugador.getNombre());
    }

    @Test
    public void testSetAndGetRegNum() {
        Jugador jugador = new Jugador();
        jugador.setRegNum("A12BC");
        assertEquals("A12BC", jugador.getRegNum());
    }

    @Test
    public void testIncreaseNumCombatesGanados() {
        Jugador jugador = new Jugador();
        jugador.increaseNumCombatesGanados();
        assertEquals(1, jugador.getNumCombatesGanados());
    }

    @Test
    public void testIncreaseNumCombatesPerdidos() {
        Jugador jugador = new Jugador();
        jugador.increaseNumCombatesPerdidos();
        assertEquals(1, jugador.getNumCombatesPerdidos());
    }

    @Test
    public void testGetPorcentajeCombatesGanados() {
        Jugador jugador = new Jugador();
        assertEquals(0.0, jugador.getPorcentajeCombatesGanados());

        jugador.increaseNumCombatesGanados();
        jugador.increaseNumCombatesPerdidos();
        assertEquals(50.0, jugador.getPorcentajeCombatesGanados());
    }

    @Test
    public void testBloquearYDesbloquear() {
        Jugador jugador = new Jugador();
        jugador.bloquear();
        assertTrue(jugador.isBloqueado());

        jugador.desbloquear();
        assertFalse(jugador.isBloqueado());
    }

    @Test
    public void testRegistrarDatos() {
        Jugador jugador = new Jugador();
        jugador.registrarDatos("nick123", "Juan", "password123");
        assertEquals("Juan", jugador.getNombre());
        assertEquals("nick123", jugador.Nick);
        assertEquals("password123", jugador.Password);
    }

}