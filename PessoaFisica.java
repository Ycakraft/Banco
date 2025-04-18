public class PessoaFisica implements Cliente {
    private String nome;
    private String cpf;
    private String endereco;

    public PessoaFisica(String nome, String cpf, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getIdentificacao() {
        return cpf;
    }

    @Override
    public String getEndereco() {
        return endereco;
    }

    @Override
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }
} 