package command;

import mediator.MediadorBiblioteca;
import modelo.Solicitud;

public class ComandoDevolver implements Comando {

    private MediadorBiblioteca mediador;
    private Solicitud solicitud;
    private int retraso;

    public ComandoDevolver(MediadorBiblioteca mediador,
                           Solicitud solicitud,
                           int retraso) {
        this.mediador = mediador;
        this.solicitud = solicitud;
        this.retraso = retraso;
    }

    @Override
    public void ejecutar() {
        mediador.devolver(solicitud, retraso);
    }
}