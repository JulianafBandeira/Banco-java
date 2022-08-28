public class Historico {
    private String tipoMoveimento;
    private String data;
    private Double valor;
    private Integer conta;

    public Historico(String tipoMoveimento, String data, Double valor, Integer conta) {
        this.tipoMoveimento = tipoMoveimento;
        this.data = data;
        this.valor = valor;
        this.conta = conta;
    }

    public Historico(String tipoMoveimento, String data, Double valor) {
        this.tipoMoveimento = tipoMoveimento;
        this.data = data;
        this.valor = valor;
    }

    public String getTipoMoveimento() {
        return tipoMoveimento;
    }

    public String getData() {
        return data;
    }

    public Double getValor() {
        return valor;
    }

    public Integer getConta() {
        return conta;
    }

    @Override
    public String toString() {
        return "Historico{ Tipo do Moveimento: " + tipoMoveimento + ", data: " + data +  ", valor: " + valor +  "}";
    }
}