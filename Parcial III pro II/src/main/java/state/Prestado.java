package state;

import modelo.Libro;

public class Prestado implements EstadoLibro {

    @Override
    public String nombre() {
        return "PRESTADO";
    }

    @Override
    public boolean prestar(Libro libro) {
        return false;
    }

    @Override
    public boolean devolver(Libro libro) {
        libro.setEstado(new Disponible());
        return true;
    }

    @Override
    public boolean reservar(Libro libro) {
        return false;
    }
}