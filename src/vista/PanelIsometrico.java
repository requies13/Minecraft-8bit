package vista;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelIsometrico extends JPanel {
    private java.util.List<BloqueVisual> bloques = new ArrayList<>();
    private JugadorVisual jugador;

    public void setJugador(JugadorVisual jugador) {
        this.jugador = jugador;
        repaint();
    }

    public void agregarBloque(BloqueVisual b) {
        bloques.add(b);
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

            if (jugador != null && jugador.getX() == b.getX() &&
                    jugador.getY() == b.getY() &&
                    jugador.getZ() == b.getZ()) {
                screenX = (jugador.getX() - jugador.getZ()) * tileWidth / 2 + offsetX;
                screenY = (jugador.getX() + jugador.getZ()) * tileHeight / 2 - jugador.getY() * tileHeight + offsetY;
                g.drawImage(jugador.getImagen(), screenX - tileWidth / 2, screenY - 52, tileWidth, 48, this);
            }
        }
    }
}
