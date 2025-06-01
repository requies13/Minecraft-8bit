package modelo;

public class GenBloques {
    private static GenBloques miGenBloques = new GenBloques();
    private GenBloques() {}

    public static GenBloques getMiGenBloques() {
        return miGenBloques;
    }

    public Bloque generar(String pTipo, int pY, int pX) {
            if (pTipo.equals("Vacio")) {
                BloqueVacio nuevo =new BloqueVacio(pY,pX);
                return nuevo;
            }
            else if (pTipo.equals("Tierra")) {
                BloqueTierra nuevo =new BloqueTierra(pY,pX);
                return nuevo;
            }
            else return null;
    }
}
