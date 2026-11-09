package pruebas;

import modelo.*;
import observer.*;
import mediator.*;
import command.*;
import memento.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== BIBLIOTECA UNIVERSITARIA ===");


        Notificador notificador = new Notificador();

        notificador.agregar(new ObservadorEstudiante());
        notificador.agregar(new ObservadorBibliotecario());


        MediadorBiblioteca mediador =
                new CoordinadorBiblioteca(notificador);


        Invocador invocador = new Invocador();


        Usuario ana = new Usuario(
                "Ana", "ESTUDIANTE", true, 0
        );

        Libro java = new Libro("Programacion en Java");

        Solicitud solicitud = new Solicitud(ana, java, 7);


        System.out.println("\n1. MEMENTO");

        HistorialSolicitud historial = new HistorialSolicitud();

        historial.agregar(solicitud.guardar());

        solicitud.setDias(30);

        System.out.println(
                "Dias modificados: " + solicitud.getDias()
        );

        solicitud.restaurar(historial.ultima());

        System.out.println(
                "Dias restaurados: " + solicitud.getDias()
        );


        System.out.println("\n2. REALIZAR PRESTAMO");

        invocador.ejecutar(
                new ComandoPrestar(mediador, solicitud, false)
        );

        System.out.println(
                "Estado del libro: " + java.getEstado()
        );


        System.out.println("\n3. PRESTAMO DUPLICADO");

        invocador.ejecutar(
                new ComandoPrestar(mediador, solicitud, false)
        );


        System.out.println("\n4. DEVOLVER LIBRO");

        invocador.ejecutar(
                new ComandoDevolver(mediador, solicitud, 3)
        );

        System.out.println(
                "Estado del libro: " + java.getEstado()
        );

        System.out.println(
                "Multas pendientes: $" +
                        ana.getMultasPendientes()
        );


        System.out.println("\n5. RESERVA CON MULTAS");

        invocador.ejecutar(
                new ComandoReservar(mediador, solicitud)
        );

        ana.setMultasPendientes(0);


        System.out.println("\n6. RESERVA SIN MULTAS");

        invocador.ejecutar(
                new ComandoReservar(mediador, solicitud)
        );

        System.out.println(
                "Estado del libro: " + java.getEstado()
        );


        System.out.println("\n7. PRESTAMO DE LIBRO RESERVADO");

        invocador.ejecutar(
                new ComandoPrestar(mediador, solicitud, false)
        );


        System.out.println("\n8. PRESTAMO DIGITAL");

        Libro digital = new Libro("Algoritmos Digitales");

        Solicitud solicitudDigital =
                new Solicitud(ana, digital, 5);

        invocador.ejecutar(
                new ComandoPrestar(
                        mediador, solicitudDigital, true
                )
        );

        System.out.println(
                "Estado digital: " + digital.getEstado()
        );

        System.out.println("\n=== FIN DEL PROGRAMA ===");
    }
}