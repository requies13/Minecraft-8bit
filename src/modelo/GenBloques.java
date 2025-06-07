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
    public String queBloqueEs(Bloque bloque) {
        if (bloque instanceof BloqueVacio) {
            return "Vacio";
        } else if (bloque instanceof BloqueTierra) {
            return "Tierra";
        } else if (bloque instanceof BloqueTierra2) {
            return "Tierra2";
        } else if (bloque instanceof BloqueBedrock) {
            return "Bedrock";
        }
        return null;
    }
}
