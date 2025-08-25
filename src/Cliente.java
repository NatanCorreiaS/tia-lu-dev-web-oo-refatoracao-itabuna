public class Cliente {

    // Propriedades da classe
    private static volatile int contador = 0;
    private int idCliente;
    private String nome;
    private String telefone;

    // Construtor
    public Cliente(String nome, String telefone) {
        this.idCliente = ++contador;
        this.nome = nome;
        this.telefone = telefone;
    }

    // Getters e Setters
    public int getIdCliente() {
        return idCliente;
    }
    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}