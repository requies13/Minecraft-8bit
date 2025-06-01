package modelo;

import java.util.Observable;

public class Mapa extends Observable {
    private static Mapa miMapa = new Mapa();
    private Chunk[][] tablero;

    private Mapa() {}

    public static Mapa getMiMapa() {
        return miMapa;
    }

    public void crearMapa() {
        Chunk chunk = new Chunk();
    }
    public void notificarCambio(int tipoBloque, int y, int x) {
        setChanged();
        notifyObservers(new Object[] {1, tipoBloque, y, x});
    }
}
