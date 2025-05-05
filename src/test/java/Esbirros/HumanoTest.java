package Esbirros;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HumanoTest {

    @Test
    public void testConstructor() {
        Humano humano = new Humano();
        humano.setNombre("HumanoTest");
        humano.setSalud(10);
        assertEquals("HumanoTest", humano.getNombre());
        assertEquals(10, humano.getSalud());
    }

    @Test
    public void testGetAndSetNombre() {
        Humano humano = new Humano();
        humano.setNombre("NuevoNombre");
        assertEquals("NuevoNombre", humano.getNombre());
    }

    @Test
    public void testGetAndSetSalud() {
        Humano humano = new Humano();
        humano.setSalud(15);
        assertEquals(15, humano.getSalud());
    }

    @Test
    public void testRecibirDaño() {
        Humano humano = new Humano();
        humano.setSalud(10);
        int saludRestante = humano.recibirDaño();
        assertEquals(9, saludRestante);
        assertEquals(9, humano.getSalud());
    }
}