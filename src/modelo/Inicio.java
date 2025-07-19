package modelo;

import java.util.Observable;

public class Inicio extends Observable {
    private static Inicio miInicio = new Inicio();

    private Inicio() {}

    public static Inicio getMiInicio() {
        return miInicio;
    }

    public void Iniciar(){
        setChanged();
        notifyObservers(new Object[] {1});
        Mapa.getMiMapa().crearMapa();
        Jugador.getMiJugador().crearJugador();
        Puntero.getMiPuntero().crearPuntero();
        Inventario.getMiInventario().crearInventario();
    }
}
