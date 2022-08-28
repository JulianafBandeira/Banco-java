public class ContaPoupanca extends ContaGeral {

    public ContaPoupanca(String cliente, String numero, String agencia, Double saldo, Double limit) {
        super(cliente, numero, agencia, saldo, "CONTA POUPANCA", limit);
    }

    public ContaPoupanca(Integer id, String cliente, String numero, String agencia, Integer ativa, Double saldo, String tipo, Double limit) {
        super(id, cliente, numero, agencia, ativa, saldo, tipo, limit);
    }

    public ContaPoupanca() {
    }

}