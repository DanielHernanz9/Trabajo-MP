package Personajes;

import HabilidadesEspeciales.Talento;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CazadorTest {

    @Test
    public void testConstructorSinParametros() {
        Cazador cazador = new Cazador();
        assertNotNull(cazador);
    }

    @Test
    public void testConstructorConNombre() {
        Cazador cazador = new Cazador("CazadorTest");
        assertEquals("CazadorTest", cazador.getNombre());
        assertNotNull(cazador.getTalento());
    }

    @Test
    public void testSetAndGetVoluntad() {
        Cazador cazador = new Cazador();
        cazador.setVoluntad(10);
        assertEquals(10, cazador.getVoluntad());
    }

    @Test
    public void testSetAndGetTalento() {
        Cazador cazador = new Cazador();
        Talento talento = new Talento(50);
        cazador.setTalento(talento);
        assertEquals(talento, cazador.getTalento());
    }

    @Test
    public void testReducirSalud() {
        Cazador cazador = new Cazador();
        cazador.setSalud(5);
        cazador.setVoluntad(3);
        cazador.reducirSalud();
        assertEquals(4, cazador.getSalud());
        assertEquals(2, cazador.getVoluntad());
    }

    @Test
    public void testGestionarRecursosHabilidad() {
        Cazador cazador = new Cazador();
        cazador.setVoluntad(0);
        cazador.gestionarRecursosHabilidad(false);
        assertEquals(4, cazador.getVoluntad());
    }

    @Test
    public void testHabilidadPosible() {
        Cazador cazador = new Cazador();
        assertFalse(cazador.habilidadPosible());
    }

    @Test
    public void testClone() {
        Cazador cazador = new Cazador("CazadorTest");
        cazador.setVoluntad(10);
        Cazador clon = cazador.clone();
        assertNotSame(cazador, clon);
        assertEquals(cazador.getNombre(), clon.getNombre());
        assertEquals(cazador.getVoluntad(), clon.getVoluntad());
        assertEquals(cazador.getTalento(), clon.getTalento());
    }

}