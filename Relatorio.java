import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Relatorio {
    private File relatorio;
    private Scanner input;
    private PrintWriter output;

    public Relatorio() {
        try {
            relatorio = new File("C:\\Users\\User\\IdeaProjects\\Gerenciador-Estacionamento\\src\\Relatorio.txt");
            input = new Scanner(relatorio).useDelimiter("\n");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void gerarRelatorio() {
        try {
            output = new PrintWriter(relatorio);
        } catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
        if (relatorio.canWrite()) {
            output.printf("Vagas no estacionamento:\n");
            for (Vaga vaga : Vaga.estacionamento) { // mostra todas as vagas e seus status
                if (vaga.getStatus() == 0) { // vaga livre
                    output.println("Localizacao: " + vaga.getLocalizacao() + "; Numero: " + vaga.getNumero() + "; Livre");
                } else if (vaga.getStatus() == 1) { // vaga ocupada
                    output.print("Localizacao: " + vaga.getLocalizacao() + "; Numero: " + vaga.getNumero() + "; Ocupada:");
                    for (Veiculo veiculo : GUI_InserirVeiculo.veiculosNaoCadastradosEstacionados) {
                        if (veiculo.local == vaga) {
                            output.println(veiculo.getPlaca() + veiculo.getTEntrada());
                        }
                    }
                    for (Veiculo veiculo : GUI_InserirVeiculo.veiculosCadastradosEstacionados) {
                        if (veiculo.local == vaga) {
                            output.println(veiculo.getPlaca() + veiculo.getTEntrada());
                        }
                    }
                } else if (vaga.getStatus() == 2) { // vaga reservada
                    output.print("Localizacao: " + vaga.getLocalizacao() + "; Numero: " + vaga.getNumero() + "; Reservada");
                    for (Veiculo veiculo : GUI_Reservar.reservados){
                        if (veiculo.getLocal() == vaga){
                            output.println(veiculo.getPlaca());
                        }
                    }
                    // informar dados da vaga
                    // buscar entre veiculos reservados aquele destinado a essa vaga e mostrar placa
                }
            }
            output.printf("\n\nClientes cadastrados:\n");
            for (Cliente cliente : GUI_CadastrarCliente.clientes){
                output.println("Nome: " + cliente.getNome() + "; Email: " + cliente.getEmail() + "; Telefone: " + cliente.getTelefone() + "; Veiculos:");
                for (int i = 0; i < cliente.numVeiculos(); i++){
                    output.printf("    %s\n", cliente.getVeiculo(i).getPlaca());
                }
            }

            for (Pagamento pagamento : Pagamento.pagamentos){
                output.println("Veiculo: " + pagamento.getVeiculo().getPlaca() + "; Valor pago: " + pagamento.getValor() +
                        "Horario de entrada: " + pagamento.getVeiculo().getTEntrada());
            }
        }

        input.close();
        output.close();
    }
}


