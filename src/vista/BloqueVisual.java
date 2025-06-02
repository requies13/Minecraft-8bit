package vista;

import java.awt.*;

public class BloqueVisual {
    private int x, y, z;
    private Image imagen;

    public BloqueVisual(int x, int y, int z, Image imagen) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.imagen = imagen;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getZ() {
        return z;
    }
    public Image getImagen() {
        return imagen;
    }
}
