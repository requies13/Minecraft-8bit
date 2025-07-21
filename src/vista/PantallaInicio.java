package vista;

import controlador.ControladorInicio;
import modelo.*;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import java.util.TimerTask;
import java.util.Timer;

public class PantallaInicio extends JFrame implements Observer {
    private static final long serialVersionUID = -9171935669482541465L;

    private JPanel panelMenu;
    private JLabel titulo;
    private JLabel textoMenu;

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
                Image background = new ImageIcon(getClass().getClassLoader().getResource("img/fondo2.png")).getImage();
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
        };
        fondo.setLayout(null); // Para usar posiciones absolutas si deseas

        // Crear panel de menú
        panelMenu = new JPanel();
        panelMenu.setOpaque(false); // Transparente para ver el fondo
        panelMenu.setBounds(0, 0, 960, 600); // Ocupa toda la ventana
        panelMenu.setLayout(null); // Puedes añadir botones aquí
        //panelMenu.add(getTitulo());
        panelMenu.add(getTextoMenu());
        this.startMultiColorText(); //Cambia el color del texto

        // Añadir el panelMenu al fondo
        fondo.add(panelMenu);

        // Asignar fondo como contenido del frame
        setContentPane(fondo);
    }
    private JLabel getTitulo() {
        if (titulo == null) {
            titulo = new JLabel("");
            titulo.setBounds(163, 11, getWidth(), getHeight());
            this.titulo.setIcon(new ImageIcon(this.getClass().getResource("/img/titulo.png")));

        }
        return titulo;
    }
    private JLabel getTextoMenu() {
        if (textoMenu == null) {
            textoMenu = new JLabel("<html><div style='text-align: center;'><br>Press spacebar to start!</div></html>");
            textoMenu.setFont(new Font("Consolas", Font.BOLD, 25));
            textoMenu.setHorizontalAlignment(SwingConstants.CENTER);
            textoMenu.setBounds(48, 353, 800, 140);
        }
        return textoMenu;
    }
    private void startMultiColorText() { //Solo cambia el color del texto
        Timer timer = new Timer();
        Color[] colors = {Color.RED, Color.BLUE, Color.BLACK};
        final int[] index = {0}; // Usamos un array para modificar la variable dentro del Timer

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                SwingUtilities.invokeLater(() -> {
                    textoMenu.setForeground(colors[index[0]]);
                    index[0] = (index[0] + 1) % colors.length; // Cicla entre los colores
                });
            }
        }, 0, 500); // Cambia de color cada 500ms
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