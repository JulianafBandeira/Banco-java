import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContaGeral implements Conta{

    protected Integer id;
    protected String cliente;
    protected String numero;
    protected String agencia;
    protected Integer ativa;
    protected Double saldo;
    protected String tipo;
    protected Double limit;

    protected List<Historico> historicos;

    public ContaGeral(String cliente, String numero, String agencia, Double saldo, String tipo, Double limit) {
        this.cliente = cliente;
        this.numero = numero;
        this.agencia = agencia;
        this.ativa = 1;
        this.saldo = saldo;
        this.historicos = new ArrayList<>();
        this.tipo = tipo;
        this.limit = limit;
    }

    public ContaGeral(Integer id, String cliente, String numero, String agencia, Integer ativa, Double saldo, String tipo, Double limit) {
        this.id = id;
        this.cliente = cliente;
        this.numero = numero;
        this.agencia = agencia;
        this.ativa = ativa;
        this.saldo = saldo;
        this.tipo = tipo;
        this.limit = limit;
        this.historicos = new ArrayList<>();
    }

    public ContaGeral(){
    }

    @Override
    public Double depositar(Double valor) {
        registrarHistorico("Deposito", valor);
        return this.saldo = this.saldo + valor;
    }

    @Override
    public Double sacar(Double valor) {
        if(this.tipo.equals("ESPECIAL") && valor > (this.saldo + this.limit)){
            return -1.0;
        }

        if(this.tipo.equals("ESPECIAL")){
            this.saldo = this.saldo - valor;
            if(this.saldo < 0){
                this.limit = this.limit + this.saldo;
                this.saldo = 0.0;
            }

            registrarHistorico("Saque", valor);
            return this.saldo + this.limit;
        }
        registrarHistorico("Saque", valor);
        return this.saldo = this.saldo - valor;
    }

    @Override
    public void exibirExtrato() {
        System.out.println("Conta : " + this.numero + " agência: " + this.agencia);
        for (int i = 0; i < historicos.size(); i++) {
            System.out.println(historicos.get(i));
        };
    }

    @Override
    public void exibirSaldo() {
        System.out.println("Saldo atual R$: " + this.saldo);
    }

    @Override
    public Double transferir(Conta contaDestino, Double valor) {

        if(valor > this.saldo){
            return -1.0;
        }
        this.saldo = this.saldo - valor;

        registrarHistorico("Transferencia enviada", valor);
        contaDestino.depositar(valor);
        contaDestino.registrarHistorico("Transferencia recebida", valor);
        return this.saldo;
    }

    @Override
    public boolean encerrarConta() {
        if(this.saldo > 0) {
            System.out.println("Há R$: " + this.saldo + " para ser reembolsado!");
            return  false;
        }else if(this.saldo < 0){
            System.out.println("Há R$: " + this.saldo + " para ser pago!");
        }
        this.ativa = 0;
        return true;
    }

    @Override
    public boolean reativarConta() {
        this.ativa = 1;
        return true;
    }


    @Override
    public String numero() {
        return this.numero;
    }

    @Override
    public String agencia() {
        return this.agencia;
    }

    @Override
    public void registrarHistorico(String message, Double valor){
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        Historico movimentacao = new Historico(message, date , valor, this.id);
        BancoDeDados.salvaHistorico(movimentacao);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Integer getAtiva() {
        return ativa;
    }

    public void setAtiva(Integer ativa) {
        this.ativa = ativa;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getLimit() {
        return limit;
    }

    public void setLimit(Double limit) {
        this.limit = limit;
    }

    public List<Historico> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(List<Historico> historicos) {
        this.historicos = historicos;
    }
}
