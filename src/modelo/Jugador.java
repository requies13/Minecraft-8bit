package modelo;
import java.util.Observable;

public class Jugador extends Observable{
        private static Jugador miJugador = new Jugador();
        private int x, y, z;
        private int maxAltura = 10;

        private Jugador() {}
        public static Jugador getMiJugador() {
            return miJugador;
        }

        public void crearJugador() {
                this.y = 9;
                this.x = 0;
                this.z = 0;
                notificarJugador(0);
        }

        public void movimientoL() {
                int i = 1;
                if (Mapa.getMiMapa().hayBloque(y,x-1,z)){
                        if(!Mapa.getMiMapa().hayBloquesEncima(y,x-1,z)) {
                                while (!Mapa.getMiMapa().esBloqueSolido(y, x - 1, z) && i < maxAltura) {
                                        y = y - 1;
                                        i++;
                                }
                                x = x - 1;
                                System.out.println("left");
                                notificarJugador(1);
                        } else {
                                while (Mapa.getMiMapa().esBloqueSolido(y, x - 1, z) && i < maxAltura) {
                                        y = y + 1;
                                        i++;
                                }
                                y = y - 1;
                                x = x - 1;
                                System.out.println("left");
                                notificarJugador(1);
                        }
                }
        }

        public void movimientoR() {
                int i = 1;
                if (Mapa.getMiMapa().hayBloque(y,x+1,z)) {
                        if (!Mapa.getMiMapa().hayBloquesEncima(y, x + 1, z)) {
                                while (!Mapa.getMiMapa().esBloqueSolido(y, x + 1, z) && i < maxAltura) {
                                        y = y - 1;
                                        i++;
                                }
                                x = x + 1;
                                System.out.println("right");
                                notificarJugador(2);
                        } else {
                                while (Mapa.getMiMapa().esBloqueSolido(y, x + 1, z) && i < maxAltura) {
                                        y = y + 1;
                                        i++;
                                }
                                y = y - 1;
                                x = x + 1;
                                System.out.println("right");
                                notificarJugador(2);
                        }
                }
        }

        public void movimientoU() {
                int i = 1;
                if (Mapa.getMiMapa().hayBloque(y,x,z-1)) {
                        if (!Mapa.getMiMapa().hayBloquesEncima(y, x, z-1)) {
                                while (!Mapa.getMiMapa().esBloqueSolido(y, x, z-1) && i < maxAltura) {
                                        y = y - 1;
                                        i++;
                                }
                                z=z-1;
                                System.out.println("up");
                                notificarJugador(3);
                        } else {
                                while (Mapa.getMiMapa().esBloqueSolido(y, x, z-1) && i < maxAltura) {
                                        y = y + 1;
                                        i++;
                                }
                                y = y - 1;
                                z=z-1;
                                System.out.println("up");
                                notificarJugador(3);
                        }
                }
        }

        public void movimientoD() {
                int i = 1;
                if (Mapa.getMiMapa().hayBloque(y,x,z+1)) {
                        if (!Mapa.getMiMapa().hayBloquesEncima(y, x, z+1)) {
                                while (!Mapa.getMiMapa().esBloqueSolido(y, x, z+1) && i < maxAltura) {
                                        y = y - 1;
                                        i++;
                                }
                                z=z+1;
                                System.out.println("down");
                                notificarJugador(4);
                        } else {
                                while (Mapa.getMiMapa().esBloqueSolido(y, x, z+1) && i < maxAltura) {
                                        y = y + 1;
                                        i++;
                                }
                                y = y - 1;
                                z=z+1;
                                System.out.println("down");
                                notificarJugador(4);
                        }
                }
        }
        public int getX() {return x;}

        public int getY() {return y;}

        public int getZ() {return z;}

        private void notificarJugador(int Dir) {
                Puntero.getMiPuntero().seguirJugador();
                setChanged();
                notifyObservers(new Object[] {2, 0, y, x, z});
        }

}
