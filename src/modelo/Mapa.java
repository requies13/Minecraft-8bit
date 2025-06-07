package modelo;

import java.util.Observable;

public class Mapa extends Observable {
    private static Mapa miMapa = new Mapa();
    private int chunkX = 2;
    private int chunkZ = 2;
    private Chunk[][] tablero = new Chunk[chunkX][chunkZ];


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
    public boolean hayBloque(int y, int x, int z) {
        int nX = x / 16;
        int nY = y / 16;
        int nZ = z / 16;
        if ((x<0 || z<0)) {
            return false;
        } else if ((nX>chunkX-1 || nZ>chunkZ-1)) {
            return false;
        }
        return true;
    }
    public boolean hayBloquesEncima(int y, int x, int z) {
        int nX = x / 16;
        int nY = y / 16;
        int nZ = z / 16;
        if(tablero[nX][nZ].hayBloquesEncima(y,x,z)){
            return true;
        }
        return false;
    }

    public boolean esBloqueSolido(int y, int x, int z) {
        int nX = x / 16;
        int nY = y / 16;
        int nZ = z / 16;
        if(tablero[nX][nZ].esBloqueSolido(y,x,z)){
            return true;
        }
        return false;
    }
    public void romperBloque(int y, int x, int z) {
        int nX = x / 16;
        int nY = y / 16;
        int nZ = z / 16;
        tablero[nX][nZ].romperBloque(y,x,z);
    }
    public void ponerBloque(int y, int x, int z) {
        int nX = x / 16;
        int nY = y / 16;
        int nZ = z / 16;
        if (nX >= 0 && nX < chunkX && nZ >= 0 && nZ < chunkZ) {
            tablero[nX][nZ].ponerBloque(y,x,z);
        }
    }

    public void notificarCambio(int tipoBloque, int y, int x, int z) {
        setChanged();
        notifyObservers(new Object[] {1, tipoBloque, y, x, z});
    }
}
