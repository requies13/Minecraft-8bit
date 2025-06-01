package modelo;
import java.util.Observable;

public class Bloque extends Observable{

        private int x;
        private int y;

        protected Bloque(int pY, int pX) {
            x=pX;
            y=pY;
        }
        protected int getX() {return x;}
        protected int getY() {return y;}

        protected void setX(int pX) {
            this.x = pX;
        }
        protected void setY(int pY) {
            this.y = pY;
        }

}
