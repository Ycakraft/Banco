public class ContaPoupanca extends Conta {
    private static final double TAXA_RENDIMENTO = 0.005; // 0.5% ao mês

    public ContaPoupanca(String numero, Cliente titular) {
        super(numero, titular);
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
        if (valor > 0 && valor <= saldo) {
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
        double rendimento = saldo * TAXA_RENDIMENTO;
        saldo += rendimento;
        System.out.println("Rendimento aplicado: R$ " + String.format("%.2f", rendimento));
    }
} 