package modelo;
import java.util.Observable;

public class Jugador extends Observable{
        private static Jugador miJugador = new Jugador();
        private int x, y, z;

        private Jugador() {}
        public static Jugador getMiJugador() {
            return miJugador;
        }

        public void crearJugador() {
                this.x = 0;
                this.y = 9;
                this.z = 0;
                notificarJugador(0);
        }

        public void dejarDeMostrarPersonaje(){}

        public void movimientoL() {
                if (Mapa.getMiMapa().hayBloque(x-1,y,z)){
                        x=x-1;
                        System.out.println("left");
                        notificarJugador(1);
                }
        }

        public void movimientoR() {
                if (Mapa.getMiMapa().hayBloque(x+1,y,z)){
                        x=x+1;
                        System.out.println("right");
                        notificarJugador(2);
                }
        }

        public void movimientoU() {
                if (Mapa.getMiMapa().hayBloque(x,y,z-1)){
                        z=z-1;
                        System.out.println("up");
                        notificarJugador(3);
                }
        }

        public void movimientoD() {
                if (Mapa.getMiMapa().hayBloque(x,y,z+1)){
                        z=z+1;
                        System.out.println("down");
                        notificarJugador(4);
                }
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public int getZ() { return this.z; }

        private void notificarJugador(int Dir) {
                setChanged();
                notifyObservers(new Object[] {2, 0, y, x, z});
        }

}
