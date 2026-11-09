package mediator;

import chain.*;
import modelo.Solicitud;
import observer.Notificador;
import strategy.*;
import template.*;

public class CoordinadorBiblioteca implements MediadorBiblioteca {

    private Notificador notificador;

    public CoordinadorBiblioteca(Notificador notificador) {
        this.notificador = notificador;
    }

    @Override
    public boolean prestar(Solicitud s, boolean digital) {

        System.out.println("[Mediador] Coordinando prestamo");

        // CHAIN OF RESPONSIBILITY
        Validador primero = new ValidarUsuario();

        primero.enlazar(new ValidarMultas())
                .enlazar(new ValidarPlazo())
                .enlazar(new ValidarDisponibilidad());

        if (!primero.validar(s)) {
            return false;
        }

        // TEMPLATE METHOD
        ProcesoPrestamo proceso;

        if (digital) {
            proceso = new PrestamoDigital();
        } else {
            proceso = new PrestamoFisico();
        }

        proceso.ejecutar(s);

        // STATE
        if (!s.getLibro().prestar()) {
            return false;
        }

        // OBSERVER
        notificador.notificar(
                "Prestamo confirmado: " +
                        s.getLibro().getTitulo() +
                        " (" + s.getDias() + " dias)"
        );

        return true;
    }

    @Override
    public boolean devolver(Solicitud s, int diasRetraso) {

        System.out.println("[Mediador] Coordinando devolucion");

        // STATE
        if (!s.getLibro().devolver()) {
            System.out.println(
                    "No se puede devolver en este estado"
            );
            return false;
        }

        // STRATEGY
        EstrategiaMulta estrategia;

        if (s.getUsuario().getTipo()
                .equalsIgnoreCase("DOCENTE")) {

            estrategia = new MultaDocente();

        } else {

            estrategia = new MultaEstudiante();
        }

        CalculadoraMulta calculadora =
                new CalculadoraMulta(estrategia);

        double multa = calculadora.calcular(diasRetraso);

        s.getUsuario().setMultasPendientes(
                s.getUsuario().getMultasPendientes() + multa
        );

        System.out.println("Multa calculada: $" + multa);

        // OBSERVER
        notificador.notificar(
                "Libro devuelto: " +
                        s.getLibro().getTitulo() +
                        ". Multa: $" + multa
        );

        return true;
    }

    @Override
    public boolean reservar(Solicitud s) {

        System.out.println("[Mediador] Coordinando reserva");

        if (!s.getUsuario().isActivo() ||
                s.getUsuario().getMultasPendientes() > 0) {

            System.out.println(
                    "Usuario no habilitado para reservar"
            );
            return false;
        }

        // STATE
        if (!s.getLibro().reservar()) {

            System.out.println(
                    "Libro no disponible para reservar"
            );
            return false;
        }

        // OBSERVER
        notificador.notificar(
                "Reserva confirmada: " +
                        s.getLibro().getTitulo()
        );

        return true;
    }
}