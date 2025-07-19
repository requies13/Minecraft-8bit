package main;

import modelo.*;
import vista.PantallaInicio;
import vista.VistaJuego;

import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PantallaInicio inicio = new PantallaInicio();
                    inicio.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}