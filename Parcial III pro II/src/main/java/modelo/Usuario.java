package modelo;

public class Usuario {

    private String nombre;
    private String tipo;
    private boolean activo;
    private double multasPendientes;

    public Usuario(String nombre, String tipo,
                   boolean activo, double multasPendientes) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.activo = activo;
        this.multasPendientes = multasPendientes;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isActivo() {
        return activo;
    }

    public double getMultasPendientes() {
        return multasPendientes;
    }

    public void setMultasPendientes(double monto) {
        multasPendientes = monto;
    }
}