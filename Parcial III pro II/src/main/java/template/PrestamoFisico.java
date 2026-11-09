package template;

import modelo.Solicitud;

public class PrestamoFisico extends ProcesoPrestamo {

    @Override
    protected void preparar(Solicitud s) {

        System.out.println(
                "Preparando ejemplar fisico y comprobante"
        );
    }
}