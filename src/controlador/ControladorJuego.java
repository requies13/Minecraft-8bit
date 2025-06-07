package controlador;

import modelo.Inventario;
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
        else if(keyCode == KeyEvent.VK_1) {
            Inventario.getMiInventario().seleccionarObjeto(0);
        }
        else if(keyCode == KeyEvent.VK_2) {
            Inventario.getMiInventario().seleccionarObjeto(1);
        }
        else if(keyCode == KeyEvent.VK_3) {
            Inventario.getMiInventario().seleccionarObjeto(2);
        }
        else if(keyCode == KeyEvent.VK_4) {
            Inventario.getMiInventario().seleccionarObjeto(3);
        }
        else if(keyCode == KeyEvent.VK_5) {
            Inventario.getMiInventario().seleccionarObjeto(4);
        }
        else if(keyCode == KeyEvent.VK_6) {
            Inventario.getMiInventario().seleccionarObjeto(5);
        }
        else if(keyCode == KeyEvent.VK_7) {
            Inventario.getMiInventario().seleccionarObjeto(6);
        }
        else if(keyCode == KeyEvent.VK_8) {
            Inventario.getMiInventario().seleccionarObjeto(7);
        }
        else if(keyCode == KeyEvent.VK_9) {
            Inventario.getMiInventario().seleccionarObjeto(8);
        }
        else if(keyCode == KeyEvent.VK_SPACE) {
            Puntero.getMiPuntero().ponerBloque();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
