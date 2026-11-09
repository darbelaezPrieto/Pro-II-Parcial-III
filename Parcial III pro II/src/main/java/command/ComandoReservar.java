package command;

import mediator.MediadorBiblioteca;
import modelo.Solicitud;

public class ComandoReservar implements Comando {

    private MediadorBiblioteca mediador;
    private Solicitud solicitud;

    public ComandoReservar(MediadorBiblioteca mediador,
                           Solicitud solicitud) {
        this.mediador = mediador;
        this.solicitud = solicitud;
    }

    @Override
    public void ejecutar() {
        mediador.reservar(solicitud);
    }
}