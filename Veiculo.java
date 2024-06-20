public abstract class Veiculo {
    protected int tEntrada; // tempo de entrada e saida para calculo do pagamento
    protected int tSaida;
    // protected int valor; //pagamento associado ao veiculo
    protected String placa;
    protected String vaga;

    public Veiculo(String placa ,int tEntrada){
        this.placa = placa;
        this.tEntrada = tEntrada;
    }

    public int getTEntrada() {
        return this.tEntrada;
    }
    public int getTSaida() {
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

    public void setTEntrada(int tEntrada) {
        this.tEntrada = tEntrada;
    }
    public void setTSaida(int tSaida) {
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

