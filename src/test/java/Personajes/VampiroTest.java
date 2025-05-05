package Personajes;

import HabilidadesEspeciales.Disciplina;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VampiroTest {

    @Test
    public void testConstructorSinParametros() {
        Vampiro vampiro = new Vampiro();
        assertNotNull(vampiro);
    }

    @Test
    public void testConstructorConNombre() {
        Vampiro vampiro = new Vampiro("VampiroTest");
        assertEquals("VampiroTest", vampiro.getNombre());
        assertNotNull(vampiro.getDisciplina());
    }

    @Test
    public void testSetAndGetSangre() {
        Vampiro vampiro = new Vampiro();
        vampiro.setSangre(10);
        assertEquals(10, vampiro.getSangre());
    }

    @Test
    public void testSetAndGetDisciplina() {
        Vampiro vampiro = new Vampiro();
        Disciplina disciplina = new Disciplina(50, 5);
        vampiro.setDisciplina(disciplina);
        assertEquals(disciplina, vampiro.getDisciplina());
    }

    @Test
    public void testReducirSalud() {
        Vampiro vampiro = new Vampiro();
        vampiro.setSalud(5);
        vampiro.setSangre(3);
        vampiro.reducirSalud();
        assertEquals(4, vampiro.getSalud());
        assertEquals(2, vampiro.getSangre());
    }

    @Test
    public void testGestionarRecursosHabilidad() {
        Vampiro vampiro = new Vampiro();
        vampiro.setSangre(0);
        vampiro.gestionarRecursosHabilidad(false);
        assertEquals(3, vampiro.getSangre());
    }

    @Test
    public void testHabilidadPosible() {
        Vampiro vampiro = new Vampiro();
        assertFalse(vampiro.habilidadPosible());
    }

    @Test
    public void testClone() {
        Vampiro vampiro = new Vampiro("VampiroTest");
        vampiro.setSangre(10);
        Vampiro clon = vampiro.clone();
        assertNotSame(vampiro, clon);
        assertEquals(vampiro.getNombre(), clon.getNombre());
        assertEquals(vampiro.getSangre(), clon.getSangre());
        assertEquals(vampiro.getDisciplina(), clon.getDisciplina());
    }

    @Test
    public void testEqualsAndHashCode() {
        Vampiro vampiro1 = new Vampiro("VampiroTest");
        vampiro1.setSangre(10);

        Vampiro vampiro2 = new Vampiro("VampiroTest");
        vampiro2.setSangre(10);

        assertEquals(vampiro1, vampiro2);
        assertEquals(vampiro1.hashCode(), vampiro2.hashCode());
    }
}