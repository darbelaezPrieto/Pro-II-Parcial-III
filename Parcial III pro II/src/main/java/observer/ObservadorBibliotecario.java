package observer;

public class ObservadorBibliotecario implements Observador {

    @Override
    public void actualizar(String mensaje) {
        System.out.println("[Bibliotecario] " + mensaje);
    }
}