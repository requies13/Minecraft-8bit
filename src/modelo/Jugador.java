package modelo;
import java.util.Observable;

public class Jugador extends Observable{
        private static Jugador miJugador = new Jugador();
        private int x, y;

        private Jugador() {
                this.x = 0;
                this.y = 0;
        }
        public static Jugador getMiJugador() {
            return miJugador;
        }

        public void dejarDeMostrarPersonaje(){}

        public void mostrarPersonajeUp(){}

        public void mostrarPersonajeLeft(){}

        public void mostrarPersonajeRight(){}

        public void mostrarPersonaje(){}


        public void movimientoL() {
        }

        public void movimientoR() {
        }

        public void movimientoU() {
        }

        public void movimientoD() {
        }

        protected int getX() {
            return this.x;
        }

        protected int getY() {
            return this.y;
        }

}
