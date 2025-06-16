package vista;

import modelo.Bloque;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class PanelIsometrico extends JPanel {
    private java.util.List<BloqueVisual> bloques = new ArrayList<>();
    private JugadorVisual jugador;
    private PunteroVisual puntero;

    public void setJugador(JugadorVisual jugador) {
        this.jugador = jugador;
        repaint();
    }

    public void setPuntero(PunteroVisual puntero) {
        this.puntero = puntero;
        repaint();
    }

    public void agregarBloque(BloqueVisual b) {
        bloques.add(b);
        repaint();
    }
    private Iterator<BloqueVisual> getIterador()
    {
        return this.bloques.iterator();
    }
    public BloqueVisual buscarBloque(int y, int x, int z) {
        BloqueVisual bloque=null;
        BloqueVisual bloque2=null;
        Boolean enc = false;
        Iterator<BloqueVisual>itr=this.getIterador();
        while(itr.hasNext() && !enc)
        {
            bloque=itr.next();
            if (bloque.getY() == y && bloque.getX() == x && bloque.getZ() == z)
            {
                enc=true;
                bloque2= bloque;
            }
        }
        return bloque2;
    }
    public void quitarBloque(BloqueVisual b) {
        bloques.remove(b);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);

        int tileWidth = 32;
        int tileHeight = 16;
        int offsetX = getWidth() / 2;
        int offsetY = getHeight() / 2;

        bloques.sort((b1, b2) -> {
            int b1Order = (b1.getX() + b1.getZ()) + b1.getY() * 1000;
            int b2Order = (b2.getX() + b2.getZ()) + b2.getY() * 1000;
            return Integer.compare(b1Order, b2Order);
        });


        for (BloqueVisual b : bloques) {
            int screenX = (b.getX() - b.getZ()) * tileWidth / 2 + offsetX;
            int screenY = (b.getX() + b.getZ()) * tileHeight / 2 - b.getY() * tileHeight + offsetY;

            g.drawImage(
                    b.getImagen(),
                    screenX - tileWidth / 2,
                    screenY - (b.getImagen().getHeight(null) - tileHeight),
                    b.getImagen().getWidth(null),
                    b.getImagen().getHeight(null),
                    this
            );

            if(puntero != null ){
                screenX = (puntero.getX() - puntero.getZ()) * tileWidth / 2 + offsetX;
                screenY = (puntero.getX() + puntero.getZ()) * tileHeight / 2 - puntero.getY() * tileHeight + offsetY;
                g.drawImage(
                        puntero.getImagen(),
                        screenX - tileWidth / 2,
                        screenY - (puntero.getImagen().getHeight(null) - tileHeight),
                        puntero.getImagen().getWidth(null),
                        puntero.getImagen().getHeight(null),
                        this
                );
            }

            if (jugador != null && jugador.getX() == b.getX() &&
                    jugador.getY() == b.getY() &&
                    jugador.getZ() == b.getZ()) {
                screenX = (jugador.getX() - jugador.getZ()) * tileWidth / 2 + offsetX;
                screenY = (jugador.getX() + jugador.getZ()) * tileHeight / 2 - jugador.getY() * tileHeight + offsetY;
                g.drawImage(jugador.getImagen(), screenX - tileWidth / 2, screenY - 52, tileWidth, 48, this);
//            } else{
//                screenX = (jugador.getX() - jugador.getZ()) * tileWidth / 2 + offsetX;
//                screenY = (jugador.getX() + jugador.getZ()) * tileHeight / 2 - jugador.getY() * tileHeight + offsetY;
//                g.drawImage(jugador.getImagen2(), screenX - tileWidth / 2, screenY - 52, tileWidth, 48, this);
            }
        }
    }
}
