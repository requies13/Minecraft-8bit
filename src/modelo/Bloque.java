package modelo;
import java.util.Observable;

public class Bloque extends Observable{

    private int y; //Altura
    private int x; //Ancho
    private int z; //Profundidad
    private int tipoBloque;

    protected Bloque(int pY, int pX, int pZ, int pTipoBloque) {
        y=pY;
        x=pX;
        z=pZ;
        tipoBloque=pTipoBloque;
    }
    protected int getX() {return x;}
    protected int getY() {return y;}
    protected int getZ() {return z;}

    public int getTipoBloque() {return tipoBloque;}

    public boolean sePuedeRomper(){
        return true;
    }

}
