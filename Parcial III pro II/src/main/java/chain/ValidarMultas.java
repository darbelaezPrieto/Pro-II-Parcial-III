package chain;

import modelo.Solicitud;

public class ValidarMultas extends Validador {

    @Override
    protected boolean comprobar(Solicitud s) {

        if (s.getUsuario().getMultasPendientes() > 0) {
            System.out.println("Rechazado: multas pendientes");
            return false;
        }

        return true;
    }
}