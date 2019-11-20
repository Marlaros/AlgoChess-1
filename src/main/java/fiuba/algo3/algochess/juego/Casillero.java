package fiuba.algo3.algochess.juego;

import fiuba.algo3.algochess.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algochess.unidades.Unidad;
import fiuba.algo3.algochess.unidades.UnidadNula;

public class Casillero {
    private UnidadNula unidadNula = new UnidadNula(0,0);
    private Unidad unidad_actual = unidadNula;

    public void guardarUnidad(Unidad unidadNueva) {
        unidad_actual = unidadNueva;
   }

    public void modificarUnidad(Unidad unidadNueva) throws CasilleroOcupadoException {
        //Si la unidad almacenada no es una unidad nula lanza error
        if(!unidad_actual.getClass().equals(unidadNula.getClass())){
            throw new CasilleroOcupadoException("El casillero esta ocupado");
        }
        unidad_actual = unidadNueva;
   }


   public Unidad getUnidad(){
       return unidad_actual;
   }

   public void eliminarUnidad(){
        unidad_actual = unidadNula;
   }
}