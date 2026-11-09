package chain;

import modelo.Solicitud;

public class ValidarDisponibilidad extends Validador {

    @Override
    protected boolean comprobar(Solicitud s) {

        if (!s.getLibro().getEstado().equals("DISPONIBLE")) {
            System.out.println(
                    "Rechazado: libro no disponible"
            );
            return false;
        }

        return true;
    }
}