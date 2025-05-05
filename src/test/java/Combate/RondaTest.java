package Combate;

import Personajes.Cazador;
import Personajes.Licantropo;
import Personajes.Vampiro;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RondaTest {

    @Test
    public void testConstructorPorDefecto() {
        Ronda ronda = new Ronda();
        assertNull(ronda.getAtacante());
        assertNull(ronda.getAtacado());
        assertEquals(0, ronda.getNumeroRonda());
    }

    @Test
    public void testConstructorConParametros() {
        Cazador atacante = new Cazador("AtacanteTest");
        Vampiro defensor = new Vampiro("DefensorTest");
        Ronda ronda = new Ronda(atacante, defensor,1);

        assertEquals(1, ronda.getNumeroRonda());
        assertEquals(atacante, ronda.getAtacante());
        assertEquals(defensor, ronda.getAtacado());
    }

    @Test
    public void testSetAndGetNumero() {
        Ronda ronda = new Ronda();
        ronda.setNumeroRonda(5);
        assertEquals(5, ronda.getNumeroRonda());
    }

    @Test
    public void testSetAndGetAtacante() {
        Cazador atacante = new Cazador("AtacanteTest");
        Ronda ronda = new Ronda();
        ronda.setAtacante(atacante);
        assertEquals(atacante, ronda.getAtacante());
    }

    @Test
    public void testSetAndGetDefensor() {
        Licantropo defensor = new Licantropo("DefensorTest");
        Ronda ronda = new Ronda();
        ronda.setAtacante(defensor);
        assertEquals(defensor, ronda.getAtacante());
    }

}