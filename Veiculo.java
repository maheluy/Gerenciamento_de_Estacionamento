import java.time.temporal.Temporal;

public abstract class Veiculo {
    protected Temporal tEntrada; // tempo de entrada e saida para calculo do pagamento
    protected Temporal tSaida;
    // protected int valor; //pagamento associado ao veiculo
    protected String placa;
    protected String vaga;

    public Veiculo(String placa ,Temporal tEntrada){
        this.placa = placa;
        this.tEntrada = tEntrada;
    }

    public Temporal getTEntrada() {
        return this.tEntrada;
    }
    public Temporal getTSaida() {
        return this.tSaida;
    }
    public String getPlaca() {
        return this.placa;
    }
    public String getVaga() {
        return this.vaga;
    }

    /*
    public int getValor() {
        return this.valor;
    }
    public String getLocal() {
        return this.local;
    }
    */

    public void setTEntrada(Temporal tEntrada) {
        this.tEntrada = tEntrada;
    }
    public void setTSaida(Temporal tSaida) {
        this.tSaida = tSaida;
    }
    /*
     * public void setValor(int valor) {
     * this.valor = valor;
     * }
     * public void setLocal(String local) {
     * this.local = local;
     * }
     */

}

