package vista;

import javax.swing.*;
import java.awt.*;

public class InventarioVisual extends JPanel {
    private BloqueVisual[] lista = new BloqueVisual[9];  // 9 espacios de inventario
    private int seleccionado = 0;
    private Image invent = new ImageIcon(getClass().getClassLoader().getResource("img/inventario.png")).getImage();

    public InventarioVisual() {
        setPreferredSize(new Dimension(432, 48)); // 9 espacios de 32px
        setOpaque(false);  // Deja que el fondo se pinte con transparencia
    }

    public void setBloque(int indice, BloqueVisual bloque) {
        if (indice >= 0 && indice < lista.length) {
            lista[indice] = bloque;
            repaint();
        }
    }

    public void seleccionar(int indice) {
        if (indice >= 0 && indice < lista.length) {
            seleccionado = indice;
            repaint();
        }
    }

    public BloqueVisual getBloqueSeleccionado() {
        return lista[seleccionado];
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Fondo del inventario
        g.drawImage(invent, 0, 0, 432, 48, this);

        Graphics2D g2 = (Graphics2D) g.create();

        for (int i = 0; i < lista.length; i++) {
            BloqueVisual b = lista[i];
            int slotX = i * 48 + 6; // Centrado y con separación mayor
            int slotY = 8 - 4;

            if (b != null && b.getImagen() != null) {
                g.drawImage(b.getImagen(), slotX + 4, slotY + 4, 32, 32, this); // Imagen centrada dentro del slot
            }

            if (i == seleccionado) {
                // Recuadro de selección grueso
                g2.setColor(new Color(0, 255, 0));
                g2.setStroke(new BasicStroke(4f)); // Grosor del borde
                g2.drawRoundRect(slotX + 1, slotY + 2, 38, 36, 8, 8); // Un poco más grande que el slot
            }
        }

        g2.dispose();
    }
}