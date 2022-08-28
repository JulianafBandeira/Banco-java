public class ContaCorrente extends ContaGeral{

    public ContaCorrente(String cliente, String numero, String agencia, Double saldo, Double limit) {
        super(cliente, numero, agencia, saldo, "CONTA CORRENTE", limit);
    }

    public ContaCorrente(Integer id, String cliente, String numero, String agencia, Integer ativa, Double saldo, String tipo, Double limit) {
        super(id, cliente, numero, agencia, ativa, saldo, tipo, limit);
    }

    public ContaCorrente() {
    }

    @Override
    public Double sacar(Double valor) {
        if(valor > this.getSaldo()){
            System.out.println("Saldo insuficiente");
            return -1.0;
        }else{
           this.saldo = this.saldo - valor;
           registrarHistorico("Saque", valor);
           return this.saldo;
        }
    }
}