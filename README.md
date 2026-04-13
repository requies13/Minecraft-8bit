# Minecraft-8bit

Minecraft-8bit es un juego en 2.5D (vista isométrica) desarrollado en **Java** e inspirado en las mecánicas clásicas de construcción y exploración de Minecraft. El proyecto está construido bajo una arquitectura **Modelo-Vista-Controlador (MVC)**, utilizando programación orientada a objetos pura y las bibliotecas gráficas nativas de Java (Swing/AWT) para la renderización.

## 🚀 Características Principales

* **Motor Gráfico Isométrico Personalizado:** Renderizado del mapa en perspectiva isométrica utilizando una cuadrícula tridimensional y escalado de texturas sin antialiasing para mantener una estética "pixel art" o de 8 bits.
* **Sistema de Chunks:** El mapa se genera en "chunks" de 16x16x16, apilando diferentes capas de bloques base (Bedrock, Tierra, etc.).
* **Interacción Separada:** El movimiento del personaje es independiente de la mirilla (puntero) con la que se interactúa con el mundo.
* **Mecánicas de Juego:**
  * Movimiento del jugador con sistema de detección de colisiones y cambios de altura (subir y bajar bloques automáticamente).
  * Capacidad de destruir (minar) bloques.
  * Capacidad de construir (poner) bloques basándose en el ítem seleccionado.
* **Inventario Dinámico:** Inventario visual tipo "hotbar" con 9 ranuras para seleccionar el bloque que deseas colocar en el mundo.

## 🎮 Controles del Juego

### Pantalla de Inicio
* **`ESPACIO`**: Iniciar el juego.
* **`ESC`**: Salir de la aplicación.

### Dentro del Juego
* **Movimiento del Jugador:**
  * **`Flecha Arriba`** / **`Flecha Abajo`** / **`Flecha Izquierda`** / **`Flecha Derecha`**: Caminar por el mapa.
* **Control del Puntero (Interacción):**
  * **`W`** / **`S`** / **`A`** / **`D`**: Desplazar el puntero a través del mapa.
  * **`ENTER`**: Romper el bloque en la posición del puntero.
  * **`ESPACIO`**: Colocar el bloque seleccionado en la posición del puntero.
* **Inventario:**
  * Teclas del **`1` al `9`**: Seleccionar espacio en el inventario.
* **Otros:**
  * **`ESC`**: Salir del juego inmediatamente.

## 🛠️ Arquitectura y Tecnologías

El proyecto está escrito en **Java** (compatible con JDK 24 según los metadatos del proyecto) y no requiere motores gráficos externos, ya que dibuja la escena manualmente extendiendo componentes como `JPanel` y `JFrame`.

El código está limpiamente dividido usando el patrón de diseño **MVC (Modelo-Vista-Controlador)** en conjunto con el patrón **Observer / Observable** para mantener la interfaz actualizada:

* **`/modelo` (Modelo):** Contiene las reglas de negocio, lógica física, manejo de bloques (`BloqueTierra`, `BloqueBedrock`, etc.), generación de `Chunks` y actualización del `Jugador` e `Inventario`.
* **`/vista` (Vista):** Contiene la lógica gráfica de Swing (`PantallaInicio`, `VistaJuego`), cálculos isométricos (`PanelIsometrico`) y representación visual con imágenes de los diferentes elementos.
* **`/controlador` (Controlador):** Implementa interfaces como `KeyListener` (`ControladorJuego`, `ControladorInicio`) para procesar el input del usuario y dar instrucciones correspondientes al modelo.

## 📦 Cómo compilar y ejecutar

Dado que el repositorio incluye los archivos de configuración de IntelliJ IDEA (`.idea/`, `.iml`), la manera más directa de ejecutarlo es mediante un IDE:

1. **Clonar/Descargar** este repositorio en tu máquina local.
2. Abre el proyecto en un IDE compatible con Java, preferiblemente **IntelliJ IDEA**, **Eclipse** o **Visual Studio Code**.
3. Asegúrate de tener el **JDK configurado** correctamente (recomendado JDK 8 o superior, el proyecto especifica JDK 24 en sus propiedades).
4. Localiza la clase principal `Main.java` dentro del paquete `src/main`.
5. Ejecuta la clase `Main.java`.

## 🖼️ Recursos (Assets)

El juego carga las texturas (bloques, cielo, personajes e interfaz) directamente desde la ruta interna `src/img/`. Si deseas añadir nuevos bloques o cambiar su aspecto, puedes sustituir o añadir los archivos `.png` en dicho directorio e implementarlos en la clase `GenBloques.java` y `VistaJuego.java`.
