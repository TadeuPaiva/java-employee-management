
package APLICANDO_PRATICA.EXERCICIO;

public class Pessoa {

    private String nome;
    private String email;

    // Construtor que recebe o nome e o e-mail como parâmetros.
    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Pessoa() {} // Construtor vazio, permite criar uma Pessoa sem informar dados inicialmente.

    public String getNome() {
        return nome; // Retorna o valor armazenado no atributo nome.
    }

    public void setNome(String nome) {
        this.nome = nome; // Atualiza o atributo nome com o valor recebido.
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
