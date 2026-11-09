package memento;

import java.util.ArrayList;

public class HistorialSolicitud {

    private ArrayList<SolicitudMemento> historial =
            new ArrayList<>();

    public void agregar(SolicitudMemento copia) {
        historial.add(copia);
    }

    public SolicitudMemento ultima() {

        if (historial.isEmpty()) {
            return null;
        }

        return historial.remove(historial.size() - 1);
    }
}