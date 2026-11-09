package state;

import modelo.Libro;

public class Reservado implements EstadoLibro {

    @Override
    public String nombre() {
        return "RESERVADO";
    }

    @Override
    public boolean prestar(Libro libro) {
        libro.setEstado(new Prestado());
        return true;
    }

    @Override
    public boolean devolver(Libro libro) {
        return false;
    }

    @Override
    public boolean reservar(Libro libro) {
        return false;
    }
}