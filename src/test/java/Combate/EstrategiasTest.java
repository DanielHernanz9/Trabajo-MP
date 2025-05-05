package Combate;

import HabilidadesEspeciales.Disciplina;
import HabilidadesEspeciales.Don;
import Personajes.Cazador;
import Personajes.Licantropo;
import Personajes.Vampiro;
import HabilidadesEspeciales.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EstrategiasTest {

    @Test
    public void testEstrategiaCazador() {
        Talento talento = new Talento(10);
        Cazador cazador = new Cazador("CazadorTest");
        cazador.setValorDefensa(5);
        cazador.setPoder(20);
        cazador.setTalento(talento);
        EstrategiaCazador estrategia = new EstrategiaCazador();

        assertEquals(30, estrategia.calcularPotencialAtaque(cazador));
        assertEquals(25, estrategia.calcularPotencialDefensa(cazador));
    }

    @Test
    public void testEstrategiaLicantropo() {
        Licantropo licantropo = new Licantropo("LicantropoTest");
        licantropo.setPoder(25);
        licantropo.setRabia(10);
        licantropo.setDon(new Don(25, 15));
        licantropo.setValorDefensa(5);
        EstrategiaLicantropo estrategia = new EstrategiaLicantropo();

        assertEquals(50, estrategia.calcularPotencialAtaque(licantropo));
        assertEquals(40, estrategia.calcularPotencialDefensa(licantropo));
    }

    @Test
    public void testEstrategiaVampiro() {
        Vampiro vampiro = new Vampiro("VampiroTest");
        Disciplina disciplina = new Disciplina(10, 10);
        vampiro.setValorDefensa(5);
        vampiro.setSangre(20);
        vampiro.setPoder(30);

        EstrategiaVampiro estrategia = new EstrategiaVampiro();

        assertEquals(33, estrategia.calcularPotencialAtaque(vampiro));
        assertEquals(35, estrategia.calcularPotencialDefensa(vampiro));
    }

    @Test
    public void testEstrategiasConObjetoInvalido() {
        EstrategiaCazador estrategiaCazador = new EstrategiaCazador();
        EstrategiaLicantropo estrategiaLicantropo = new EstrategiaLicantropo();
        EstrategiaVampiro estrategiaVampiro = new EstrategiaVampiro();

        assertThrows(IllegalArgumentException.class, () -> estrategiaCazador.calcularPotencialAtaque(new Object()));
        assertThrows(IllegalArgumentException.class, () -> estrategiaLicantropo.calcularPotencialAtaque(new Object()));
        assertThrows(IllegalArgumentException.class, () -> estrategiaVampiro.calcularPotencialAtaque(new Object()));
    }
}