
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

        Funcionario funcionarioMaiorSalario = null;
        // Variavel do tipo funcionario, classe abstrata não podemos usar o 'new Funcionario();'
        // também 'não podemos' instanciar como Desenvolvedor, DevOps, etc, por não sabermos quem recebe o maior salario

        List<Funcionario> funcionarioAcimaDezMil = new ArrayList<>();

        for (Funcionario funcionario : funcionarios) { // Percorre a lista, atribuindo cada funcionário à variável funcionario a cada repetição.
            funcionario.exibirRelatorio(); // Exibe o relatório do funcionário atual, usando os métodos implementados pela sua classe concreta.
            totalPagamento = totalPagamento + funcionario.calcularSalario(); // Soma a folha salarial da empresa

            if (funcionarioMaiorSalario == null) { // sendo nulo, irá pegar o primeiro funcionario e armazenar na variável e depois verificar novamente
                funcionarioMaiorSalario = funcionario;
            } else { // Na segunda vez não será nulo e cairá aqui no else
                if (funcionario.calcularSalario() > funcionarioMaiorSalario.calcularSalario()) {
                    // validamos se o salário do funcionario na segunda iteração tem o salário maior que o funcionario que está armazenado na variavel maior salario
                    funcionarioMaiorSalario = funcionario;
                    // se for, a var c maior salario passa a receber este novo funcionário
                }
            }

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

            if (funcionario.calcularSalario() > 10000) {
                funcionarioAcimaDezMil.add(funcionario);
                // Caso a verificação seja true, adicionamos o valor a variável
            }
        }

        System.out.println("Total funcionários: " + funcionarios.size());
        System.out.println("Total folha de pagamento: " + totalPagamento);
        System.out.println("O funcionário com o maior salário é: " + funcionarioMaiorSalario);

        System.out.println(funcionarioAcimaDezMil);
    }
}

