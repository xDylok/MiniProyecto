package ed.u2.sorting;

import java.util.Arrays;

public final class InsertionSort {
    // Firma estandar
    public static void sort(int[] arreglo) {
        // llama al metodo principal, habilitando o deshabilitando las trazas
        sort(arreglo, false);
    }
    // Metodo de ordenamiento sobrecargado, permite imprimir trazas
    public static void sort(int[] arreglo, boolean trace) {
        // recorre el array desde el segundo elemento
        for (int i = 1; i < arreglo.length; i++) {
            int aux = arreglo[i]; // aux = se inserta la sublista ordenada
            int pos = i - 1; // apunta al ultimo elemento de la sublista ordenada (izquierda de << i >>)
            // if -> imprime el estado antes de empezar a mover los elementos
            if (trace) {
                System.out.println("\n>Iteracion: " + i + ", Insercion: " + aux);
                System.out.println("\tActual: " + Arrays.toString(arreglo));
            }
            /*
            * se ejecuta mientras:
            * 1. no se salga del arreglo por la izquierda pos >= 0
            * 2. el elemento de la lista ordenada (sublista izquierda) sea mayor que el elemento a insertar (aux)
            */
            while (pos >= 0 && arreglo[pos] > aux) {
                // IF -> muestra que elemento se mueve y a que posicion
                if (trace){
                    System.out.println("\t\t-Pasando: '" + arreglo[pos] + "' de posicion: " + pos + " hacia: " + (pos+1));
                }
                arreglo[pos + 1] = arreglo[pos]; // mueve el elemento mayor (arreglo[pos]) una posicion a la derecha
                pos--; // mueve el puntero hacia la izquierda para seguir comparando
            }
            // cuando while termina, se asigna la posicion correcta, insertando el elemento aux
            arreglo[pos + 1] = aux;
            // muestra el resultado de la iteracion actual
            if (trace){
                System.out.println(SortingUtils.C_ROJO +
                        "Resultado: " + SortingUtils.C_CELESTE + Arrays.toString(arreglo)
                        + SortingUtils.C_RESET);
            }
        }
        // muestra el arreglo ordenado
        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- "+ "Resultado Final: " + SortingUtils.C_AZUL +Arrays.toString(arreglo) + SortingUtils.C_AMARILLO +" ---------- |\n"
                + SortingUtils.C_RESET);
    }
}