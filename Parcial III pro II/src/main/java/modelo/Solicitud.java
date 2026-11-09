package modelo;

import memento.SolicitudMemento;

public class Solicitud {

    private Usuario usuario;
    private Libro libro;
    private int dias;

    public Solicitud(Usuario usuario, Libro libro, int dias) {
        this.usuario = usuario;
        this.libro = libro;
        this.dias = dias;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public SolicitudMemento guardar() {
        return new SolicitudMemento(dias);
    }

    public void restaurar(SolicitudMemento copia) {
        if (copia != null) {
            dias = copia.getDias();
        }
    }
}