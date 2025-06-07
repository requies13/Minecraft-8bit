package modelo;

public class BloqueBedrock extends Bloque {
    public BloqueBedrock(int pY, int pX, int pZ) {
        super(pY,pX,pZ,3);
    }

    @Override
    public boolean sePuedeRomper() {
        return false;
    }
}
