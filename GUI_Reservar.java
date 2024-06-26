import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI_Reservar extends JFrame implements ActionListener {
    private JButton Reservar;
    private JTextField placa;
    private JTextField email;
    private JButton retornarPrincipal;
    private JPanel grid;

    public static ArrayList<Veiculo> reservados = new ArrayList<Veiculo>();

    public GUI_Reservar() {
        this.setTitle("Gerenciador de Estacionamento - Reserva");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 600);
        BorderLayout layout = new BorderLayout();
        this.setLayout(layout);
        this.getContentPane().setBackground(new Color(100,200,50));

        grid = new JPanel();
        grid.setBackground(new Color(100,200,50));
        grid.setLayout(new GridLayout(3, 0));

        Reservar = new JButton("Reservar");
        Reservar.addActionListener(this);

        placa =  new JTextField();
        placa.setText("Placa");
        placa.setPreferredSize(new Dimension(100, 30));

        email = new JTextField();
        email.setText("Email");
        email.setPreferredSize(new Dimension(100, 30));

        retornarPrincipal = new JButton("Retornar");
        retornarPrincipal.addActionListener(this);

        grid.add(placa);
        grid.add(email);
        grid.add(Reservar);
        this.add(grid, BorderLayout.CENTER);
        this.add(retornarPrincipal, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Reservar) {
            String placatxt = placa.getText();
            String emailtxt = email.getText();
            Vaga vaga = null;
            Veiculo veiculo = null;
            boolean status = false;

            for (Cliente cliente : GUI_CadastrarCliente.clientes){
                if (emailtxt.equals(cliente.getEmail())){
                    for (int i = 0; i < cliente.numVeiculos(); i++){
                        if (cliente.getVeiculo(i).getPlaca().equals(placatxt)){
                            veiculo = cliente.getVeiculo(i);
                            status = true;
                        }
                    }
                }
            }
            if (status){
                if (veiculo instanceof Carro){
                    vaga = Vaga.proximaVagaLivreParaCarro(Vaga.estacionamento);
                }
                else if (veiculo instanceof Moto){
                    vaga = Vaga.proximaVagaLivreParaMoto(Vaga.estacionamento);
                }
                else if (veiculo instanceof Caminhao){
                    vaga = Vaga.proximaVagaLivreParaCaminhao(Vaga.estacionamento);
                }
                if (vaga != null){
                    vaga.setStatus(2);
                    veiculo.setLocal(vaga);
                    reservados.add(veiculo);
                }
                this.dispose();
                GUI gui = new GUI();
            }
            else {
                // mensagem de erro
            }
        }
        if (e.getSource() == retornarPrincipal){
            this.dispose();
            GUI gui = new GUI();
        }
    }
}
