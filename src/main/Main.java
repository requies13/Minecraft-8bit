package main;

import modelo.Mapa;
import vista.VistaJuego;

import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    VistaJuego vista = new VistaJuego();
                    vista.setSize(720, 480);
                    vista.setVisible(true);
                    Mapa.getMiMapa().crearMapa();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}