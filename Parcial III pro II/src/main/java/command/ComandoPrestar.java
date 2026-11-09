package command;

import mediator.MediadorBiblioteca;
import modelo.Solicitud;

public class ComandoPrestar implements Comando {

    private MediadorBiblioteca mediador;
    private Solicitud solicitud;
    private boolean digital;

    public ComandoPrestar(MediadorBiblioteca mediador,
                          Solicitud solicitud,
                          boolean digital) {
        this.mediador = mediador;
        this.solicitud = solicitud;
        this.digital = digital;
    }

    @Override
    public void ejecutar() {
        mediador.prestar(solicitud, digital);
    }
}
