package fiuba.algo3.algochess.testclases;

import fiuba.algo3.algochess.Modelo.excepciones.*;
import fiuba.algo3.algochess.Modelo.juego.Posicion;
import fiuba.algo3.algochess.Modelo.juego.Puntos;
import fiuba.algo3.algochess.Modelo.unidades.Soldado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class SoldadoTest {
    @Test
    public void soldadoRecienCreadoTieneVidaLlena() throws NoAlcanzanLosPuntosException {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Soldado soldado = new Soldado(puntos,posicion);
        Assertions.assertEquals(100, soldado.getVidaUnidad());
    }

    @Test
    public void soldadoRecienCreadoCuestaLosPuntosCorrectos() throws NoAlcanzanLosPuntosException {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Soldado soldado = new Soldado(puntos,posicion);
        Assertions.assertEquals(1, soldado.cuantoCuesta());
    }

    @Test
    public void soldadoRecibeDanioCorrectamente() throws NoAlcanzanLosPuntosException {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Soldado soldado = new Soldado(puntos,posicion);
        soldado.recibirDanio(20);
        Assertions.assertEquals(80, soldado.getVidaUnidad());
    }
    @Test
    public void soldadoSeCuraCorrectamente() throws NoAlcanzanLosPuntosException, CurarException {
        Puntos puntos = new Puntos(20);
        Posicion posicion = new Posicion(1,1);
        Soldado soldado = new Soldado(puntos,posicion);
        soldado.curarse(20);
        Assertions.assertEquals(120, soldado.getVidaUnidad());
    }
    @Test
    public void soldadoAtacaCorrectamenteADistanciaCercana() throws NoAlcanzanLosPuntosException, UnidadNulaException, NoPuedeAtacarException, UnidadInvalidaException {
        Puntos puntos = new Puntos(20);
        HashMap tablero = new HashMap();
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(2,2);
        Soldado soldado = new Soldado(puntos,posicion);
        Soldado soldado1 = new Soldado(puntos,posicion1);
        soldado.atacarDistanciaCerca(soldado1,false,tablero);
        Assertions.assertEquals(90,soldado1.getVidaUnidad());
    }
    @Test
    public void soldadoNoPuedeAtacarCorrectamenteADistanciaMediana() throws NoAlcanzanLosPuntosException, UnidadNulaException, NoPuedeAtacarException, UnidadInvalidaException {
        Puntos puntos = new Puntos(20);
        HashMap tablero = new HashMap();
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(4,4);
        Soldado soldado = new Soldado(puntos,posicion);
        Soldado soldado1 = new Soldado(puntos,posicion1);
        try {
           soldado.atacarDistanciaMediana(soldado1,false,tablero);
        }catch (NoPuedeAtacarException e){
            Assertions.assertEquals("El soldado solo ataca distancia cercana",e.getMessage());
        }

    }
    @Test
    public void soldadoeNoPuedeAtacarCorrectamenteADistanciaLejana() throws NoAlcanzanLosPuntosException, UnidadNulaException, NoPuedeAtacarException, UnidadInvalidaException {
        Puntos puntos = new Puntos(20);
        HashMap tablero = new HashMap();
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(4,4);
        Soldado soldado = new Soldado(puntos,posicion);
        Soldado soldado1 = new Soldado(puntos,posicion1);
        try {
            soldado.atacarDistanciaLejana(soldado1,false,tablero);
        }catch (NoPuedeAtacarException e){
            Assertions.assertEquals("El soldado solo ataca distancia cercana",e.getMessage());
        }
    }

    @Test
    public void soldadoNoPuedeAtacarCorrectamenteAUnidadAliada() throws NoAlcanzanLosPuntosException, UnidadNulaException, NoPuedeAtacarException, UnidadInvalidaException {
        Puntos puntos = new Puntos(20);
        HashMap tablero = new HashMap();
        Posicion posicion = new Posicion(1,1);
        Posicion posicion1 = new Posicion(4,4);
        Soldado soldado = new Soldado(puntos,posicion);
        Soldado soldado1 = new Soldado(puntos,posicion1);
        try {
            soldado.atacarDistanciaCerca(soldado1,true,tablero);
        }catch (UnidadInvalidaException e){
            Assertions.assertEquals("La unidad que quieres atacar es aliada",e.getMessage());
        }
    }

}
