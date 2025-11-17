package ed.u2.sorting;

import java.util.Arrays;

public final class SelectionSort {
    public static void sort(int[] arreglo) {
        sort(arreglo, false);
    }

    public static void sort(int[] arreglo, boolean trace) {
        int contSwaps = 0;
        for (int i = 0; i < arreglo.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arreglo.length; j++) {
                if (arreglo[min] > arreglo[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arreglo[i];
                arreglo[i] = arreglo[min];
                arreglo[min] = temp;
                contSwaps++;
            }
            if (trace) {
                System.out.println(SortingUtils.C_AZUL +
                        "\tIteracion: |" + SortingUtils.C_ROJO + i + SortingUtils.C_AZUL +
                        "|: Min encontrado: |" + SortingUtils.C_ROJO + arreglo[i] + SortingUtils.C_AZUL +
                        "| Arreglo actualizado: " + SortingUtils.C_ROJO + Arrays.toString(arreglo) +
                        SortingUtils.C_RESET);
            }
        }
        if (trace)
            System.out.println(SortingUtils.C_VERDE + "Total de swaps: " + contSwaps + SortingUtils.C_RESET);
        System.out.println(SortingUtils.mostrarArregloFinal(arreglo));;
    }
}
