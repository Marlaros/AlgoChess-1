package fiuba.algo3.algochess.Modelo.juego;

import fiuba.algo3.algochess.Modelo.excepciones.NoAlcanzanLosPuntosException;
import fiuba.algo3.algochess.Modelo.excepciones.TurnoJugadorException;

public class FaseCreacionUnidades implements Fase{
    private Jugador jugadorActual;
    private Jugador jugadorSiguiente;
    private Tablero tablero;

    public FaseCreacionUnidades(Jugador jugador1, Jugador jugador2, Tablero tablero){
        this.jugadorActual = jugador1;
        this.jugadorSiguiente = jugador2;
        this.tablero = tablero;
    }

    public void iniciarFaseCreacionUnidades(){

    }

    public void cambiarTurno(){
        if (jugadorActual == jugadorSiguiente){
            FaseJuego faseJuego = new FaseJuego(jugadorActual, jugadorSiguiente, tablero);
            faseJuego.iniciarFaseJuego();
        }
        this.jugadorActual = jugadorSiguiente;
    }

    @Override
    public void crearUnidad(Jugador jugador, Posicion posicion, String nombreUnidad){
        if (jugadorActual == jugador) {
            tablero.crearUnidad(jugador, posicion, nombreUnidad);
            if(jugadorActual.getPuntosDisponibles() == 0){
                this.cambiarTurno();
            }
        } else {
            throw new TurnoJugadorException("Es el turno del otro jugador");
        }
    }

    @Override
    public void realizarMovimiento(Posicion posicionInicial, Posicion posicionFinal, Jugador jugador){}

    @Override
    public void realizarAtaque(Posicion posicionAtacante, Posicion posicionAtacado, Jugador jugador){}
}
