package chain;

import modelo.Solicitud;

public class ValidarPlazo extends Validador {

    @Override
    protected boolean comprobar(Solicitud s) {

        if (s.getDias() < 1 || s.getDias() > 15) {
            System.out.println(
                    "Rechazado: plazo fuera de 1 a 15 dias"
            );
            return false;
        }

        return true;
    }
}