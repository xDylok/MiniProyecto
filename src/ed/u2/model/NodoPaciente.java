package ed.u2.model;

public class NodoPaciente {
    public Paciente dato;
    public NodoPaciente sig;

    public NodoPaciente(Paciente dato) {
        this.dato = dato;
        this.sig = null;
    }
}