package modelo;

import java.util.Observable;

public class Chunk {
    private Bloque[][][] blocks = new Bloque[16][16][16];
    private int id;

    public Chunk(int pId, int pX, int pZ) {
        if(pId == 1) {
            for (int y = 0; y < 16; y++) {
                for (int x = 0; x < 16; x++) {
                    for (int z = 0; z < 16; z++) {
                        if (y > 9) {
                            blocks[y][x][z] = GenBloques.getMiGenBloques().generar("Vacio", y, x, z);
                            int absX = pX * 16 + x;
                            int absZ = pZ * 16 + z;
                            Mapa.getMiMapa().notificarCambio(blocks[y][x][z].getTipoBloque(), y, absX, absZ);
                        } else if (y == 9) {
                            blocks[y][x][z] = GenBloques.getMiGenBloques().generar("Tierra", y, x, z);
                            int absX = pX * 16 + x;
                            int absZ = pZ * 16 + z;
                            Mapa.getMiMapa().notificarCambio(blocks[y][x][z].getTipoBloque(), y, absX, absZ);
                        } else if (y == 0) {
                            blocks[y][x][z] = GenBloques.getMiGenBloques().generar("Bedrock", y, x, z);
                            int absX = pX * 16 + x;
                            int absZ = pZ * 16 + z;
                            Mapa.getMiMapa().notificarCambio(blocks[y][x][z].getTipoBloque(), y, absX, absZ);
                        } else {
                            blocks[y][x][z] = GenBloques.getMiGenBloques().generar("Tierra2", y, x, z);
                            int absX = pX * 16 + x;
                            int absZ = pZ * 16 + z;
                            Mapa.getMiMapa().notificarCambio(blocks[y][x][z].getTipoBloque(), y, absX, absZ);
                        }
                    }
                }
            }
        } else if(pId == 2) {
            for (int y = 0; y < 16; y++) {
                for (int x = 0; x < 16; x++) {
                    for (int z = 0; z < 16; z++) {
                        if (y > 4) {
                            blocks[y][x][z] = GenBloques.getMiGenBloques().generar("Vacio", y, x, z);
                            int absX = pX * 16 + x;
                            int absZ = pZ * 16 + z;
                            Mapa.getMiMapa().notificarCambio(blocks[y][x][z].getTipoBloque(), y, absX, absZ);
                        } else if (y == 0) {
                            blocks[y][x][z] = GenBloques.getMiGenBloques().generar("Bedrock", y, x, z);
                            int absX = pX * 16 + x;
                            int absZ = pZ * 16 + z;
                            Mapa.getMiMapa().notificarCambio(blocks[y][x][z].getTipoBloque(), y, absX, absZ);
                        } else {
                            blocks[y][x][z] = GenBloques.getMiGenBloques().generar("Tierra2", y, x, z);
                            int absX = pX * 16 + x;
                            int absZ = pZ * 16 + z;
                            Mapa.getMiMapa().notificarCambio(blocks[y][x][z].getTipoBloque(), y, absX, absZ);
                        }
                    }
                }
            }
        }
        this.id = pId;
    }

    public boolean hayBloquesEncima(int y, int x, int z) {

        int localX = x % 16;
        int localY = y % 16;
        int localZ = z % 16;

        if(localY == 15){
            return false;
        } else if (blocks[localY+1][localX][localZ] instanceof BloqueVacio) {
            return false;
        }
        return true;
    }

    public boolean esBloqueSolido(int y, int x, int z) {

        int localX = x % 16;
        int localY = y % 16;
        int localZ = z % 16;

        if(blocks[localY][localX][localZ] instanceof BloqueVacio) {
            return false;
        }
        return true;
    }
    public void romperBloque(int y, int x, int z) {

        int localX = x % 16;
        int localY = y % 16;
        int localZ = z % 16;

        if(blocks[localY][localX][localZ].sePuedeRomper()) {
            blocks[localY][localX][localZ] = GenBloques.getMiGenBloques().generar("Vacio", localY, localX, localZ);
            Jugador.getMiJugador().movimientoBloqueRoto();
            Mapa.getMiMapa().notificarCambio(blocks[localY][localX][localZ].getTipoBloque(), y, x, z);
        }
    }
    public void ponerBloque(int y, int x, int z) {

        int localX = x % 16;
        int localY = y % 16;
        int localZ = z % 16;

        if(blocks[localY][localX][localZ] instanceof BloqueVacio) {
            Bloque b = Inventario.getMiInventario().getObjeto();
            String bloqueAGenerar = GenBloques.getMiGenBloques().queBloqueEs(b);
            blocks[localY][localX][localZ] = GenBloques.getMiGenBloques().generar(bloqueAGenerar, localY, localX, localZ);
            Mapa.getMiMapa().notificarCambio(blocks[localY][localX][localZ].getTipoBloque(), y, x, z);
        }
    }
}
