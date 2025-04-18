public class ContaCorrente extends Conta {
    public ContaCorrente(String numero, Cliente titular) {
        super(numero, titular);
    }

    public ContaCorrente(String numero, Cliente titular, double limite) {
        super(numero, titular);
        this.limite = limite;
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Valor de depósito inválido!");
        }
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && valor <= (saldo + limite)) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
            return true;
        } else {
            System.out.println("Saldo insuficiente para saque!");
            return false;
        }
    }

    @Override
    public void render() {
        // Conta corrente não rende
    }
} 