package main;

import modelo.Jugador;
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
                    vista.setSize(1200, 800);
                    vista.setVisible(true);
                    Mapa.getMiMapa().crearMapa();
                    Jugador.getMiJugador().crearJugador();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}