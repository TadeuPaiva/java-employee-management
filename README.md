# Java Employee Management

Projeto de estudos desenvolvido em Java com o objetivo de praticar os fundamentos da Programação Orientada a Objetos (POO), utilizando como exemplo um sistema simples de gerenciamento de funcionários e cálculo de salários.

O projeto permite representar diferentes cargos profissionais, armazenar seus dados, calcular salários finais conforme as regras implementadas em cada classe e exibir relatórios utilizando uma estrutura comum.

## Objetivos do projeto

- Praticar os fundamentos da Programação Orientada a Objetos em Java.
- Compreender como funciona a herança entre classes.
- Aplicar encapsulamento utilizando atributos privados, getters e setters.
- Entender o papel de classes e métodos abstratos.
- Implementar polimorfismo por meio da sobrescrita de métodos.
- Utilizar interfaces e implementações de listas.
- Trabalhar com coleções de objetos de diferentes subclasses.
- Desenvolver a capacidade de organizar e documentar código Java.

## Tecnologias utilizadas

- **Java:** linguagem utilizada no desenvolvimento.
- **Programação Orientada a Objetos (POO):** paradigma utilizado na estruturação do projeto.
- **Java Collections Framework:** utilização da interface `List` e da implementação `ArrayList`.
- **IntelliJ IDEA:** ambiente de desenvolvimento utilizado.

## Estrutura do projeto

As classes estão organizadas no pacote `APLICANDO_PRATICA.EXERCICIO`.

```text
APLICANDO_PRATICA.EXERCICIO/
├── Pessoa.java
├── Funcionario.java
├── Desenvolvedor.java
├── ProductManager.java
├── DevOps.java
└── Main.java
```

> **Observação:** `ProductManager.java` e `DevOps.java` fazem parte da estrutura prevista no exemplo principal. Suas implementações devem definir o cálculo salarial e o cargo de cada profissional.

---

## 1. Classe Pessoa

A classe `Pessoa` representa os dados básicos de uma pessoa. Ela armazena nome e e-mail, que poderão ser utilizados pelas classes que herdarem suas características.

### Conceitos aplicados

**Encapsulamento**

Os atributos `nome` e `email` são declarados com o modificador `private`. Isso impede o acesso direto a esses atributos por outras classes, permitindo controlar o acesso por meio de métodos.

**Construtor com parâmetros**

O construtor `Pessoa(String nome, String email)` permite criar um objeto já informando o nome e o e-mail.

**Construtor vazio**

O construtor `Pessoa()` permite criar um objeto sem informar esses dados inicialmente.

**Getters e setters**

- `getNome()` e `getEmail()` retornam os valores armazenados.
- `setNome()` e `setEmail()` permitem definir ou alterar esses valores.

**Uso de `this`**

A palavra-chave `this` referencia o objeto atual. Por exemplo, `this.nome = nome` atribui o valor do parâmetro `nome` ao atributo `nome` do objeto.

Essa distinção é necessária porque o atributo e o parâmetro possuem o mesmo nome.

---

## 2. Classe Funcionario

A classe `Funcionario` herda de `Pessoa` e acrescenta o atributo `salario`, além de métodos relacionados ao cálculo salarial e à exibição de relatórios.

Ela foi declarada como uma classe abstrata porque representa uma estrutura genérica de funcionário, da qual outros tipos de profissionais poderão herdar.

### Conceitos aplicados

**Herança — `extends Pessoa`**

A classe `Funcionario` herda os métodos públicos de `Pessoa`, como `getNome()`, `setNome()`, `getEmail()` e `setEmail()`.

Assim, não é necessário declarar novamente esses métodos ou os atributos de nome e e-mail.

**Classe abstrata — `abstract`**

Uma classe abstrata não pode ser instanciada diretamente com `new Funcionario()`.

Sua finalidade é fornecer uma estrutura comum para as subclasses, permitindo que cada tipo de funcionário implemente comportamentos específicos.

**Métodos abstratos**

```java
abstract double calcularSalario();

abstract String cargo();
```

Esses métodos declaram comportamentos obrigatórios para as subclasses concretas.

- `calcularSalario()` deve retornar o salário final.
- `cargo()` deve retornar a identificação do cargo.

Como não possuem corpo, esses métodos deixam a implementação a cargo das classes derivadas.

**Método `exibirRelatorio()`**

O método apresenta quatro informações:

- Nome do funcionário.
- Cargo.
- Salário base.
- Salário final calculado.

Ele utiliza `System.out.println()` para exibir os dados no console.

**Polimorfismo**

O método `exibirRelatorio()` chama `cargo()` e `calcularSalario()` sem precisar conhecer os detalhes de suas implementações.

O Java executa as versões correspondentes à classe concreta do objeto.

**Modificadores de acesso**

O atributo `salario` é privado, enquanto `getSalario()` e `setSalario()` são públicos.

Já `exibirRelatorio()`, `calcularSalario()` e `cargo()` não possuem modificador de acesso explícito. Portanto, têm acesso de pacote (*package-private*), ficando acessíveis às classes do mesmo pacote.

**Construtores**

A classe possui um construtor que recebe o salário e outro vazio.

É importante observar que esses construtores não inicializam automaticamente o nome e o e-mail. Para inicializar todos esses dados na criação do objeto, seria possível implementar um construtor que recebesse os parâmetros correspondentes e chamasse `super(nome, email)`.

---

## 3. Classe Desenvolvedor

A classe `Desenvolvedor` herda de `Funcionario` e implementa os métodos abstratos definidos pela classe pai.

### Conceitos aplicados

**Sobrescrita de métodos — `@Override`**

A anotação `@Override` indica que um método está implementando ou sobrescrevendo um método herdado.

Ela também ajuda o compilador a identificar erros, como a utilização de um nome ou uma assinatura incorreta.

**Cálculo salarial**

```java
@Override
double calcularSalario() {
    return getSalario() * 1.15;
}
```

O método aplica um acréscimo de 15% ao salário base.

Exemplo:

- Salário base: R$ 8.000,00.
- Acréscimo de 15%: R$ 1.200,00.
- Salário final: R$ 9.200,00.

A multiplicação por `1.15` representa o salário original acrescido de 15%.

Esse percentual é uma regra didática do projeto, não uma regra salarial real.

**Identificação do cargo**

```java
@Override
String cargo() {
    return "Desenvolvedor";
}
```

O método retorna uma `String` com o nome do cargo.

**Construtor padrão**

Como a classe não declara construtores próprios, o Java disponibiliza um construtor sem parâmetros que chama o construtor vazio da classe pai.

Isso permite criar o objeto com `new Desenvolvedor()` e preencher seus dados posteriormente usando os setters.

---

## 4. Classes ProductManager e DevOps

Essas classes representam outros tipos de funcionários.

Para funcionarem com a estrutura definida em `Funcionario`, devem herdar dessa classe e implementar os métodos abstratos `calcularSalario()` e `cargo()`.

Cada classe pode possuir suas próprias regras de cálculo salarial e retornar uma identificação específica para o cargo.

Por exemplo, a implementação de `cargo()` em `ProductManager` pode retornar `"Product Manager"`, enquanto a implementação em `DevOps` pode retornar `"DevOps"`.

As regras de cálculo devem ser definidas de acordo com o comportamento desejado para cada tipo de profissional.

Essa estrutura demonstra como diferentes classes podem compartilhar uma mesma interface comportamental sem precisar utilizar a mesma implementação interna.

---

## 5. Classe Main

A classe `Main` reúne as instruções responsáveis por criar os objetos, preencher seus dados, armazená-los em uma lista e exibir os relatórios.

### Criação dos objetos

```java
Funcionario desenvolvedor = new Desenvolvedor();
```

Essa instrução declara uma variável do tipo `Funcionario`, mas cria um objeto concreto da classe `Desenvolvedor`.

Isso é permitido porque `Desenvolvedor` herda de `Funcionario`.

O tipo da variável determina quais membros podem ser acessados por meio dela, enquanto a classe concreta do objeto determina qual implementação sobrescrita será executada em tempo de execução.

O mesmo princípio é aplicado aos objetos `ProductManager` e `DevOps`.

### Preenchimento dos dados

Os métodos setters são utilizados para definir nome, e-mail e salário de cada funcionário.

Exemplo:

```java
desenvolvedor.setNome("Joao");
desenvolvedor.setEmail("joao@dev.com");
desenvolvedor.setSalario(8000);
```

Nesse caso, o objeto recebe os dados de um desenvolvedor com salário base de R$ 8.000,00.

Os valores são apenas dados fictícios para demonstração.

### Criação da lista

```java
List<Funcionario> funcionarios = new ArrayList<>();
```

Essa declaração utiliza dois conceitos importantes.

- **`List`** é uma interface que define operações para trabalhar com listas.
- **`ArrayList`** é uma classe que implementa essa interface e permite armazenar uma coleção dinâmica de elementos.

O uso de `List<Funcionario>` permite armazenar objetos de `Funcionario` e de suas subclasses.

Essa abordagem também reduz o acoplamento à implementação específica da lista. Caso necessário, outra implementação compatível com `List` poderá ser utilizada sem alterar a declaração da variável.

### Adição dos funcionários

O método `add()` adiciona cada objeto à lista.

```java
funcionarios.add(desenvolvedor);
funcionarios.add(productManager);
funcionarios.add(devOps);
```

Após essas operações, a lista contém três objetos, preservando a ordem em que foram adicionados.

### Laço `for-each`

```java
for (Funcionario funcionario : funcionarios) {
    funcionario.exibirRelatorio();
}
```

O laço `for-each` percorre os elementos da lista, um por vez.

A cada repetição, a variável `funcionario` referencia o objeto atual, permitindo chamar `exibirRelatorio()`.

O código não precisa criar um laço específico para cada cargo.

### Polimorfismo na prática

O polimorfismo é um dos principais conceitos demonstrados pelo projeto.

Embora todos os elementos sejam tratados como `Funcionario`, cada objeto pode possuir um comportamento diferente para os métodos `calcularSalario()` e `cargo()`.

Quando o relatório é exibido, o Java executa as implementações correspondentes ao tipo concreto do objeto.

Isso torna o código mais reutilizável e facilita a inclusão de novos cargos.

Para adicionar outro tipo de funcionário, basta criar uma nova subclasse que implemente os métodos abstratos e adicionar uma instância à lista.

---

## 6. Fluxo de execução

O funcionamento do programa pode ser resumido nas seguintes etapas:

1. Criar os objetos das classes concretas.
2. Definir nome, e-mail e salário base.
3. Adicionar os objetos à lista de funcionários.
4. Percorrer a lista com um laço `for-each`.
5. Exibir o relatório de cada funcionário.
6. Calcular o salário final conforme a implementação da classe concreta.

O resultado esperado é um relatório por funcionário, contendo nome, cargo, salário base e salário final.

Os valores finais dos cargos `ProductManager` e `DevOps` dependem das respectivas implementações de `calcularSalario()`.

---

## 7. Como executar o projeto

1. Instale um JDK compatível com o projeto.
2. Abra o projeto no IntelliJ IDEA ou em outra IDE Java.
3. Confira se todas as classes estão no pacote `APLICANDO_PRATICA.EXERCICIO`.
4. Verifique se `ProductManager` e `DevOps` implementam os métodos abstratos necessários.
5. Execute a classe `Main`.

Para um projeto configurado com Java 21, utilize a assinatura tradicional do método de entrada:

```java
public static void main(String[] args) {
    // Instruções do programa.
}
```

Essa assinatura é a opção mais compatível para iniciar aplicações Java convencionais. A forma `static void main()` usada originalmente pode depender de recursos de inicialização simplificada disponíveis em versões mais recentes do Java.

---

## 8. Conceitos de Java estudados

| Conceito | Aplicação no projeto |
|---|---|
| Classes e objetos | `Pessoa`, `Funcionario` e suas subclasses |
| Encapsulamento | Atributos privados e acesso por getters e setters |
| Construtores | Inicialização dos objetos |
| Herança | `Funcionario extends Pessoa` e `Desenvolvedor extends Funcionario` |
| Abstração | Classe abstrata `Funcionario` |
| Métodos abstratos | `calcularSalario()` e `cargo()` |
| Sobrescrita | Implementações com `@Override` |
| Polimorfismo | Execução de comportamentos diferentes pela mesma referência de tipo `Funcionario` |
| Interfaces | Utilização de `List` |
| Coleções | Armazenamento dos funcionários em `ArrayList` |
| Laços de repetição | Percurso dos elementos com `for-each` |
| Retorno de métodos | Utilização de `return` para devolver valores |

## 9. Possíveis melhorias futuras

O projeto pode ser expandido gradualmente para praticar outros recursos da linguagem.

- Criar construtores completos para inicializar todos os dados dos funcionários.
- Implementar validação para impedir salários negativos.
- Aplicar regras de cálculo salarial específicas para cada cargo.
- Utilizar `BigDecimal` para cálculos monetários com maior controle de precisão decimal.
- Separar as responsabilidades de cadastro, cálculo e apresentação dos relatórios.
- Implementar testes unitários para verificar os cálculos salariais.
- Criar uma interface de linha de comando para cadastrar e consultar funcionários.
- Persistir os dados em um banco de dados relacional.

## 10. Considerações finais

Este projeto representa um exercício prático de Programação Orientada a Objetos em Java.

Sua principal finalidade é demonstrar como diferentes classes podem compartilhar características comuns, especializar comportamentos e ser tratadas de maneira uniforme por meio de uma classe abstrata e de uma coleção.

O projeto também serve como base para exercícios futuros envolvendo validação, testes, persistência de dados e organização de aplicações back-end.

**Status:** projeto de estudos em desenvolvimento.

**Autor:** Tadeu Paiva
