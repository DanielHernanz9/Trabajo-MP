package Combate;

import App.Jugador;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class CombateTest {

    @Test
    public void testConstructorPorDefecto() {
        Combate combate = new Combate();
        assertNull(combate.getDesafiante());
        assertNull(combate.getDesafiado());
        assertNull(combate.getGanador());
        assertEquals(0, combate.getNumRondas());
        assertNull(combate.getRondas());
    }

    @Test
    public void testConstructorConParametros() {
        Jugador desafiante = new Jugador();
        Jugador desafiado = new Jugador();
        Combate combate = new Combate(desafiante, desafiado);

        assertEquals(desafiante, combate.getDesafiante());
        assertEquals(desafiado, combate.getDesafiado());
        assertNotNull(combate.getRondas());
        assertEquals(0, combate.getNumRondas());
        assertNotNull(combate.getFechaCombate());
    }

    @Test
    public void testIniciarCombateSinJugadores() {
        Combate combate = new Combate();
        assertNull(combate.IniciarCombate());
    }

    @Test
    public void testSetAndGetDesafianteYDesafiado() {
        Jugador desafiante = new Jugador();
        Jugador desafiado = new Jugador();

        Combate combate = new Combate();
        combate.setDesafiante(desafiante);
        combate.setDesafiado(desafiado);

        assertEquals(desafiante, combate.getDesafiante());
        assertEquals(desafiado, combate.getDesafiado());
    }

    @Test
    public void testSetAndGetGanador() {
        Jugador ganador = new Jugador();
        Combate combate = new Combate();
        combate.setGanador(ganador);

        assertEquals(ganador, combate.getGanador());
    }

    @Test
    public void testRegistrarCombate() {
        Jugador desafiante = new Jugador();
        desafiante.setNombre("Jugador1");
        Jugador desafiado = new Jugador();
        desafiado.setNombre("Jugador2");

        Combate combate = new Combate(desafiante, desafiado);
        combate.registrar();

        // No se puede verificar directamente el archivo XML, pero se puede comprobar que no lanza excepciones.
        assertNotNull(combate);
    }

    @Test
    public void testMostrarResultado() {
        Jugador ganador = new Jugador();
        ganador.setNombre("Ganador");
        Combate combate = new Combate();
        combate.setGanador(ganador);

        // Verifica que el método no lanza excepciones al ejecutarse.
        combate.mostrarResultado();
    }

    @Test
    public void testFechaCombate() {
        Combate combate = new Combate();
        Date fecha = new Date();
        combate.setFechaCombate(fecha);

        assertEquals(fecha, combate.getFechaCombate());
    }
}