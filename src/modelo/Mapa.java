package modelo;

import java.util.Observable;

public class Mapa extends Observable {
    private static Mapa miMapa = new Mapa();
    private Chunk[][] tablero = new Chunk[2][2];

    private Mapa() {}

    public static Mapa getMiMapa() {
        return miMapa;
    }

    public void crearMapa() {
        for (int x = 0; x < tablero.length; x++) {
            for (int z = 0; z < tablero[0].length; z++) {
                if((x==1 && z==1) || (x==0 && z==0)) {
                    tablero[x][z] = new Chunk(1, x, z); // podrías pasar el índice si necesitas variar contenido
                } else {
                    tablero[x][z] = new Chunk(2, x, z);
                }
            }
        }
    }
    public boolean hayBloque(int x, int y, int z) {
        return tablero[0][0].hayBloque(x,y,z);
    }

    public void notificarCambio(int tipoBloque, int y, int x, int z) {
        setChanged();
        notifyObservers(new Object[] {1, tipoBloque, y, x, z});
    }
}
