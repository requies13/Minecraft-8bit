# JAVAC=/usr/bin/javac
JAVA_DIR=/home/marco/Escritorio/Programas/jdk/bin/

JAVAC=$(JAVA_DIR)/javac
JAVA=$(JAVA_DIR)/java
JAR=$(JAVA_DIR)/jar

BIN_DIR=bin

JAVA_FLAGS=-cp $(BIN_DIR)
JAVAC_FLAGS=-Xlint:deprecation -d $(BIN_DIR)

JAR_OUTPUT=Minecraft-8bit.jar

# SRC
SRC_MAIN=src/main/Main.java

SRC_CONTROLADOR_DIR=src/controlador
SRC_CONTROLADOR=$(SRC_CONTROLADOR_DIR)/ControladorInicio.java $(SRC_CONTROLADOR_DIR)/ControladorJuego.java

SRC_MODELO_DIR=src/modelo
SRC_MODELO=$(SRC_MODELO_DIR)/BloqueBedrock.java $(SRC_MODELO_DIR)/Bloque.java $(SRC_MODELO_DIR)/BloqueTierra2.java $(SRC_MODELO_DIR)/BloqueTierra.java $(SRC_MODELO_DIR)/BloqueVacio.java $(SRC_MODELO_DIR)/Chunk.java $(SRC_MODELO_DIR)/GenBloques.java $(SRC_MODELO_DIR)/Inicio.java $(SRC_MODELO_DIR)/Inventario.java $(SRC_MODELO_DIR)/Jugador.java $(SRC_MODELO_DIR)/Mapa.java $(SRC_MODELO_DIR)/Puntero.java

SRC_VISTA_DIR=src/vista
SRC_VISTA=$(SRC_VISTA_DIR)/BloqueVisual.java $(SRC_VISTA_DIR)/InventarioVisual.java $(SRC_VISTA_DIR)/JugadorVisual.java $(SRC_VISTA_DIR)/PanelIsometrico.java $(SRC_VISTA_DIR)/PantallaInicio.java $(SRC_VISTA_DIR)/PunteroVisual.java $(SRC_VISTA_DIR)/VistaJuego.java

SRC=$(SRC_MAIN) $(SRC_CONTROLADOR) $(SRC_MODELO) $(SRC_VISTA)

# IMG
IMG_DIR = src/img

# MANIFEST
MANIFEST=manifest.txt

# Main CLASS
MAIN_CLASS=main.Main

$(BIN_DIR): $(SRC)
	$(JAVAC) $(JAVAC_FLAGS) $(SRC) 
	cp -r $(IMG_DIR) $(BIN_DIR)/

run: $(BIN_DIR)
	$(JAVA) $(JAVA_FLAGS) $(MAIN_CLASS)

jar: $(BIN_DIR)
	$(JAR) cvmf $(MANIFEST) $(JAR_OUTPUT) -C $(BIN_DIR) .
clean:
	rm -rf $(BIN_DIR)
	rm -rf $(JAR)
