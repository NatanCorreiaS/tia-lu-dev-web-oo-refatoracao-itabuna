package modelos;

public class Cliente {

    // Propriedades da classe
    private static int proximoCodigo = 1;
    private int codigo;
    private String nome;
    private String telefone;

    public Cliente(String nome, String telefone) {
        this.codigo = proximoCodigo++;
        this.nome = nome;
        this.telefone = telefone;
    }

    // Getters e Setters
    public int getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }
    public String exibirCliente() {
        return "Código: " + codigo + ", Nome: " + nome + ", Telefone: " + telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}