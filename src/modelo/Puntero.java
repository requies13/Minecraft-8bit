package modelo;

import java.util.Observable;

public class Puntero extends Observable{
    private static Puntero miPuntero = new Puntero();
    private int y;
    private int x = 0;
    private int z = 0;

    private Puntero() {}
    public static Puntero getMiPuntero() {
            return miPuntero;
    }
    public void crearPuntero() {
        Jugador jugador = Jugador.getMiJugador();
        this.x = jugador.getX() + x;
        this.z = jugador.getZ() + z;
        this.y = jugador.getY(); // mismo nivel
        notificarPuntero();
    }
    public void seguirJugador() {
        Jugador jugador = Jugador.getMiJugador();
        this.x = jugador.getX();
        this.z = jugador.getZ();
        this.y = jugador.getY();
        notificarPuntero();
    }
    public void movimientoL() {
        Jugador jugador = Jugador.getMiJugador();
        if(jugador.getX() ==  x && jugador.getZ() == z) {
            x--;
        } else if(jugador.getX() - 1 ==  x && jugador.getZ() == z){
            z--;
        } else if(jugador.getX() - 1 ==  x && jugador.getZ() - 1 == z){
            x++;
        } else if(jugador.getX() ==  x && jugador.getZ() - 1 == z){
            x++;
        } else if(jugador.getX() + 1 ==  x && jugador.getZ() - 1 == z){
            z++;
        } else if(jugador.getX() + 1 ==  x && jugador.getZ() == z){
            z++;
        } else if(jugador.getX() + 1 ==  x && jugador.getZ() + 1 == z){
            x--;
        } else if(jugador.getX() ==  x && jugador.getZ() + 1 == z){
            x--;
        } else if(jugador.getX() - 1 ==  x && jugador.getZ() + 1 == z){
            x++;
            z--;
        }
        notificarPuntero();
    }

    public void movimientoR() {
        Jugador jugador = Jugador.getMiJugador();
        if(jugador.getX() ==  x && jugador.getZ() == z) {
            x++;
        } else if(jugador.getX() + 1 ==  x && jugador.getZ() == z){
            z--;
        } else if(jugador.getX() + 1 ==  x && jugador.getZ() - 1 == z){
            x--;
        } else if(jugador.getX() ==  x && jugador.getZ() - 1 == z){
            x--;
        } else if(jugador.getX() - 1 ==  x && jugador.getZ() - 1 == z){
            z++;
        } else if(jugador.getX() - 1 ==  x && jugador.getZ() == z){
            z++;
        } else if(jugador.getX() - 1 ==  x && jugador.getZ() + 1 == z){
            x++;
        } else if(jugador.getX() ==  x && jugador.getZ() + 1 == z){
            x++;
        } else if(jugador.getX() + 1 ==  x && jugador.getZ() + 1 == z){
            x--;
            z--;
        }
        notificarPuntero();
    }
    public void movimientoU() {
        if(Jugador.getMiJugador().getY() + 3 > this.y){
            y++;
        }
        notificarPuntero();
    }
    public void movimientoD() {
        if(Jugador.getMiJugador().getY() < this.y){
            y--;
        }
        notificarPuntero();
    }
    public void romperBloque() {
        Mapa.getMiMapa().romperBloque(y,x,z);
    }
    public void ponerBloque() {
        Mapa.getMiMapa().ponerBloque(y,x,z);
    }


    private void notificarPuntero() {
        setChanged();
        notifyObservers(new Object[] {3, y, x, z});
    }
}
