import java.time.temporal.Temporal;

public abstract class Veiculo {
    protected Temporal tEntrada; // tempo de entrada e saida para calculo do pagamento
    protected Temporal tSaida;
    protected int valor; //pagamento associado ao veiculo
    protected Vaga local;
    protected String placa;

    public Veiculo(String placa){ // para cadastrar
        this.placa = placa;
    }
    public Veiculo(){
    }
    public Veiculo(String placa, Temporal tEntrada){ // para estacionar
        this.placa = placa;
        this.tEntrada = tEntrada;
    }

    public Temporal getTEntrada() {
        return this.tEntrada;
    }
    public Temporal getTSaida() {
        return this.tSaida;
    }
    public int getValor() {
        return this.valor;
    }
    public Vaga getLocal() {
        return this.local;
    }
    public String getPlaca() {
        return this.placa;
    }

    public void setTEntrada(Temporal tEntrada) {
        this.tEntrada = tEntrada;
    }
    public void setTSaida(Temporal tSaida) {
        this.tSaida = tSaida;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public void setLocal(Vaga local) {
        this.local = local;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }

}
