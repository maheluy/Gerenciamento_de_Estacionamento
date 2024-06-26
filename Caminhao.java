import java.time.temporal.Temporal;

public class Caminhao extends Veiculo{
    private int cargaMax;
    private int comprimento;

    public Caminhao(int cargaMax, int comprimento, String placa) {
        super(placa);
        this.cargaMax = cargaMax;
        this.comprimento = comprimento;
    }
    public Caminhao(){}

    public Caminhao(int cargaMax, int comprimento, String placa, Temporal TEntrada) {
        super(placa, TEntrada);
        this.cargaMax = cargaMax;
        this.comprimento = comprimento;
    }

    public int getCargaMax() {
        return this.cargaMax;
    }
    public int getComprimento() {
        return this.comprimento;
    }

    public void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }
    public void setComprimento(int comprimento) {
        this.comprimento = comprimento;
    }
}
