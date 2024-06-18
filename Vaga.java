public class Vaga {
    private int numero;
    private int localizacao;

    private int status; //seria ideal um boolean, mas sao 3 estados
    // 0 livre, 1 - ocupada, 2 - reservada

    private Veiculo tipo;

    public Vaga(int numero, int localizacao, int status, Veiculo tipo) {
        this.numero = numero;
        this.localizacao = localizacao;
        this.status = status;
        this.tipo = tipo;
    }

    public int getNumero() {
        return this.numero;
    }
    public int getLocalizacao() {
        return this.localizacao;
    }
    public int getStatus() {
        return this.status;
    }
    public Veiculo getTipo() {
        return this.tipo;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    public void setLocalizacao(int localizacao) {
        this.localizacao = localizacao;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public void setTipo(Veiculo tipo) {
        this.tipo = tipo;
    }
}
