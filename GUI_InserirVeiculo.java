import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;

public class GUI_InserirVeiculo extends JFrame implements ActionListener {
    int i;
    private JButton retornarPrincipal;
    private JLabel mensagem;

    private JPanel addCarro;
    private JTextField carCor;
    private JTextField carModelo;
    private JTextField carMarca;
    private JButton estacionarCarro;

    private JPanel addMoto;
    private JTextField motoMarca;
    private JTextField motoCilindradas;
    private JButton estacionarMoto;

    private JPanel addCaminhao;
    private JTextField caminhaoCarga;
    private JTextField caminhaoComprimento;
    private JButton estacionarCaminhao;

    public GUI_InserirVeiculo() {
        this.setTitle("Gerenciador de Estacionamento - Inserir Veiculo");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLayout(new GridLayout(4, 0, 0, 50));
        this.getContentPane().setBackground(new Color(100,50,200));
        //this.setLayout(null);

        addCarro = new JPanel();
        addCarro.setBackground(new Color(100,100,200));

        addMoto = new JPanel();
        addMoto.setBackground(new Color(100,70,200));

        addCaminhao = new JPanel();
        addCaminhao.setBackground(new Color(100,0,200));

        retornarPrincipal = new JButton("<<Voltar");
        retornarPrincipal.addActionListener(this);

        carCor = new JTextField();
        carCor.setText("Cor");
        carCor.setPreferredSize(new Dimension(100, 30));

        motoMarca = new JTextField();
        motoMarca.setText("Marca");
        motoMarca.setPreferredSize(new Dimension(100, 30));

        motoCilindradas = new JTextField();
        motoCilindradas.setText("Cilindradas");
        motoCilindradas.setPreferredSize(new Dimension(100, 30));

        carMarca = new JTextField();
        carMarca.setText("Marca");
        carMarca.setPreferredSize(new Dimension(100, 30));

        carModelo = new JTextField();
        carModelo.setText("Modelo");
        carModelo.setPreferredSize(new Dimension(100, 30));

        caminhaoCarga = new JTextField();
        caminhaoCarga.setText("Carga Maxima");
        caminhaoCarga.setPreferredSize(new Dimension(100, 30));

        caminhaoComprimento = new JTextField();
        caminhaoComprimento.setText("Comprimento");
        caminhaoComprimento.setPreferredSize(new Dimension(100, 30));

        estacionarCarro = new JButton("Estacionar Carro");
        estacionarCarro.addActionListener(this);
        estacionarMoto = new JButton("Estacionar Moto");
        estacionarMoto.addActionListener(this);
        estacionarCaminhao = new JButton("Estacionar Caminhao");
        estacionarCaminhao.addActionListener(this);

        mensagem = new JLabel();
        mensagem.setBounds(100, 100, 70, 30);

        addCarro.add(carCor);
        addCarro.add(carMarca);
        addCarro.add(carModelo);
        addCarro.add(estacionarCarro);
        addMoto.add(motoMarca);
        addMoto.add(motoCilindradas);
        addMoto.add(estacionarMoto);
        addCaminhao.add(caminhaoCarga);
        addCaminhao.add(caminhaoComprimento);
        addCaminhao.add(estacionarCaminhao);
        this.add(addCarro);
        this.add(addMoto);
        this.add(addCaminhao);
        this.add(retornarPrincipal);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == retornarPrincipal) {
            this.dispose();
            GUI gui = new GUI();
        }
        if (e.getSource() == estacionarCarro) {
            Carro novo = new Carro(carModelo.getText(), carCor.getText(), carMarca.getText());
            Vaga vaga = Vaga.proximaVagaLivreParaCarro(Vaga.estacionamento);
            if (vaga != null){
                vaga.setStatus(1); // vaga ocupada
                novo.setLocal(vaga); // carro "ocupa" a vaga

                this.dispose();
                GUI gui = new GUI();
            } else {
                mensagem.setText("Nenhuma vaga livre");
                addCarro.add(mensagem);
                addCarro.setVisible(false);
                addCarro.setVisible(true);
            }

        }
        if (e.getSource() == estacionarMoto) {
            try {
                Moto novo = new Moto(motoMarca.getText(), parseInt(motoCilindradas.getText()));
                Vaga vaga = Vaga.proximaVagaLivreParaMoto(Vaga.estacionamento);
                if (vaga != null) {
                    vaga.setStatus(1); // vaga ocupada
                    novo.setLocal(vaga); // moto "ocupa" a vaga

                    this.dispose();
                    GUI gui = new GUI();
                } else {
                    mensagem.setText("Nenhuma vaga livre");
                    addMoto.add(mensagem);
                    addMoto.setVisible(false);
                    addMoto.setVisible(true);
                }
            } catch (NumberFormatException o) {
                mensagem.setText("Texto Invalido");
                addMoto.add(mensagem);
                addMoto.setVisible(false);
                addMoto.setVisible(true);
            }

        }
        if (e.getSource() == estacionarCaminhao) {
            try {
                Caminhao novo = new Caminhao(parseInt(caminhaoCarga.getText()), parseInt(caminhaoComprimento.getText()));

                Vaga vaga = Vaga.proximaVagaLivreParaCaminhao(Vaga.estacionamento);
                if (vaga != null){
                    vaga.setStatus(1); // vaga ocupada
                    novo.setLocal(vaga); // caminhao "ocupa" a vaga

                    this.dispose();
                    GUI gui = new GUI();
                } else {
                    mensagem.setText("Nenhuma vaga livre");
                    addCaminhao.add(mensagem);
                    addCaminhao.setVisible(false);
                    addCaminhao.setVisible(true);
                }
            } catch (NumberFormatException o) {
                mensagem.setText("Texto Invalido");
                addCaminhao.add(mensagem);
                addCaminhao.setVisible(false);
                addCaminhao.setVisible(true);
            }
        }
    }
}
