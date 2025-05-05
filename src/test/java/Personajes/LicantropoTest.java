package Personajes;

import HabilidadesEspeciales.Don;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LicantropoTest {

    @Test
    public void testConstructorSinParametros() {
        Licantropo licantropo = new Licantropo();
        assertNotNull(licantropo);
    }

    @Test
    public void testConstructorConNombre() {
        Licantropo licantropo = new Licantropo("LicantropoTest");
        assertEquals("LicantropoTest", licantropo.getNombre());
        assertNotNull(licantropo.getDon());
    }

    @Test
    public void testSetAndGetRabia() {
        Licantropo licantropo = new Licantropo();
        licantropo.setRabia(10);
        assertEquals(10, licantropo.getRabia());
    }

    @Test
    public void testSetAndGetDon() {
        Licantropo licantropo = new Licantropo();
        Don don = new Don(50, 5);
        licantropo.setDon(don);
        assertEquals(don, licantropo.getDon());
    }

    @Test
    public void testReducirSalud() {
        Licantropo licantropo = new Licantropo();
        licantropo.setSalud(5);
        licantropo.setRabia(3);
        licantropo.reducirSalud();
        assertEquals(4, licantropo.getSalud());
        assertEquals(3, licantropo.getRabia());
    }

    @Test
    public void testGestionarRecursosHabilidad() {
        Licantropo licantropo = new Licantropo();
        licantropo.setRabia(0);
        licantropo.setDon(new Don(50, 5));
        licantropo.gestionarRecursosHabilidad(true);
        assertEquals(4, licantropo.getRabia());
    }

    @Test
    public void testHabilidadPosible() {
        Licantropo licantropo = new Licantropo();
        licantropo.setRabia(0);
        licantropo.setDon(new Don(50, 5));
        assertFalse(licantropo.habilidadPosible());
    }

    @Test
    public void testClone() {
        Licantropo licantropo = new Licantropo("LicantropoTest");
        licantropo.setRabia(10);
        Licantropo clon = licantropo.clone();
        assertNotSame(licantropo, clon);
        assertEquals(licantropo.getNombre(), clon.getNombre());
        assertEquals(licantropo.getRabia(), clon.getRabia());
        assertEquals(licantropo.getDon(), clon.getDon());
    }

}