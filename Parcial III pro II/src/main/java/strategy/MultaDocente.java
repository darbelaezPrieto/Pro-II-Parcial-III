package strategy;

public class MultaDocente implements EstrategiaMulta {

    @Override
    public double calcular(int diasRetraso) {
        return Math.max(0, diasRetraso) * 500;
    }
}