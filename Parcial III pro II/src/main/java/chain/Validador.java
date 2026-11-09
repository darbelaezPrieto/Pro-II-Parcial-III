package chain;

import modelo.Solicitud;

public abstract class Validador {

    private Validador siguiente;

    public Validador enlazar(Validador otro) {
        siguiente = otro;
        return otro;
    }

    public final boolean validar(Solicitud solicitud) {

        if (!comprobar(solicitud)) {
            return false;
        }

        if (siguiente != null) {
            return siguiente.validar(solicitud);
        }

        return true;
    }

    protected abstract boolean comprobar(Solicitud solicitud);
}