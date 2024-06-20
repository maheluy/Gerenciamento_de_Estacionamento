import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String email;
    private int telefone;
    private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

    public Cliente(String nome, String email, int telefone){
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome(){
        return this.nome;
    }
    public String getEmail(){
        return this.email;
    }
    public int getTelefone(){
        return this.telefone;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setTelefone(int telefone){
        this.telefone = telefone;
    }

    public void addVeiculo(Veiculo veiculo){
        veiculos.add(veiculo);
    }
    public boolean removeVeiculo(Veiculo veiculo){
        return veiculos.remove(veiculo);
    }
}
