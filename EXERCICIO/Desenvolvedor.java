
package APLICANDO_PRATICA.EXERCICIO;

public class Desenvolvedor extends Funcionario { // Declara a classe Desenvolvedor, que herda atributos e métodos da classe Funcionario.

    @Override // Indica que este método sobrescreve um método abstrato herdado da classe Funcionario.
    double calcularSalario() { // Implementa o método responsável por calcular o salário final do desenvolvedor.
        return getSalario() * 1.15; // Retorna o salário base acrescido de 15%, multiplicando-o por 1,15.
    }

    @Override
    String cargo() {
        return "Desenvolvedor";
    }

}
