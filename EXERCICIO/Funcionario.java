
package APLICANDO_PRATICA.EXERCICIO;

public abstract class Funcionario extends Pessoa { // Declara uma classe abstrata que herda atributos e métodos da classe Pessoa.

    private double salario;

    public Funcionario(double salario) {
        this.salario = salario; // Atribui o valor recebido ao atributo salario do objeto atual.
    }

    public Funcionario () {}

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    abstract double calcularSalario(); // Declara um método abstrato que deverá ser implementado pelas classes concretas que herdarem esta classe.

    void exibirRelatorio() { // Declara um método que exibe um relatório com os dados do funcionário.
        System.out.println("Nome: " + getNome());
        System.out.println("Cargo: " + cargo());
        System.out.println("Salário base: " + getSalario());
        System.out.println("Salário final: " + calcularSalario());
    }

    // Ao imprimir um objeto, o Java chama o toString, que por padrão imprime o padrão herdado de object "Classe@hash".
    @Override // Informa o compilador que substituimos um metodo herdado
    public String toString() {
        // Monta o texto que representa o objeto, juntando os dados com " | " como separador.
        return "Nome: " + getNome()
                + " | Cargo: " + cargo()
                + " | Salário base: " + getSalario()
                + " | Salário final: " + calcularSalario();
        // Informamos o Java como deve ser a saída, imprimir um Funcionario (ou uma lista deles) mostrando os dados reais.
    }

    abstract String cargo(); // Declara um método abstrato que deverá informar o cargo nas subclasses.
}
