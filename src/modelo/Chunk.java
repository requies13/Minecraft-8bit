package modelo;

import java.util.Observable;

public class Chunk {
    Bloque[][] blocks = new Bloque[16][16];

    public Chunk() {
        for (int y = 0; y < 16; y++) {
            for (int x = 0; x < 16; x++) {
                if(y < 8) {
                    blocks[y][x] = GenBloques.getMiGenBloques().generar("Vacio", y, x);
                    Mapa.getMiMapa().notificarCambio(0, y, x);
                } else  {
                    blocks[y][x] = GenBloques.getMiGenBloques().generar("Tierra", y, x);
                    Mapa.getMiMapa().notificarCambio(1, y, x);
                }
            }
        }
    }
}
