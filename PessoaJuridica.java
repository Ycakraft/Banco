public class PessoaJuridica implements Cliente {
    private String nome;
    private String cnpj;
    private String endereco;

    public PessoaJuridica(String nome, String cnpj, String endereco) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getIdentificacao() {
        return cnpj;
    }

    @Override
    public String getEndereco() {
        return endereco;
    }

    @Override
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }
} 