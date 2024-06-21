import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
    private JButton botaoInserirVeiculo; // insere um veiculo em uma vaga
    private JButton botaoRemoverVeiculo; // remove veiculo da vaga e efetiva pagamento
    private JButton botaoGerarRelatorio;
    private JButton botaoReservarVaga;
    private JButton botaoCadastrarCliente;

    public GUI(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.getContentPane().setBackground(new Color(255,0,0));
        this.setLayout(null);
        this.setTitle("Gerenciador de Estacionamento");

        botaoInserirVeiculo = new JButton("Inserir Veiculo");
        botaoInserirVeiculo.setBounds(100,75,200,50);
        botaoInserirVeiculo.addActionListener(this);

        botaoRemoverVeiculo = new JButton("Remover Veiculo");
        botaoRemoverVeiculo.setBounds(100,150,200,50);
        botaoRemoverVeiculo.addActionListener(this);

        botaoGerarRelatorio = new JButton("Gerar Relatorio");
        botaoGerarRelatorio.setBounds(100,225,200,50);
        botaoGerarRelatorio.addActionListener(this);

        botaoCadastrarCliente = new JButton("Cadastrar Cliente");
        botaoCadastrarCliente.setBounds(100,300,200,50);
        botaoCadastrarCliente.addActionListener(this);

        botaoReservarVaga = new JButton("Reservar Vaga");
        botaoReservarVaga.setBounds(100,375,200,50);
        botaoReservarVaga.addActionListener(this);

        this.add(botaoInserirVeiculo);
        this.add(botaoRemoverVeiculo);
        this.add(botaoGerarRelatorio);
        this.add(botaoCadastrarCliente);
        this.add(botaoReservarVaga);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botaoInserirVeiculo){
            //aqui cria uma nova janela e fecha a principal para usuario inserir os veiculos
            // ao final, abre novamente a janela principal
            this.dispose();
            GUI_InserirVeiculo guiInserirVeiculo = new GUI_InserirVeiculo();
        }
        if (e.getSource() == botaoRemoverVeiculo){
            // aqui cria uma nova janela para efetuar o pagamento
            // se efetivado, gerar recibo e remover veiculo
            // usuario volta a janela principal
        }
        if (e.getSource() == botaoGerarRelatorio){
            //aqui cria uma nova janela mostrando relatorio do estacionamento
            //usuario volta a janela principal
        }
        if (e.getSource() == botaoCadastrarCliente){
            // cria nova janela para cadastrar um cliente
            // usuario volta a janela principal
        }
        if (e.getSource() == botaoReservarVaga){
            //cria nova janela para reservar uma vaga conforme regras e condicoes definidas
            // usuario volta a janela principal
        }
    }
}
