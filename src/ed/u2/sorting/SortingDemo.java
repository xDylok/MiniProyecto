package ed.u2.sorting;

import java.util.Arrays;
import java.util.Scanner;

import static ed.u2.sorting.SortingUtils.HABILITAR_TRAZAS;

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
                case 3 -> mostrarBubbleSort();
                case 4 -> System.out.println("Bendiciones, Saliendo...");
                default -> System.out.println("Opcion Invalida.");
            }
        } while (opcion != 4);

    }

    public static void mostrarInsertionSort() {
        // inicializar variables para evitar crear dos copias diferentes
        int[] arrayA = SortingUtils.getDataSetA();
        int[] arrayB = SortingUtils.getDataSetB();
        int[] arrayC = SortingUtils.getDataSetC();
        int[] arrayD = SortingUtils.getDataSetD();
        int[] arrayE = SortingUtils.getDataSetE();
        // CASOS BORDE:
        int[] arrayF = SortingUtils.getDataSetF();
        int[] arrayG = SortingUtils.getDataSetG();
        int[] arrayH = SortingUtils.getDataSetH();
        int[] arrayI = SortingUtils.getDataSetI();
        int[] arrayJ = SortingUtils.getDataSetJ();
        int[] arrayK = SortingUtils.getDataSetK();

        System.out.print(SortingUtils.C_VERDE +
                "\n| -------------------- Insertion Sort -------------------- |" +
                SortingUtils.C_RESET);

        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "Data Set A: " + Arrays.toString(arrayA) + " ---------- |"
                + SortingUtils.C_RESET);
        InsertionSort.sort(arrayA, HABILITAR_TRAZAS);

        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "Data Set B: " + Arrays.toString(arrayB) + " ---------- |"
                + SortingUtils.C_RESET);
        InsertionSort.sort(arrayB, HABILITAR_TRAZAS);

        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "Data Set C: " + Arrays.toString(arrayC) + " ---------- |"
                + SortingUtils.C_RESET);
        InsertionSort.sort(arrayC, HABILITAR_TRAZAS);

        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "Data Set D: " + Arrays.toString(arrayD) + " ---------- |"
                + SortingUtils.C_RESET);
        InsertionSort.sort(arrayD, HABILITAR_TRAZAS);

        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "Data Set E: " + Arrays.toString(arrayE) + " ---------- |"
                + SortingUtils.C_RESET);
        InsertionSort.sort(arrayE, HABILITAR_TRAZAS);

        // Caso borde 1:
        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "> CB: Data Set F: " + Arrays.toString(arrayF) + " ---------- |"
                + SortingUtils.C_RESET);
        InsertionSort.sort(arrayF, HABILITAR_TRAZAS);
        // caso borde 2:
        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "> CB: Data Set G: " + Arrays.toString(arrayG) + " ---------- |"
                + SortingUtils.C_RESET);
        InsertionSort.sort(arrayG, HABILITAR_TRAZAS);
        // CB 3:
        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "> CB: Data Set H: " + Arrays.toString(arrayH) + " ---------- |"
                + SortingUtils.C_RESET);
        InsertionSort.sort(arrayH, HABILITAR_TRAZAS);
        // CB 4:
        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "> CB: Data Set I: " + Arrays.toString(arrayI) + " ---------- |"
                + SortingUtils.C_RESET);
        InsertionSort.sort(arrayI, HABILITAR_TRAZAS);
        // CB 5:
        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "> CB: Data Set J: " + Arrays.toString(arrayJ) + " ---------- |"
                + SortingUtils.C_RESET);
        InsertionSort.sort(arrayJ, HABILITAR_TRAZAS);
        //CB 6:
        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "> CB: Data Set K: " + Arrays.toString(arrayK) + " ---------- |"
                + SortingUtils.C_RESET);
        InsertionSort.sort(arrayK, HABILITAR_TRAZAS);
    }

    public static void mostrarSelectionSort() {
        // inicializar variables para evitar crear dos copias diferentes
        int[] arrayA = SortingUtils.getDataSetA();
        int[] arrayB = SortingUtils.getDataSetB();
        int[] arrayC = SortingUtils.getDataSetC();
        int[] arrayD = SortingUtils.getDataSetD();
        int[] arrayE = SortingUtils.getDataSetE();
        // CASOS BORDE:
        int[] arrayF = SortingUtils.getDataSetF();
        int[] arrayG = SortingUtils.getDataSetG();
        int[] arrayH = SortingUtils.getDataSetH();
        int[] arrayI = SortingUtils.getDataSetI();
        int[] arrayJ = SortingUtils.getDataSetJ();
        int[] arrayK = SortingUtils.getDataSetK();

        System.out.print(SortingUtils.C_VERDE +
                "\n| -------------------- Selection Sort -------------------- |" +
                SortingUtils.C_RESET);

        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "Data Set A: " + Arrays.toString(arrayA) + " ---------- |"
                + SortingUtils.C_RESET);
        SelectionSort.sort(arrayA, HABILITAR_TRAZAS);

        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "Data Set B: " + Arrays.toString(arrayB) + " ---------- |"
                + SortingUtils.C_RESET);
        SelectionSort.sort(arrayB, HABILITAR_TRAZAS);

        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "Data Set C: " + Arrays.toString(arrayC) + " ---------- |"
                + SortingUtils.C_RESET);
        SelectionSort.sort(arrayC, HABILITAR_TRAZAS);

        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "Data Set D: " + Arrays.toString(arrayD) + " ---------- |"
                + SortingUtils.C_RESET);
        SelectionSort.sort(arrayD, HABILITAR_TRAZAS);

        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "Data Set E: " + Arrays.toString(arrayE) + " ---------- |"
                + SortingUtils.C_RESET);
        SelectionSort.sort(arrayE, HABILITAR_TRAZAS);

        // Caso borde CB 1:
        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "> CB: Data Set F: " + Arrays.toString(arrayF) + " ---------- |"
                + SortingUtils.C_RESET);
        SelectionSort.sort(arrayF, HABILITAR_TRAZAS);
        // caso borde CB 2:
        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "> CB: Data Set G: " + Arrays.toString(arrayG) + " ---------- |"
                + SortingUtils.C_RESET);
        SelectionSort.sort(arrayG, HABILITAR_TRAZAS);
        // CB 3:
        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "> CB: Data Set H: " + Arrays.toString(arrayH) + " ---------- |"
                + SortingUtils.C_RESET);
        SelectionSort.sort(arrayH, HABILITAR_TRAZAS);
        // CB 4:
        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "> CB: Data Set I: " + Arrays.toString(arrayI) + " ---------- |"
                + SortingUtils.C_RESET);
        SelectionSort.sort(arrayI, HABILITAR_TRAZAS);
        // CB 5:
        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "> CB: Data Set J: " + Arrays.toString(arrayJ) + " ---------- |"
                + SortingUtils.C_RESET);
        SelectionSort.sort(arrayJ, HABILITAR_TRAZAS);
        //CB 6:
        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "> CB: Data Set K: " + Arrays.toString(arrayK) + " ---------- |"
                + SortingUtils.C_RESET);
        SelectionSort.sort(arrayK, HABILITAR_TRAZAS);

    }

    public static void mostrarBubbleSort() {
        // inicializar variables para evitar crear dos copias diferentes
        int[] arrayA = SortingUtils.getDataSetA();
        int[] arrayB = SortingUtils.getDataSetB();
        int[] arrayC = SortingUtils.getDataSetC();
        int[] arrayD = SortingUtils.getDataSetD();
        int[] arrayE = SortingUtils.getDataSetE();
        // CASOS BORDE:
        int[] arrayF = SortingUtils.getDataSetF();
        int[] arrayG = SortingUtils.getDataSetG();
        int[] arrayH = SortingUtils.getDataSetH();
        int[] arrayI = SortingUtils.getDataSetI();
        int[] arrayJ = SortingUtils.getDataSetJ();
        int[] arrayK = SortingUtils.getDataSetK();

        System.out.print(SortingUtils.C_VERDE +
                "\n| -------------------- Bubble Sort -------------------- |" +
                SortingUtils.C_RESET);

        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "Data Set A: " + Arrays.toString(arrayA) + " ---------- |"
                + SortingUtils.C_RESET);
        BubbleSort.sort(arrayA, HABILITAR_TRAZAS);

        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "Data Set B: " + Arrays.toString(arrayB) + " ---------- |"
                + SortingUtils.C_RESET);
        BubbleSort.sort(arrayB, HABILITAR_TRAZAS);

        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "Data Set C: " + Arrays.toString(arrayC) + " ---------- |"
                + SortingUtils.C_RESET);
        BubbleSort.sort(arrayC, HABILITAR_TRAZAS);

        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "Data Set D: " + Arrays.toString(arrayD) + " ---------- |"
                + SortingUtils.C_RESET);
        BubbleSort.sort(arrayD, HABILITAR_TRAZAS);

        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "Data Set E: " + Arrays.toString(arrayE) + " ---------- |"
                + SortingUtils.C_RESET);
        BubbleSort.sort(arrayE, HABILITAR_TRAZAS);

        // CASOS BORDE CB:
        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "> CB: Data Set F: " + Arrays.toString(arrayF) + " ---------- |"
                + SortingUtils.C_RESET);
        BubbleSort.sort(arrayF, HABILITAR_TRAZAS);
        // CB 2:
        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "> CB: Data Set G: " + Arrays.toString(arrayG) + " ---------- |"
                + SortingUtils.C_RESET);
        BubbleSort.sort(arrayG, HABILITAR_TRAZAS);
        // CB 3:
        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "> CB: Data Set H: " + Arrays.toString(arrayH) + " ---------- |"
                + SortingUtils.C_RESET);
        BubbleSort.sort(arrayH, HABILITAR_TRAZAS);
        // CB 4:
        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "> CB: Data Set I: " + Arrays.toString(arrayI) + " ---------- |"
                + SortingUtils.C_RESET);
        BubbleSort.sort(arrayI, HABILITAR_TRAZAS);
        // CB 5:
        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "> CB: Data Set J: " + Arrays.toString(arrayJ) + " ---------- |"
                + SortingUtils.C_RESET);
        BubbleSort.sort(arrayJ, HABILITAR_TRAZAS);
        //CB 6:
        System.out.println(SortingUtils.C_AMARILLO +
                "\n| ---------- " + "> CB: Data Set K: " + Arrays.toString(arrayK) + " ---------- |"
                + SortingUtils.C_RESET);
        BubbleSort.sort(arrayK, HABILITAR_TRAZAS);
    }


}
