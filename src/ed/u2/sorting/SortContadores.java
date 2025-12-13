
package ed.u2.sorting;

public class SortContadores {
    public final long tiempoNano;
    public final long comparaciones;
    public final long swaps;

    public SortContadores(long tiempoNano, long comparaciones, long swaps) {
        this.tiempoNano = tiempoNano;
        this.comparaciones = comparaciones;
        this.swaps = swaps;
    }

}
