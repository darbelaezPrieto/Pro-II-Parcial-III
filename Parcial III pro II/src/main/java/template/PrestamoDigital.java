package template;

import modelo.Solicitud;

public class PrestamoDigital extends ProcesoPrestamo {

    @Override
    protected void preparar(Solicitud s) {

        System.out.println(
                "Generando acceso digital temporal"
        );
    }
}