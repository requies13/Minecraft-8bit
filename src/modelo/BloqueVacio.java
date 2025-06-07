package modelo;

public class BloqueVacio extends Bloque {
    public BloqueVacio(int pY, int pX, int pZ) {
        super(pY,pX,pZ,0);
    }

    @Override
    public boolean sePuedeRomper() {
        return false;
    }
}
