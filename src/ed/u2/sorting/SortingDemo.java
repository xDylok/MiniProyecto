package ed.u2.sorting;

import java.util.Arrays;
import java.util.Scanner;
import ed.u2.sorting.SortingUtils;

public class SortingDemo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.print("""
                    \nSeleccione una opcion:
                    \t 1. InsertionSorting
                    \t 2. SelectionSorting
                    \t 3. BubbleSorting
                    \t 4. Salir.
                    Opcion:\s""");
            opcion = Integer.parseInt(in.nextLine());
            switch (opcion) {
                case 1 -> mostrarInsertionSort();
                case 2 -> mostrarSelectionSort();
                case 3 -> System.out.println("Pendiente...");
                case 4 -> System.out.println("Saliendo...");
                default -> System.out.println("Opcion Invalida.");
            }
        } while (opcion != 4);

    }

    public static void mostrarInsertionSort() {
        System.out.print(SortingUtils.C_VERDE +
                "\n| -------------------- Insertion Sort -------------------- |" +
                SortingUtils.C_RESET);

        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "Data Set A: " + Arrays.toString(SortingUtils.getDataSetA()) + " ---------- |"
                + SortingUtils.C_RESET);
        InsertionSort.sort(SortingUtils.getDataSetA());

        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "Data Set B: " + Arrays.toString(SortingUtils.getDataSetB()) + " ---------- |"
                + SortingUtils.C_RESET);
        InsertionSort.sort(SortingUtils.getDataSetB());

        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "Data Set C: " + Arrays.toString(SortingUtils.getDataSetC()) + " ---------- |"
                + SortingUtils.C_RESET);
        InsertionSort.sort(SortingUtils.getDataSetC());

        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "Data Set D: " + Arrays.toString(SortingUtils.getDataSetD()) + " ---------- |"
                + SortingUtils.C_RESET);
        InsertionSort.sort(SortingUtils.getDataSetD());

        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "Data Set E: " + Arrays.toString(SortingUtils.getDataSetE()) + " ---------- |"
                + SortingUtils.C_RESET);
        InsertionSort.sort(SortingUtils.getDataSetE());

        // Caso borde 1:
        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "> CB: Data Set F: " + Arrays.toString(SortingUtils.getDataSetF()) + " ---------- |"
                + SortingUtils.C_RESET);
        InsertionSort.sort(SortingUtils.getDataSetF());
        // caso borde 2:
        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "> CB: Data Set G: " + Arrays.toString(SortingUtils.getDataSetG()) + " ---------- |"
                + SortingUtils.C_RESET);
        InsertionSort.sort(SortingUtils.getDataSetG());
    }

    public static void mostrarSelectionSort() {
        System.out.print(SortingUtils.C_VERDE +
                "\n| -------------------- Selection Sort -------------------- |" +
                SortingUtils.C_RESET);

        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "Data Set A: " + Arrays.toString(SortingUtils.getDataSetA()) + " ---------- |"
                + SortingUtils.C_RESET);
        SelectionSort.sort(SortingUtils.getDataSetA());

        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "Data Set B: " + Arrays.toString(SortingUtils.getDataSetB()) + " ---------- |"
                + SortingUtils.C_RESET);
        SelectionSort.sort(SortingUtils.getDataSetB());

        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "Data Set C: " + Arrays.toString(SortingUtils.getDataSetC()) + " ---------- |"
                + SortingUtils.C_RESET);
        SelectionSort.sort(SortingUtils.getDataSetC());

        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "Data Set D: " + Arrays.toString(SortingUtils.getDataSetD()) + " ---------- |"
                + SortingUtils.C_RESET);
        SelectionSort.sort(SortingUtils.getDataSetD());

        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "Data Set E: " + Arrays.toString(SortingUtils.getDataSetE()) + " ---------- |"
                + SortingUtils.C_RESET);
        SelectionSort.sort(SortingUtils.getDataSetE());

        // Caso borde CB 1:
        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "> CB: Data Set F: " + Arrays.toString(SortingUtils.getDataSetF()) + " ---------- |"
                + SortingUtils.C_RESET);
        SelectionSort.sort(SortingUtils.getDataSetF());
        // caso borde CB 2:
        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "> CB: Data Set F: " + Arrays.toString(SortingUtils.getDataSetG()) + " ---------- |"
                + SortingUtils.C_RESET);
        SelectionSort.sort(SortingUtils.getDataSetG());

    }

    public static void mostrarBubbleSort() {

    }


}
