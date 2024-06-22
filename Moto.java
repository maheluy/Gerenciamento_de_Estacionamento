public class Moto extends Veiculo{
    private String marca;
    private int cilindradas;

    public Moto(String marca, int cilindradas, String placa){
        super(placa);
        this.marca = marca;
        this.cilindradas = cilindradas;
    }
    public Moto(){}

    public String getMarca() {
        return this.marca;
    }
    public int getCilindradas() {
        return this.cilindradas;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }
}
