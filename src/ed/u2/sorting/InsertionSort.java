package ed.u2.sorting;

import java.util.Arrays;

public final class InsertionSort {
    public static void sort(int[] arreglo) {
        sort(arreglo, true);
    }


    public static void sort(int[] arreglo, boolean trace) {
        // Ordenamiento
        for (int i = 1; i < arreglo.length; i++) {
            int aux = arreglo[i];
            int pos = i - 1;

            if (trace) {
                System.out.println("\n>Iteracion: " + i + ", Insercion: " + aux);
                    System.out.println("\tActual: " + Arrays.toString(arreglo));
            }

            while (pos >= 0 && arreglo[pos] > aux) {
                if (trace){
                    System.out.println("\t\t-Pasando: '" + arreglo[pos] + "' de posicion: " + pos + " hacia: " + (pos+1));
                }
                    arreglo[pos + 1] = arreglo[pos];
                pos--;
            }
            arreglo[pos + 1] = aux;

            if (trace){
                System.out.println(SortingUtils.C_ROJO +
                        "Resultado: " + SortingUtils.C_CELESTE + Arrays.toString(arreglo)
                        + SortingUtils.C_RESET);
            }
        }
        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- "+ "Resultado Final: " + SortingUtils.C_AZUL +Arrays.toString(arreglo) + SortingUtils.C_AMARILLO +" ---------- |\n"
                + SortingUtils.C_RESET);
    }
}












