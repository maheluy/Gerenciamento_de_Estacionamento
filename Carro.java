public class Carro extends Veiculo{
    private String modelo;
    private String cor;
    private String marca;

    public Carro(String modelo, String cor, String marca) {
        super();
        this.modelo = modelo;
        this.cor = cor;
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }
    public String getCor(){
        return this.cor;
    }
    public String getMarca(){
        return this.marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
}
public class Carro extends Veiculo{
    private String modelo;
}
