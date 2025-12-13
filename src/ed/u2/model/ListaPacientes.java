package ed.u2.model;

import java.util.ArrayList;
import java.util.List;

public class ListaPacientes {
    private NodoPaciente head;

    // inserta al final
    public void add(Paciente p) {
        NodoPaciente nuevo = new NodoPaciente(p);
        if (head == null) {
            head = nuevo;
            return;
        }
        NodoPaciente actual = head;
        while (actual.sig != null) {
            actual = actual.sig;
        }
        actual.sig = nuevo;
    }

    // buscar primera ocurrencia por Apellido
    public Paciente buscarPrimerApellido(String apellido) {
        NodoPaciente actual = head;
        while (actual != null) {
            if (actual.dato.apellido.equalsIgnoreCase(apellido)) {
                return actual.dato;
            }
            actual = actual.sig;
        }
        return null;
    }

    // buscar todos por Prioridad
    public List<Paciente> buscarTodosPrioridad(int prioridad) {
        List<Paciente> encontrados = new ArrayList<>();
        NodoPaciente actual = head;
        while (actual != null) {
            if (actual.dato.prioridad == prioridad) {
                encontrados.add(actual.dato);
            }
            actual = actual.sig;
        }
        return encontrados;
    }
}
