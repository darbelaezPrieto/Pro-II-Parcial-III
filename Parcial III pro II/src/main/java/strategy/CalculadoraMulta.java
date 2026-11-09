package strategy;

public class CalculadoraMulta {

    private EstrategiaMulta estrategia;

    public CalculadoraMulta(EstrategiaMulta estrategia) {
        this.estrategia = estrategia;
    }

    public double calcular(int diasRetraso) {
        return estrategia.calcular(diasRetraso);
    }
}