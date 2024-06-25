import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class GUI_InserirVeiculo extends JFrame implements ActionListener {
    public static ArrayList<Veiculo> veiculosNaoCadastradosEstacionados = new ArrayList<Veiculo>();
    public static ArrayList<Veiculo> veiculosCadastradosEstacionados = new ArrayList<Veiculo>();

    private JLabel mensagem; //GUI padrao
    private JPanel buttons;
    private JButton retornarPrincipal;
    private JButton estacionarCadastrado;

    private JPanel infoCarro;
    private JTextField carCor;
    private JTextField carModelo;
    private JTextField carMarca;
    private JTextField carPlaca;
    private JButton estacionarCarro;

    private JPanel infoMoto;
    private JTextField motoMarca;
    private JTextField motoCilindradas;
    private JTextField motoPlaca;
    private JButton estacionarMoto;

    private JPanel infoCaminhao;
    private JTextField caminhaoCarga;
    private JTextField caminhaoComprimento;
    private JTextField caminhaoPlaca;
    private JButton estacionarCaminhao;

    //GUI estacionar veiculo cadastrado
    private JTextField emailCliente;
    private JTextField veiculoCliente;
    private JButton estacionarCliente;

    public GUI_InserirVeiculo() {
        this.setTitle("Gerenciador de Estacionamento - Inserir Veiculo");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLayout(new GridLayout(4, 0, 0, 50));
        this.getContentPane().setBackground(new Color(100,50,200));
        //this.setLayout(null);

        infoCarro = new JPanel();
        infoCarro.setBackground(new Color(100,100,200));

        infoMoto = new JPanel();
        infoMoto.setBackground(new Color(100,70,200));

        infoCaminhao = new JPanel();
        infoCaminhao.setBackground(new Color(100,0,200));

        buttons = new JPanel();
        buttons.setBackground(new Color(100,100,200));
        buttons.setLayout(new GridLayout(0, 2));

        retornarPrincipal = new JButton("<<Voltar");
        retornarPrincipal.addActionListener(this);

        estacionarCadastrado = new JButton("Estacionar Veiculo Cadastrado");
        estacionarCadastrado.addActionListener(this);

        carCor = new JTextField();
        carCor.setText("Cor");
        carCor.setPreferredSize(new Dimension(100, 30));

        motoMarca = new JTextField();
        motoMarca.setText("Marca");
        motoMarca.setPreferredSize(new Dimension(100, 30));

        motoCilindradas = new JTextField();
        motoCilindradas.setText("Cilindradas");
        motoCilindradas.setPreferredSize(new Dimension(100, 30));

        motoPlaca = new JTextField();
        motoPlaca.setText("Placa");
        motoPlaca.setPreferredSize(new Dimension(100, 30));

        carMarca = new JTextField();
        carMarca.setText("Marca");
        carMarca.setPreferredSize(new Dimension(100, 30));

        carModelo = new JTextField();
        carModelo.setText("Modelo");
        carModelo.setPreferredSize(new Dimension(100, 30));

        carPlaca = new JTextField();
        carPlaca.setText("Placa");
        carPlaca.setPreferredSize(new Dimension(100, 30));

        caminhaoCarga = new JTextField();
        caminhaoCarga.setText("Carga Maxima");
        caminhaoCarga.setPreferredSize(new Dimension(100, 30));

        caminhaoComprimento = new JTextField();
        caminhaoComprimento.setText("Comprimento");
        caminhaoComprimento.setPreferredSize(new Dimension(100, 30));

        caminhaoPlaca = new JTextField();
        caminhaoPlaca.setText("Placa");
        caminhaoPlaca.setPreferredSize(new Dimension(100, 30));

        estacionarCarro = new JButton("Estacionar Carro");
        estacionarCarro.addActionListener(this);
        estacionarMoto = new JButton("Estacionar Moto");
        estacionarMoto.addActionListener(this);
        estacionarCaminhao = new JButton("Estacionar Caminhao");
        estacionarCaminhao.addActionListener(this);

        mensagem = new JLabel();
        mensagem.setBounds(100, 100, 70, 30);

        infoCarro.add(carCor);
        infoCarro.add(carMarca);
        infoCarro.add(carModelo);
        infoCarro.add(carPlaca);
        infoCarro.add(estacionarCarro);
        infoMoto.add(motoMarca);
        infoMoto.add(motoCilindradas);
        infoMoto.add(motoPlaca);
        infoMoto.add(estacionarMoto);
        infoCaminhao.add(caminhaoCarga);
        infoCaminhao.add(caminhaoComprimento);
        infoCaminhao.add(caminhaoPlaca);
        infoCaminhao.add(estacionarCaminhao);
        buttons.add(retornarPrincipal);
        buttons.add(estacionarCadastrado);
        this.add(infoCarro);
        this.add(infoMoto);
        this.add(infoCaminhao);
        this.add(buttons);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == retornarPrincipal) {
            this.dispose();
            GUI gui = new GUI();
        }
        if (e.getSource() == estacionarCarro) {
            Carro novo = new Carro(carModelo.getText(), carCor.getText(), carMarca.getText(), carPlaca.getText());
            Vaga vaga = Vaga.proximaVagaLivreParaCarro(Vaga.estacionamento);
            if (vaga != null){
                vaga.setStatus(1); // vaga ocupada
                novo.setLocal(vaga); // carro "ocupa" a vaga
                veiculosNaoCadastradosEstacionados.add(novo);

                this.dispose();
                GUI gui = new GUI();
            } else {
                mensagem.setText("Nenhuma vaga livre");
                infoCarro.add(mensagem);
                infoCarro.setVisible(false);
                infoCarro.setVisible(true);
            }

        }
        if (e.getSource() == estacionarMoto) {
            try {
                Moto novo = new Moto(motoMarca.getText(), parseInt(motoCilindradas.getText()), motoPlaca.getText());
                Vaga vaga = Vaga.proximaVagaLivreParaMoto(Vaga.estacionamento);
                if (vaga != null) {
                    vaga.setStatus(1); // vaga ocupada
                    novo.setLocal(vaga); // moto "ocupa" a vaga
                    veiculosNaoCadastradosEstacionados.add(novo);

                    this.dispose();
                    GUI gui = new GUI();
                } else {
                    mensagem.setText("Nenhuma vaga livre");
                    infoMoto.add(mensagem);
                    infoMoto.setVisible(false);
                    infoMoto.setVisible(true);
                }
            } catch (NumberFormatException o) {
                mensagem.setText("Texto Invalido");
                infoMoto.add(mensagem);
                infoMoto.setVisible(false);
                infoMoto.setVisible(true);
            }

        }
        if (e.getSource() == estacionarCaminhao) {
            try {
                Caminhao novo = new Caminhao(parseInt(caminhaoCarga.getText()), parseInt(caminhaoComprimento.getText()), caminhaoPlaca.getText());

                Vaga vaga = Vaga.proximaVagaLivreParaCaminhao(Vaga.estacionamento);
                if (vaga != null){
                    vaga.setStatus(1); // vaga ocupada
                    novo.setLocal(vaga); // caminhao "ocupa" a vaga
                    veiculosNaoCadastradosEstacionados.add(novo);

                    this.dispose();
                    GUI gui = new GUI();
                } else {
                    mensagem.setText("Nenhuma vaga livre");
                    infoCaminhao.add(mensagem);
                    infoCaminhao.setVisible(false);
                    infoCaminhao.setVisible(true);
                }
            } catch (NumberFormatException o) {
                mensagem.setText("Texto Invalido");
                infoCaminhao.add(mensagem);
                infoCaminhao.setVisible(false);
                infoCaminhao.setVisible(true);
            }
        }

        if (e.getSource() == estacionarCadastrado) {
            emailCliente = new JTextField();
            emailCliente.setText("Email do proprietario");
            emailCliente.setPreferredSize(new Dimension(100, 30));

            veiculoCliente = new JTextField();
            veiculoCliente.setText("Placa do veiculo");
            veiculoCliente.setPreferredSize(new Dimension(100, 30));

            estacionarCliente = new JButton("Procurar e estacionar");
            estacionarCliente.addActionListener(this);

            this.remove(infoCarro);
            this.remove(infoMoto);
            this.remove(infoCaminhao);
            this.remove(buttons);
            this.add(emailCliente);
            this.add(veiculoCliente);
            this.add(estacionarCliente);
            this.add(retornarPrincipal);
            this.setVisible(false);
            this.setVisible(true);
        }
        if (e.getSource() == estacionarCliente) {
            Veiculo cadastrado;
            String email = emailCliente.getText();
            String placa = veiculoCliente.getText();
            int i;
            Vaga vaga = null;
            boolean status = false;

            for (Cliente cliente : GUI_CadastrarCliente.clientes){
                if (email.equals(cliente.getEmail())){// proprietario encontrado
                    for (i = 0; i < cliente.numVeiculos(); i++){ //busca pelo veiculo
                        if (placa.equals(cliente.getVeiculo(i).getPlaca())){
                            cadastrado = cliente.getVeiculo(i); // veiculo encontrado
                            if (cadastrado instanceof Carro){
                                vaga = Vaga.proximaVagaLivreParaCarro(Vaga.estacionamento);
                            }
                            else if (cadastrado instanceof Moto){
                                vaga = Vaga.proximaVagaLivreParaMoto(Vaga.estacionamento);
                            }
                            else if (cadastrado instanceof Caminhao){
                                vaga = Vaga.proximaVagaLivreParaCaminhao(Vaga.estacionamento);
                            }
                            if (vaga != null){
                                vaga.setStatus(1);
                                cadastrado.setLocal(vaga);
                                veiculosCadastradosEstacionados.add(cadastrado);

                                status = true;
                                this.dispose();
                                GUI gui = new GUI();
                            }
                        }
                    }
                }
            }
            if (!status){
                mensagem.setText("Nao encontrado! Revise o email e placa");
                this.add(mensagem);
                this.setVisible(false);
                this.setVisible(true);
            }
        }
    }
}
