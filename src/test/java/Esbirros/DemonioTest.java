package Esbirros;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DemonioTest {

    @Test
    public void testRegistrarDemonio() {
        Demonio demonio = new Demonio();
        demonio.registrarDemonio("DemonioTest", "PactoTest");

        assertEquals("DemonioTest", demonio.getNombre());
        assertEquals("PactoTest", demonio.getPacto());
        assertNotNull(demonio.getSubordinados());
        assertEquals("DemonioTest_Subordinados", demonio.getSubordinados().getNombre());
    }

    @Test
    public void testGetAndSetPacto() {
        Demonio demonio = new Demonio();
        demonio.setPacto("PactoTest");
        assertEquals("PactoTest", demonio.getPacto());
    }

    @Test
    public void testGetAndSetSubordinados() {
        Demonio demonio = new Demonio();
        EsbirrosComposite subordinados = new EsbirrosComposite();
        subordinados.setNombre("SubordinadosTest");

        demonio.setSubordinados(subordinados);
        assertEquals(subordinados, demonio.getSubordinados());
    }

    @Test
    public void testRecibirDañoConSubordinados() {
        Demonio demonio = new Demonio();
        EsbirrosComposite subordinados = new EsbirrosComposite();
        Demonio esbirro = new Demonio();
        esbirro.setNombre("EsbirroTest");
        esbirro.setSalud(2);

        subordinados.agregarEsbirro(esbirro);
        demonio.setSubordinados(subordinados);

        int saludRestante = demonio.recibirDaño();
        assertEquals(1, esbirro.getSalud());
        assertEquals(1, subordinados.getChildren().size());
        assertEquals(saludRestante, demonio.getSalud());
    }

    @Test
    public void testRecibirDañoSinSubordinados() {
        Demonio demonio = new Demonio();
        demonio.setSalud(5);
        int saludRestante = demonio.recibirDaño();
        assertEquals(4, saludRestante);
        assertEquals(4, demonio.getSalud());
    }

    @Test
    public void testClone() {
        Demonio demonio = new Demonio();
        demonio.registrarDemonio("DemonioTest", "PactoTest");

        Demonio clon = demonio.clone();
        assertNotSame(demonio, clon);
        assertEquals(demonio.getNombre(), clon.getNombre());
        assertEquals(demonio.getPacto(), clon.getPacto());
        assertEquals(demonio.getSubordinados(), clon.getSubordinados());
    }

    @Test
    public void testEqualsAndHashCode() {
        Demonio demonio1 = new Demonio();
        demonio1.registrarDemonio("DemonioTest", "PactoTest");

        Demonio demonio2 = new Demonio();
        demonio2.registrarDemonio("DemonioTest", "PactoTest");

        assertEquals(demonio1, demonio2);
        assertEquals(demonio1.hashCode(), demonio2.hashCode());
    }
}