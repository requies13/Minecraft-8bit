package vista;

import java.awt.*;

public class JugadorVisual {
    private int x, y, z;
    private Image imagen;
    private Image imagen2;

    public JugadorVisual(int y, int x, int z, Image imagen, Image imagen2) {
        this.y = y;
        this.x = x;
        this.z = z;
        this.imagen = imagen;
        this.imagen2 = imagen2;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getZ() { return z; }
    public Image getImagen() { return imagen; }
    public Image getImagen2() { return imagen2; }

    public void mover(int dy, int dx, int dz) {
        y += dy;
        x += dx;
        z += dz;
    }
}

