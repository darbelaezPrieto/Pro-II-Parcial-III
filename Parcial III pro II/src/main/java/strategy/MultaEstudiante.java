package strategy;

public class MultaEstudiante implements EstrategiaMulta {

    @Override
    public double calcular(int diasRetraso) {
        return Math.max(0, diasRetraso) * 1000;
    }
}
