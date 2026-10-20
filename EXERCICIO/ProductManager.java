package APLICANDO_PRATICA.EXERCICIO;

public class ProductManager extends Funcionario{
    @Override
    double calcularSalario() {
        return getSalario() * 1.20;
    }

    @Override
    String cargo() {
        return "Product Manager";
    }
}
