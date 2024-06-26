import java.time.Duration;
import java.util.ArrayList;

public class Pagamento {
    //metodos para calculo de tempo e valor a ser pago, emissao de recibo
    private float valor;
    private Veiculo veiculo;
    public static ArrayList<Pagamento> pagamentos = new ArrayList<Pagamento>();

    public Pagamento(Veiculo veiculo){
        this.veiculo = veiculo;
    }

    // Calculo do valor a ser pago
    public void calcularValor(Veiculo veiculo){
        // Calcula o tempo gasto entre a entrada e saida do veiculo
        Duration duracao = Duration.between(veiculo.getTEntrada(), veiculo.getTSaida());
        // Valor a ser pago = tempo gasto em horas * 2
        this.valor = duracao.toHours() * 100;
    }

    public void setValor(float valor){
        this.valor = valor;
    }
    public void setVeiculo(Veiculo veiculo){
        this.veiculo = veiculo;
    }

    public float getValor(){
        return this.valor;
    }
    public Veiculo getVeiculo(){
        return this.veiculo;
    }
}