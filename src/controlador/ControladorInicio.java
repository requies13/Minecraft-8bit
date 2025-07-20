package controlador;

import modelo.Inicio;
import modelo.Inventario;
import modelo.Jugador;
import modelo.Puntero;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControladorInicio implements KeyListener {

    public static ControladorInicio miControlador = new ControladorInicio();


    public static ControladorInicio getControlador() {
        return miControlador;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE) {
            Inicio.getMiInicio().Iniciar();
        } else if(keyCode == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
