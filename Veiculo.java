public abstract class Veiculo {
    protected int tEntrada; // tempo de entrada e saida para calculo do pagamento
    protected int tSaida;
    protected int valor; //pagamento associado ao veiculo
    protected String local;

    public Veiculo(){
    }

    public int getTEntrada() {
        return this.tEntrada;
    }
    public int getTSaida() {
        return this.tSaida;
    }
    public int getValor() {
        return this.valor;
    }
    public String getLocal() {
        return this.local;
    }

    public void setTEntrada(int tEntrada) {
        this.tEntrada = tEntrada;
    }
    public void setTSaida(int tSaida) {
        this.tSaida = tSaida;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public void setLocal(String local) {
        this.local = local;
    }

}

