package modelo;

import java.lang.reflect.Array;
import java.util.Observable;

public class Inventario extends Observable{
    private static Inventario miInventario = new Inventario();
    private Bloque[] lista = new Bloque[9];
    private int seleccionado = 0;

    private Inventario() {}

    public static Inventario getMiInventario() {
            return miInventario;
    }

    public void crearInventario() {
        notificarInventario(seleccionado);
        notificarInventario(seleccionado + 1);
        notificarInventario(seleccionado + 2);
    }
    public void seleccionarObjeto(int numero){
        seleccionado = numero;
        notificarCambio(seleccionado);
    }

    private void notificarInventario(int pos) {
        setChanged();
        notifyObservers(new Object[] {4, pos});
    }
    private void notificarCambio(int pos) {
        setChanged();
        notifyObservers(new Object[] {5, pos});
    }
}
