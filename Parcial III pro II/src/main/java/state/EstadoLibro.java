package state;

import modelo.Libro;

public interface EstadoLibro {

    String nombre();

    boolean prestar(Libro libro);

    boolean devolver(Libro libro);

    boolean reservar(Libro libro);
}