package controlador;

import modelo.Jugador;
import modelo.Puntero;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class ControladorJuego implements KeyListener {

    public static ControladorJuego miControlador = new ControladorJuego();


    public static ControladorJuego getControlador() {
        return miControlador;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_RIGHT) {
            Jugador.getMiJugador().movimientoR();
        }
        else if(keyCode == KeyEvent.VK_LEFT) {
            Jugador.getMiJugador().movimientoL();
        }
        else if(keyCode == KeyEvent.VK_UP) {
            Jugador.getMiJugador().movimientoU();
        }
        else if(keyCode == KeyEvent.VK_DOWN) {
            Jugador.getMiJugador().movimientoD();
        }
        else if(keyCode == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
        else if(keyCode == KeyEvent.VK_A) {
            Puntero.getMiPuntero().movimientoL();
        }
        else if(keyCode == KeyEvent.VK_D) {
            Puntero.getMiPuntero().movimientoR();
        }
        else if(keyCode == KeyEvent.VK_W) {
            Puntero.getMiPuntero().movimientoU();
        }
        else if(keyCode == KeyEvent.VK_S) {
            Puntero.getMiPuntero().movimientoD();
        }
        else if(keyCode == KeyEvent.VK_ENTER) {
            Puntero.getMiPuntero().romperBloque();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
