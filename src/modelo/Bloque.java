package modelo;
import java.util.Observable;

public class Bloque extends Observable{

    private int x; //Ancho
    private int y; //Altura
    private int z; //Profundidad

    protected Bloque(int pY, int pX, int pZ) {
        x=pX;
        y=pY;
        z=pZ;
    }
    protected int getX() {return x;}
    protected int getY() {return y;}
    protected int getZ() {return z;}

    protected void setX(int pX) {
            this.x = pX;
        }
    protected void setY(int pY) {
            this.y = pY;
        }
    protected void setZ(int pZ) {
        this.z = pZ;
    }

}
