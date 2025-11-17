package ed.u2.sorting;

import java.util.Arrays;

public class SortingUtils {

    // Colores en consola
    public static final String C_RESET = "\u001B[0m";
    public static final String C_ROJO = "\u001B[31m";
    public static final String C_VERDE = "\u001B[32m";
    public static final String C_AMARILLO = "\u001B[33m";
    public static final String C_AZUL = "\u001B[34m";
    public static final String C_CELESTE = "\u001B[36m";

    // dataSets:

    private static final int[] DATA_SET_A = {8, 3, 6, 3, 9};
    private static final int[] DATA_SET_B = {5, 4, 3, 2, 1}; // inverso
    private static final int[] DATA_SET_C = {1, 2, 3, 4, 5}; // Ordenado
    private static final int[] DATA_SET_D = {2, 2, 2, 2}; // duplicados
    private static final int[] DATA_SET_E = {9, 1, 8, 2};
    private static final int[] DATA_SET_F = {2, 2, 2, 2};

    public static int[] getDataSetA() {
        return Arrays.copyOf(DATA_SET_A, DATA_SET_A.length);
    }

    public static int[] getDataSetB() {
        return Arrays.copyOf(DATA_SET_B, DATA_SET_B.length);
    }

    public static int[] getDataSetC() {
        return Arrays.copyOf(DATA_SET_C, DATA_SET_C.length);
    }

    public static int[] getDataSetD() {
        return Arrays.copyOf(DATA_SET_D, DATA_SET_D.length);
    }

    public static int[] getDataSetE() {
        return Arrays.copyOf(DATA_SET_E, DATA_SET_E.length);
    }

    public static int[] getDataSetF() {
        return Arrays.copyOf(DATA_SET_F, DATA_SET_F.length);
    }
}
