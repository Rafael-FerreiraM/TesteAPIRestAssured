public class Cliente {

    private String nomeCliente;

    private int idade;
    private int risco;
    private int id;

    public void criarUsuario (String nomeCliente, int idade, int risco, int id){
        this.nomeCliente = nomeCliente;
        this.idade = idade;
        this.risco = risco;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    public int getRisco() {
        return risco;
    }

    public void setRisco(int risco) {
        this.risco = risco;
    }

}
