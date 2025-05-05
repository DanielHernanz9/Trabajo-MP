package Esbirros;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GhoulTest {

    @Test
    public void testConstructor() {
        Ghoul ghoul = new Ghoul();
        ghoul.setNombre("GhoulTest");
        ghoul.setSalud(10);
        assertEquals("GhoulTest", ghoul.getNombre());
        assertEquals(10, ghoul.getSalud());
    }

    @Test
    public void testGetAndSetNombre() {
        Ghoul ghoul = new Ghoul();
        ghoul.setNombre("NuevoNombre");
        assertEquals("NuevoNombre", ghoul.getNombre());
    }

    @Test
    public void testGetAndSetSalud() {
        Ghoul ghoul = new Ghoul();
        ghoul.setSalud(15);
        assertEquals(15, ghoul.getSalud());
    }

    @Test
    public void testRecibirDaño() {
        Ghoul ghoul = new Ghoul();
        ghoul.setSalud(10);
        int saludRestante = ghoul.recibirDaño();
        assertEquals(9, saludRestante);
        assertEquals(9, ghoul.getSalud());
    }

}