package mediator;

import modelo.Solicitud;

public interface MediadorBiblioteca {

    boolean prestar(Solicitud solicitud, boolean digital);

    boolean devolver(Solicitud solicitud, int diasRetraso);

    boolean reservar(Solicitud solicitud);
}