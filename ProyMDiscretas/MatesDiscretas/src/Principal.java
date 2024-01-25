import java.text.DecimalFormat;

public class Principal {
    public static void main(String[] args) {
        float[][] distancias = {
                {0, 126.3f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {126.3f, 0, 113.3f, 0, 0, 0, 0, 0, 0, 296, 0, 0, 0, 0, 0, 0},
                {0, 113.3f, 0, 108.1f, 0, 0, 0, 0, 0, 255, 0, 0, 152.9f, 0, 0, 0},
                {0, 0, 108.1f, 0, 42.5f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 42.5f, 0, 99.9f, 62.2f, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 99.9f, 0, 59.9f, 0, 0, 0, 0, 0, 0, 172.8f, 0, 0},
                {0, 0, 0, 0, 62.2f, 59.9f, 0, 242.1f, 0, 0, 0, 0, 0, 285, 0, 0},
                {0, 0, 0, 0, 0, 0, 242.1f, 0, 31.6f, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 31.6f, 0, 0, 0, 0, 0, 196, 0, 230.9f},
                {0, 296, 255, 0, 0, 0, 0, 0, 0, 0, 0, 357.7f, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 38, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 375.7f, 38, 0, 244.3f, 198.1f, 324.5f, 0},
                {0, 0, 152.9f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 244.3f, 0, 282.3f, 0},
                {0, 0, 0, 0, 0, 172.8f, 285, 0, 196, 0, 0, 198.7f, 282.3f, 0, 129.4f, 181.8f},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 324.5f, 0, 129.4f, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 230.9f, 0, 0, 0, 181.8f, 0, 0, 0}
        };

        int[][] dificultades = {
                {0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {2, 0, 3, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 3, 0, 3, 0, 0, 0, 0, 0, 2, 0, 0, 1, 0, 0, 0},
                {0, 0, 3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 3, 0, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 3, 2, 0, 2, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 2, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 1, 0, 1},
                {0, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 0, 2, 3, 3, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 3, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 3, 3, 0, 1, 3},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 3, 0, 0}
        };

        AlgoritmoPrim prim = new AlgoritmoPrim();
        int[] mst = prim.prim(distancias);

        RedFibraOptica red = new RedFibraOptica();
        float tiempoInstalacion = red.calcularTiempoInstalacion(distancias, dificultades, mst);
        DecimalFormat df = new DecimalFormat("#.0");
        System.out.println("Tiempo total de instalación: " + df.format(tiempoInstalacion) + " horas");

        float costoPorHora = 100.0f; // Ajusta este valor según sea necesario
        float costoTotal = red.calcularCostoTotal(tiempoInstalacion, costoPorHora);
        System.out.println("Costo total de la instalación: $" + df.format(costoTotal));
    }
}

