public abstract class Conta {
    protected String numero;
    protected Cliente titular;
    protected double saldo;
    protected double limite;

    public Conta(String numero, Cliente titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0.0;
        this.limite = 0.0;
    }

    public abstract void depositar(double valor);
    public abstract boolean sacar(double valor);
    public abstract void render();

    public String getNumero() {
        return numero;
    }

    public Cliente getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numero='" + numero + '\'' +
                ", titular=" + titular.getNome() +
                ", saldo=" + saldo +
                ", limite=" + limite +
                '}';
    }
} 