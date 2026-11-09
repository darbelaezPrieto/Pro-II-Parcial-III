package chain;

import modelo.Solicitud;

public class ValidarUsuario extends Validador {

    @Override
    protected boolean comprobar(Solicitud s) {

        if (!s.getUsuario().isActivo()) {
            System.out.println("Rechazado: usuario inactivo");
            return false;
        }

        return true;
    }
}