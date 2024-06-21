import java.time.Duration;

public class Pagamento {
    //metodos para calculo de tempo e valor a ser pago, emissao de recibo
    private float valor;

    // Calculo do valor a ser pago
    public void calcularValor(Veiculo veiculo){
        // Calcula o tempo gasto entre a entrada e saida do veiculo
        Duration duracao = Duration.between(veiculo.getTEntrada(), veiculo.getTSaida());
        // Valor a ser pago = tempo gasto em horas * 2
        this.valor = duracao.toHours() * 2;
    }

    public void setValor(float valor){
        this.valor = valor;
    }

    public float getValor(){
        return this.valor;
    }
}
