package vista;

import controlador.ControladorJuego;
import modelo.Mapa;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class VistaJuego extends JFrame implements Observer {
    private static final long serialVersionUID = -5000978209518964435L;
    private JPanel contentPane;
    private JLabel[][] labels;

    public VistaJuego() {
        this.addKeyListener(ControladorJuego.getControlador());  		// Agregar el KeyListener al JFrame en lugar del JPanel
        Mapa.getMiMapa().addObserver(this);
        setResizable(false);
        this.crearPaneles();
    }

    protected JLabel[][] getLabels() {
        return this.labels;
    }

    private void crearPaneles() {
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new GridLayout(16, 16, 0, 0));

        // Crear matriz de etiquetas
        labels = new JLabel[16][16];

        for (int y = 0; y < 16; y++) {
            for (int x = 0; x < 16; x++) {
                labels[y][x] = new JLabel("■"); // o "", o cualquier símbolo de bloque
                labels[y][x].setHorizontalAlignment(SwingConstants.CENTER);
                labels[y][x].setOpaque(true);
                labels[y][x].setBackground(Color.LIGHT_GRAY); // Fondo por defecto
                contentPane.add(labels[y][x]);
            }
        }

        setContentPane(contentPane);
    }


    private void pintarMapa(Object[] array) {
        int numeroEntrada = (int) array[1];
        int y = (int) array[2];
        int x = (int) array[3];

        if (numeroEntrada == 0) { // Bloque vacío
            labels[y][x].setBackground(Color.BLUE);
            labels[y][x].setText("Air");
        }
        else if (numeroEntrada == 1) { // Tierra
            labels[y][x].setBackground(new Color(139, 69, 19)); // Marrón
            labels[y][x].setText("■"); // Opcional
        }

    }

    @Override
    public void update(Observable o, Object arg) {
        // TODO Auto-generated method stub
        Object[] array = (Object[]) arg;
        int quienLlama = (int) array[0];
        if (quienLlama == 1) {
            this.pintarMapa(array);
        }
    }
}
