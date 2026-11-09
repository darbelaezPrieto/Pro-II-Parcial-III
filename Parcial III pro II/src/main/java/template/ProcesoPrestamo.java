package template;

import modelo.Solicitud;

public abstract class ProcesoPrestamo {

    public final void ejecutar(Solicitud solicitud) {

        identificar(solicitud);
        preparar(solicitud);
        entregar(solicitud);
    }

    private void identificar(Solicitud s) {
        System.out.println(
                "Verificando solicitud de " +
                        s.getUsuario().getNombre()
        );
    }

    protected abstract void preparar(Solicitud solicitud);

    private void entregar(Solicitud s) {
        System.out.println(
                "Prestamo procesado: " +
                        s.getLibro().getTitulo()
        );
    }
}