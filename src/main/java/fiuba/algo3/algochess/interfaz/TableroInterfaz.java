package fiuba.algo3.algochess.interfaz;

import fiuba.algo3.algochess.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algochess.excepciones.UnidadInvalidaException;
import fiuba.algo3.algochess.juego.Casillero;
import fiuba.algo3.algochess.juego.Jugador;
import fiuba.algo3.algochess.juego.Tablero;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class TableroInterfaz {

    private Tablero tablero;
    private static final int tamanioCasillero = 35;
    private static final int filas = 20;
    private static final int columnas = 20;
    private Group grupoCasillero = new Group();
    private Stage ventana;

    public void crearTablero(ArrayList listaJugadores) throws CasilleroOcupadoException, UnidadInvalidaException {
        Pane tableroInterfaz = new Pane();
        tableroInterfaz.setPrefSize(filas * tamanioCasillero,columnas * tamanioCasillero);
        Jugador jugador1 = (Jugador) listaJugadores.get(0);
        Jugador jugadro2 = (Jugador) listaJugadores.get(1);
        tablero = new Tablero(jugador1, jugadro2);
        //Agrego los casillero al grupoCasilleros.
        agregarCasilleros(listaJugadores);
        tableroInterfaz.getChildren().addAll(grupoCasillero);
        mostrarTablero(tableroInterfaz);
        iniciarAgregadoDeFichas(listaJugadores);

    }

    private void agregarCasilleros(ArrayList listaJugadores) {
        for (int x = 0; x < listaJugadores.size(); x++) {
            Jugador jugador = (Jugador) listaJugadores.get(x);
            ArrayList listaCasilleros = jugador.casilleroJugador;
            for (int y = 0; y < listaCasilleros.size(); y++) {
                grupoCasillero.getChildren().add((Casillero)listaCasilleros.get(y));
            }
        }
    }

    private void mostrarTablero(Pane tablero) {
        Scene scene = new Scene(tablero);
        ventana = new Stage();
        ventana.setTitle("AlgoChess");
        ventana.setScene(scene);
        ventana.show();
    }

    private void iniciarAgregadoDeFichas(ArrayList listaJugadores){

        for (int x = 0; x < listaJugadores.size(); x++){
            Jugador jugadorActual = (Jugador) listaJugadores.get(x);
            ventana.setTitle("Turno de : " + jugadorActual.getNombreJugador());
            /*
            while (jugadorActual.puedeSeguirJugando()){

            }
            
             */

        }
    }
}

