# Sistema Bancário em Java

Este é um sistema bancário simples implementado em Java, que permite gerenciar clientes e contas bancárias.

## Funcionalidades

- Cadastro de clientes (Pessoa Física e Jurídica)
- Cadastro de contas bancárias (Corrente, Poupança e Rendimento)
- Operações bancárias (depósitos e saques)
- Listagem de clientes e contas
- Remoção de clientes e suas contas

## Tipos de Contas

### Conta Corrente
- Pode ter ou não limite
- Permite depósitos e saques
- Não possui rendimento

### Conta Poupança
- Não possui limite
- Permite depósitos e saques
- Rendimento de 0.5% ao mês

### Conta Rendimento
- Não possui limite
- Permite apenas depósitos
- Rendimento de 1% ao mês

## Estrutura do Projeto

- `Banco.java`: Classe principal que gerencia o sistema
- `Cliente.java`: Interface para clientes
- `PessoaFisica.java`: Implementação de cliente pessoa física
- `PessoaJuridica.java`: Implementação de cliente pessoa jurídica
- `Conta.java`: Classe abstrata para contas
- `ContaCorrente.java`: Implementação de conta corrente
- `ContaPoupanca.java`: Implementação de conta poupança
- `ContaRendimento.java`: Implementação de conta rendimento