package vista;

import controlador.ControladorInicio;
import modelo.*;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class PantallaInicio extends JFrame implements Observer {
    private static final long serialVersionUID = -9171935669482541465L;

    private JPanel panelMenu;

    public PantallaInicio() {
        setTitle("Minecraft-8bit");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(960, 600); // Asignar tamaño fijo
        setLocationRelativeTo(null); // Centrar la ventana

        inicializarComponentes();
        setVisible(true); // Mostrar la ventana al final

        // Observador y control de teclado
        this.addKeyListener(ControladorInicio.getControlador());
        Inicio.getMiInicio().addObserver(this);
    }

    private void inicializarComponentes() {
        // Crear panel de fondo personalizado
        JPanel fondo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image background = new ImageIcon(getClass().getClassLoader().getResource("img/fondo.png")).getImage();
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
        };
        fondo.setLayout(null); // Para usar posiciones absolutas si deseas

        // Crear panel de menú
        panelMenu = new JPanel();
        panelMenu.setOpaque(false); // Transparente para ver el fondo
        panelMenu.setBounds(0, 0, 960, 600); // Ocupa toda la ventana
        panelMenu.setLayout(null); // Puedes añadir botones aquí

        // Añadir el panelMenu al fondo
        fondo.add(panelMenu);

        // Asignar fondo como contenido del frame
        setContentPane(fondo);
    }

    @Override
    public void update(Observable o, Object arg) {
        Object[] array = (Object[]) arg;
        int quienLlama = (int) array[0];
        if (quienLlama == 1) {
            this.iniciarJuego(array);
        }
    }

    private void iniciarJuego(Object[] array) {
        VistaJuego frame = new VistaJuego();
        frame.setVisible(true);
        this.setVisible(false);
    }
}