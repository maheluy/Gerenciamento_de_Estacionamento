import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalTime;

public class GUI_RemoverVeiculo extends JFrame implements ActionListener {
    private JTextField placa;
    private JButton localizarRemover;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JButton retornarPrincipal;
    private JLabel mensagem;

    private JButton cartao;
    private JButton dinheiro;
    private JButton pix;

    private Pagamento p;


    public GUI_RemoverVeiculo() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.getContentPane().setBackground(new Color(0,150,255));
        this.setLayout(new GridLayout(3, 0));
        this.setTitle("Gerenciador de Estacionamento - Retirar Veiculo");

        placa = new JTextField("Placa");
        placa.setPreferredSize(new Dimension(200, 60));

        localizarRemover = new JButton("Localizar e Retirar");
        localizarRemover.addActionListener(this);

        panel1 = new JPanel();
        panel1.setBackground(new Color(0, 150, 255));

        panel2 = new JPanel();
        panel2.setBackground(new Color(0, 150, 255));

        panel3 = new JPanel();
        panel3.setBackground(new Color(0, 150, 255));
        panel3.setLayout(new GridLayout(0,2));

        retornarPrincipal = new JButton("<<Voltar");
        retornarPrincipal.addActionListener(this);

        mensagem = new JLabel();

        panel1.add(placa);
        panel3.add(retornarPrincipal);
        panel3.add(localizarRemover);
        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.setVisible(true);

        cartao = new JButton("Cartao");
        cartao.addActionListener(this);
        dinheiro = new JButton("Dinheiro");
        dinheiro.addActionListener(this);
        pix = new JButton("PIX");
        pix.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == retornarPrincipal){
            this.dispose();
            GUI gui = new GUI();
        }
        if (e.getSource() == localizarRemover){
            String placatxt = placa.getText();
            Veiculo retirar = null;
            int i;
            boolean status = false;

            for (i = 0; i < GUI_InserirVeiculo.veiculosNaoCadastradosEstacionados.size() && !status; i++){
                retirar = GUI_InserirVeiculo.veiculosNaoCadastradosEstacionados.get(i);
                if (retirar.getPlaca().equals(placatxt)){
                    // efetuar pagamento

                    GUI_InserirVeiculo.veiculosNaoCadastradosEstacionados.remove(retirar);
                    retirar.getLocal().setStatus(0);
                    retirar.setLocal(null); // removido

                    status = true;
                }
            }
            if (!status){
                for (i = 0; i < GUI_InserirVeiculo.veiculosCadastradosEstacionados.size() && !status; i++){
                    retirar = GUI_InserirVeiculo.veiculosCadastradosEstacionados.get(i);
                    if (retirar.getPlaca().equals(placatxt)){
                        //efetuar pagamento

                        GUI_InserirVeiculo.veiculosCadastradosEstacionados.remove(retirar);
                        retirar.getLocal().setStatus(0);
                        retirar.setLocal(null); // removido

                        status = true;
                    }
                }
            }
            if (!status){
                mensagem.setText("Nao encontrado");
                panel2.add(mensagem);
                panel2.setVisible(false);
                panel2.setVisible(true);
            } else if (retirar != null){ // fazer pagamento
                p = new Pagamento(retirar);
                File recibo;
                PrintWriter output;
                try {
                    recibo = new File("C:\\Users\\User\\IdeaProjects\\Gerenciador-Estacionamento\\src\\Recibo.txt");
                    output = new PrintWriter(recibo);
                } catch (FileNotFoundException o){
                    throw new RuntimeException(o);
                }
                retirar.setTSaida(LocalTime.now());
                p.calcularValor(retirar);
                output.println("Veiculo placa: " + retirar.getPlaca() + "Valor: " + p.getValor());

                panel1.remove(placa);
                this.remove(panel1);
                this.remove(panel2);
                this.remove(panel3);
                this.remove(retornarPrincipal);

                mensagem.setText("R$" + p.getValor() + "\nForma de pagamento:");

                panel1.add(mensagem);
                panel2.add(cartao);
                panel2.add(dinheiro);
                panel2.add(pix);
                this.add(panel1);
                this.add(panel2);
                this.setVisible(false);
                this.setVisible(true);
            }
        }
        if (e.getSource() == cartao || e.getSource() == dinheiro || e.getSource() == pix){
            Pagamento.pagamentos.add(p);
            System.out.println(Pagamento.pagamentos.getFirst().getValor());
            this.dispose();
            GUI gui = new GUI();
        }
    }
}
