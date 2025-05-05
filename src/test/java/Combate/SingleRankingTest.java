package Combate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SingleRankingTest {

    @Test
    public void testObtenerInstancia() {
        SingleRanking instancia1 = SingleRanking.getInstance();
        SingleRanking instancia2 = SingleRanking.getInstance();

        assertNotNull(instancia1);
        assertSame(instancia1, instancia2); // Verifica que ambas referencias sean la misma instancia
    }

    @Test
    public void testActualizarRanking() {
        SingleRanking ranking = SingleRanking.getInstance();
        ranking.updateRanking(); // Actualiza el ranking cargando y ordenando los jugadores

        assertNotNull(ranking.getRanking()); // Verifica que el ranking no sea null
        assertTrue(ranking.getRanking().size() >= 0); // Verifica que el ranking tenga jugadores o esté vacío
    }

    @Test
    public void testMostrarRanking() {
        SingleRanking ranking = SingleRanking.getInstance();
        ranking.updateRanking(); // Asegura que el ranking esté actualizado

        // Captura la salida del método showRanking()
        assertDoesNotThrow(ranking::showRanking); // Verifica que no lance excepciones
    }
}