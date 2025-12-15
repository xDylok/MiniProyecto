
package ed.u2.sorting;

public class SortContadores {
    public long tiempoNano;
    public long comparaciones;
    public long swaps;

    public SortContadores(long tiempoNano, long comparaciones, long swaps) {
        this.tiempoNano = tiempoNano;
        this.comparaciones = comparaciones;
        this.swaps = swaps;
    }

}
