package modelo;

import state.EstadoLibro;
import state.Disponible;

public class Libro {

    private String titulo;
    private EstadoLibro estado;

    public Libro(String titulo) {
        this.titulo = titulo;
        estado = new Disponible();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEstado() {
        return estado.nombre();
    }

    public void setEstado(EstadoLibro estado) {
        this.estado = estado;
    }

    public boolean prestar() {
        return estado.prestar(this);
    }

    public boolean devolver() {
        return estado.devolver(this);
    }

    public boolean reservar() {
        return estado.reservar(this);
    }
}