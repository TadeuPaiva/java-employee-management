
package APLICANDO_PRATICA.EXERCICIO;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static void main() {

        Funcionario desenvolvedor = new Desenvolvedor(); // Cria um objeto Desenvolvedor e armazena sua referência em uma variável do tipo Funcionario.
        desenvolvedor.setNome("Joao");
        desenvolvedor.setEmail("joao@dev.com");
        desenvolvedor.setSalario(8000);

        Funcionario productManager = new ProductManager();
        productManager.setNome("Maria");
        productManager.setEmail("maria@pmanager.com");
        productManager.setSalario(10000);

        Funcionario devOps = new DevOps();
        devOps.setNome("Pedro");
        devOps.setEmail("pedro@ops.com");
        devOps.setSalario(9000);

        Funcionario outroDev = new Desenvolvedor();
        outroDev.setNome("Fernando");
        outroDev.setSalario(15000);

        List<Funcionario> funcionarios = new ArrayList<>(); // Cria uma lista vazia capaz de armazenar objetos do tipo Funcionario ou de suas subclasses.
        funcionarios.add(desenvolvedor); // Adiciona o desenvolvedor à lista.
        funcionarios.add(productManager);
        funcionarios.add(devOps);
        funcionarios.add(outroDev);

        int qtdeDesenvolvedor = 0;
        int qtdeProductManager = 0;
        int qtdeDevOps = 0;

        double totalPagamento = 0;

        for (Funcionario funcionario : funcionarios) { // Percorre a lista, atribuindo cada funcionário à variável funcionario a cada repetição.
            funcionario.exibirRelatorio(); // Exibe o relatório do funcionário atual, usando os métodos implementados pela sua classe concreta.
            totalPagamento = totalPagamento + funcionario.calcularSalario(); // Soma a folha salarial da empresa

            if (funcionario instanceof Desenvolvedor) {
                qtdeDesenvolvedor++;
            } // O instanceof irá verificar se o objeto 'funcionario' é uma instância da classe Desenvolvedor

            if (funcionario instanceof ProductManager) {
                qtdeProductManager++;
            }

            if (funcionario instanceof DevOps) {
                qtdeDevOps++;
            }

            System.out.println("Quantidade desenvolvedor: " + qtdeDesenvolvedor);
            System.out.println("Quantidade product manager: " + qtdeProductManager);
            System.out.println("Quantidade devops: " + qtdeDevOps);
        }

        System.out.println("Total funcionários: " + funcionarios.size());
        System.out.println("Total folha de pagamento: " + totalPagamento);
    }
}
