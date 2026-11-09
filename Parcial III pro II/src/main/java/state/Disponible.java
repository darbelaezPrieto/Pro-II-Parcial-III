package state;

import modelo.Libro;

public class Disponible implements EstadoLibro {

    @Override
    public String nombre() {
        return "DISPONIBLE";
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
        libro.setEstado(new Reservado());
        return true;
    }
}