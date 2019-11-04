import Excepciones.NoAlcanzanLosPuntosException;
import excepciones.UnidadInvalidaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class JugadorTest {

    @Test
        // Creo un jugador y tiene 20 puntos disponibles
    public void jugadorArrancaConLosPuntosCorrectos() {
        Jugador jugador = new Jugador("Juan");
        Assertions.assertEquals(20,jugador.getPuntos());
    }
    @Test
        // Pruebo que un jugador recien creado no tiene unidades
    public void jugadorNuevoNoTieneUnidades(){
        Jugador jugador = new Jugador("Juan");
        Assertions.assertEquals(true,jugador.getUnidadesCreadas().isEmpty());
    }

    @Test
        // jugador crea unidad correctamente.
    public void jugadorCreaUnidadYPoseeLaUnidadCreada() throws UnidadInvalidaException, NoAlcanzanLosPuntosException {
        Jugador jugador = new Jugador("Juan");
        jugador.crearUnidad("Soldado");
        Assertions.assertEquals(1,jugador.getUnidadesCreadas().size());
    }

    @Test
    // Jugador modifica los puntos correctamente.
    public void jugadorModificaPuntosYSusPuntosSeModifican(){
        Jugador jugador = new Jugador("Juan");
        jugador.modificarPuntos(10);
        Assertions.assertEquals(10,jugador.getPuntos());
    }
}
