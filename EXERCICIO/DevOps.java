package APLICANDO_PRATICA.EXERCICIO;

public class DevOps extends Funcionario{
    @Override
    double calcularSalario() {
        return getSalario() * 1.10;
    }

    @Override
    String cargo() {
        return "DevOps";
    }
}
