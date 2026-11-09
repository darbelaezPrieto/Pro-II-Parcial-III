package observer;

public class ObservadorEstudiante implements Observador {

    @Override
    public void actualizar(String mensaje) {
        System.out.println("[Estudiante] " + mensaje);
    }
}