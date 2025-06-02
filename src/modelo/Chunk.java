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
                        if (y > 8) {
                            blocks[y][x][z] = GenBloques.getMiGenBloques().generar("Vacio", y, x, z);
                            int absX = pX * 16 + x;
                            int absZ = pZ * 16 + z;
                            Mapa.getMiMapa().notificarCambio(0, y, absX, absZ);
                        } else if (y == 8) {
                            blocks[y][x][z] = GenBloques.getMiGenBloques().generar("Tierra", y, x, z);
                            int absX = pX * 16 + x;
                            int absZ = pZ * 16 + z;
                            Mapa.getMiMapa().notificarCambio(1, y, absX, absZ);
                        } else {
                            blocks[y][x][z] = GenBloques.getMiGenBloques().generar("Tierra2", y, x, z);
                            int absX = pX * 16 + x;
                            int absZ = pZ * 16 + z;
                            Mapa.getMiMapa().notificarCambio(2, y, absX, absZ);
                        }
                    }
                }
            }
        } else if(pId == 2) {
            for (int y = 0; y < 16; y++) {
                for (int x = 0; x < 16; x++) {
                    for (int z = 0; z < 16; z++) {
                        if (y > 8) {
                            blocks[y][x][z] = GenBloques.getMiGenBloques().generar("Vacio", y, x, z);
                            int absX = pX * 16 + x;
                            int absZ = pZ * 16 + z;
                            Mapa.getMiMapa().notificarCambio(0, y, absX, absZ);
                        } else {
                            blocks[y][x][z] = GenBloques.getMiGenBloques().generar("Tierra2", y, x, z);
                            int absX = pX * 16 + x;
                            int absZ = pZ * 16 + z;
                            Mapa.getMiMapa().notificarCambio(2, y, absX, absZ);
                        }
                    }
                }
            }
        }
        this.id = pId;
    }

    public boolean hayBloque(int x, int y, int z) {
        return blocks[x][y][z] != null && !(blocks[x][y][z] instanceof BloqueVacio);
    }
}
