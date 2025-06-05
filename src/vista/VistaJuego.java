package vista;

import controlador.ControladorJuego;
import modelo.Jugador;
import modelo.Mapa;
import modelo.Puntero;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class VistaJuego extends JFrame implements Observer {
    private static final long serialVersionUID = -5000978209518964435L;
    private PanelIsometrico paneles;
    private Image tierraImg = new ImageIcon(getClass().getClassLoader().getResource("img/tierra.png")).getImage();
    private Image tierra2Img = new ImageIcon(getClass().getClassLoader().getResource("img/tierra2.png")).getImage();
    private Image jugadorImg = new ImageIcon(getClass().getClassLoader().getResource("img/jugador.png")).getImage();
    private Image punteroImg = new ImageIcon(getClass().getClassLoader().getResource("img/opcion1.png")).getImage();

    public VistaJuego() {
        this.addKeyListener(ControladorJuego.getControlador());  		// Agregar el KeyListener al JFrame en lugar del JPanel
        Mapa.getMiMapa().addObserver(this);
        Jugador.getMiJugador().addObserver(this);
        Puntero.getMiPuntero().addObserver(this);
        setTitle("Minecraft-8bit");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        this.crearPaneles();
    }

    private void crearPaneles() {
        paneles = new PanelIsometrico();
        add(paneles);
        paneles.setPreferredSize(new Dimension(1200, 800));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        // TODO Auto-generated method stub
        Object[] array = (Object[]) arg;
        int quienLlama = (int) array[0];
        if (quienLlama == 1) {
            this.pintarMapa(array);
        } else if (quienLlama == 2) {
            this.pintarJugador(array);
        } else if (quienLlama == 3) {
            this.pintarPuntero(array);
        }
    }
    private void pintarMapa(Object[] array) {
        int numeroEntrada = (int) array[1];
        int y = (int) array[2];
        int x = (int) array[3];
        int z = (int) array[4];
        BloqueVisual bloque = null;

        if (numeroEntrada == 0) { // Bloque de Aire
            BloqueVisual bloque2 = paneles.buscarBloque(y,x,z);
            if(bloque2 != null){
                paneles.quitarBloque(bloque2);
            }
        }
        else if (numeroEntrada == 1) { // Bloque de Tierra
            bloque = new BloqueVisual(y, x, z, tierraImg);
            paneles.agregarBloque(bloque);
        }
        else if (numeroEntrada == 2) { // Bloque de Tierra2
            bloque = new BloqueVisual(y, x, z, tierra2Img);
            paneles.agregarBloque(bloque);
        }
    }
    private void pintarJugador(Object[] array) {
        int numeroEntrada = (int) array[1];
        int y = (int) array[2];
        int x = (int) array[3];
        int z = (int) array[4];
        JugadorVisual jugador = null;
        paneles.setJugador(null);

        if (numeroEntrada == 0) { // Spawneo
            jugador = new JugadorVisual(y, x, z, jugadorImg);
            paneles.setJugador(jugador);
        }
    }
    private void pintarPuntero(Object[] array) {
        int y = (int) array[1];
        int x = (int) array[2];
        int z = (int) array[3];

        PunteroVisual puntero = null;
        paneles.setPuntero(null);
        puntero = new PunteroVisual(y, x, z, punteroImg);
        paneles.setPuntero(puntero);
    }
}
