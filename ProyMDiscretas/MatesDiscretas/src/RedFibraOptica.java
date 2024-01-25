public class RedFibraOptica {
    private static final float VELOCIDAD_DIFICULTAD_1 = 3.0f; // km/h
    private static final float VELOCIDAD_DIFICULTAD_2 = 6.0f; // km/h
    private static final float VELOCIDAD_DIFICULTAD_3 = 8.0f; // km/h
    private static final int DISTANCIA_INICIAL_FINAL_REDUCIDA = 25; // 15 km iniciales + 10 km finales

    public float calcularTiempoInstalacion(float[][] distancias, int[][] dificultades, int[] mst) {
        float tiempoTotalInstalacion = 0.0f;

        for (int i = 1; i < mst.length; i++) {
            int ciudadOrigen = mst[i];
            int ciudadDestino = i;
            float distancia = distancias[ciudadOrigen][ciudadDestino];
            int dificultad = dificultades[ciudadOrigen][ciudadDestino];

            float distanciaAjustada = Math.max(0, distancia - DISTANCIA_INICIAL_FINAL_REDUCIDA);
            float tiempoReduccionInicialFinal = DISTANCIA_INICIAL_FINAL_REDUCIDA / (obtenerVelocidad(dificultad) / 2.0f);
            float tiempoAjustado = distanciaAjustada / obtenerVelocidad(dificultad);

            tiempoTotalInstalacion += tiempoAjustado + tiempoReduccionInicialFinal;
        }

        return tiempoTotalInstalacion;
    }

    private float obtenerVelocidad(int dificultad) {
        switch (dificultad) {
            case 1: return VELOCIDAD_DIFICULTAD_1;
            case 2: return VELOCIDAD_DIFICULTAD_2;
            case 3: return VELOCIDAD_DIFICULTAD_3;
            default: return 0;
        }
    }

    public float calcularCostoTotal(float tiempoInstalacion, float costoPorHora) {
        return tiempoInstalacion * costoPorHora;
    }
}