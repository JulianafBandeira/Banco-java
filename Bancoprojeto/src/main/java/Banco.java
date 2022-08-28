import java.util.ArrayList;
import java.util.List;

public class Banco {
    private Integer id;
    private String nome;
    private List<Conta> contas;

    public Banco(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void cadastraConta(Conta c){
        this.contas.add(c);
    }

    public Conta encontraConta(String numero, String agencia){
        for (Conta c: this.contas) {
            if (c.numero().equals(numero) && c.agencia().equals(agencia)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Banco{" +
                "Código : " + id + ", " +
                "Nome:" + nome +
                "}''";
    }
}