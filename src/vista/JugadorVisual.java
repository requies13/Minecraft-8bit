package vista;

import java.awt.*;

public class JugadorVisual {
    private int x, y, z;
    private Image imagen;

    public JugadorVisual(int x, int y, int z, Image imagen) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.imagen = imagen;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getZ() { return z; }
    public Image getImagen() { return imagen; }

    public void mover(int dx, int dy, int dz) {
        x += dx;
        y += dy;
        z += dz;
    }
}

