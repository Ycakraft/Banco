public class ContaRendimento extends Conta {
    private static final double TAXA_RENDIMENTO = 0.01; // 1% ao mês

    public ContaRendimento(String numero, Cliente titular) {
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
        System.out.println("Conta de rendimento não permite saques!");
        return false;
    }

    @Override
    public void render() {
        double rendimento = saldo * TAXA_RENDIMENTO;
        saldo += rendimento;
        System.out.println("Rendimento aplicado: R$ " + String.format("%.2f", rendimento));
    }
} 