import java.util.Arrays;

public class AlgoritmoPrim {

    public int[] prim(float[][] grafo) {
        int numVertices = grafo.length;
        int[] padre = new int[numVertices];
        float[] clave = new float[numVertices];
        Boolean[] conjuntoMST = new Boolean[numVertices];

        Arrays.fill(clave, Float.MAX_VALUE);
        Arrays.fill(conjuntoMST, false);

        clave[0] = 0;
        padre[0] = -1;

        for (int i = 0; i < numVertices - 1; i++) {
            int u = minClave(clave, conjuntoMST);
            conjuntoMST[u] = true;

            for (int v = 0; v < numVertices; v++) {
                if (grafo[u][v] != 0 && !conjuntoMST[v] && grafo[u][v] < clave[v]) {
                    padre[v] = u;
                    clave[v] = grafo[u][v];
                }
            }
        }

        return padre;
    }

    private int minClave(float[] clave, Boolean[] conjuntoMST) {
        float minimo = Float.MAX_VALUE;
        int indiceMinimo = -1;

        for (int v = 0; v < clave.length; v++) {
            if (!conjuntoMST[v] && clave[v] < minimo) {
                minimo = clave[v];
                indiceMinimo = v;
            }
        }

        return indiceMinimo;
    }
}
