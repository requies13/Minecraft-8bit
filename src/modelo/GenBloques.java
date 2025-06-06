package modelo;

public class GenBloques {
    private static GenBloques miGenBloques = new GenBloques();
    private GenBloques() {}

    public static GenBloques getMiGenBloques() {
        return miGenBloques;
    }

    public Bloque generar(String pTipo, int pY, int pX, int pZ) {
            if (pTipo.equals("Vacio")) {
                BloqueVacio nuevo =new BloqueVacio(pY,pX,pZ);
                return nuevo;
            }
            else if (pTipo.equals("Tierra")) {
                BloqueTierra nuevo =new BloqueTierra(pY,pX,pZ);
                return nuevo;
            }
            else if (pTipo.equals("Tierra2")) {
                BloqueTierra2 nuevo =new BloqueTierra2(pY,pX,pZ);
                return nuevo;
            } else if (pTipo.equals("Bedrock")) {
                BloqueBedrock nuevo =new BloqueBedrock(pY,pX,pZ);
                return nuevo;
            }
            else return null;
    }
}
