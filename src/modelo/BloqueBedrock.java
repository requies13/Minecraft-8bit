package modelo;

public class BloqueBedrock extends Bloque {
    public BloqueBedrock(int pY, int pX, int pZ) {
        super(pY,pX,pZ);
    }

    @Override
    public boolean sePuedeRomper() {
        return false;
    }
}
