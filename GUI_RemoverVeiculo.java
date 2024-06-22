import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_RemoverVeiculo extends JFrame implements ActionListener {
    private JTextField placa;
    private JButton localizarRemover;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JButton retornarPrincipal;
    private JLabel mensagem;


    public GUI_RemoverVeiculo() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.getContentPane().setBackground(new Color(125,0,0));
        this.setLayout(new GridLayout(3, 0));
        this.setTitle("Gerenciador de Estacionamento - Retirar Veiculo");

        placa = new JTextField("Placa");
        placa.setPreferredSize(new Dimension(200, 60));

        localizarRemover = new JButton("Localizar e Retirar");
        localizarRemover.addActionListener(this);

        panel1 = new JPanel();
        panel1.setBackground(new Color(125, 0, 0));

        panel2 = new JPanel();
        panel2.setBackground(new Color(125, 0, 0));

        panel3 = new JPanel();
        panel3.setBackground(new Color(125, 0, 0));
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == retornarPrincipal){
            this.dispose();
            GUI gui = new GUI();
        }
        if (e.getSource() == localizarRemover){
            String placatxt = placa.getText();
            Veiculo retirar;
            int i;
            boolean status = false;

            for (i = 0; i < GUI_InserirVeiculo.veiculosNaoCadastradosEstacionados.size() && !status; i++){
                retirar = GUI_InserirVeiculo.veiculosNaoCadastradosEstacionados.get(i);
                if (retirar.getPlaca().equals(placatxt)){
                    // efetuar pagamento

                    GUI_InserirVeiculo.veiculosNaoCadastradosEstacionados.remove(retirar);
                    retirar.getLocal().setStatus(0);
                    retirar.setLocal(null);

                    status = true;
                    this.dispose();
                    GUI gui = new GUI();
                }
            }
            if (!status){
                for (i = 0; i < GUI_InserirVeiculo.veiculosCadastradosEstacionados.size() && !status; i++){
                    retirar = GUI_InserirVeiculo.veiculosCadastradosEstacionados.get(i);
                    if (retirar.getPlaca().equals(placatxt)){
                        //efetuar pagamento

                        GUI_InserirVeiculo.veiculosCadastradosEstacionados.remove(retirar);
                        retirar.getLocal().setStatus(0);
                        retirar.setLocal(null);

                        status = true;
                        this.dispose();
                        GUI gui = new GUI();
                    }
                }
            }
            mensagem.setText("Nao encontrado");
            panel2.add(mensagem);
            panel2.setVisible(false);
            panel2.setVisible(true);
        }
    }
}
