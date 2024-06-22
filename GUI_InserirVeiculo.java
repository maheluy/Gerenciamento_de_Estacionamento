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

    private JPanel addCarro;
    private JTextField carCor;
    private JTextField carModelo;
    private JTextField carMarca;
    private JTextField carPlaca;
    private JButton estacionarCarro;

    private JPanel addMoto;
    private JTextField motoMarca;
    private JTextField motoCilindradas;
    private JTextField motoPlaca;
    private JButton estacionarMoto;

    private JPanel addCaminhao;
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

        addCarro = new JPanel();
        addCarro.setBackground(new Color(100,100,200));

        addMoto = new JPanel();
        addMoto.setBackground(new Color(100,70,200));

        addCaminhao = new JPanel();
        addCaminhao.setBackground(new Color(100,0,200));

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

        addCarro.add(carCor);
        addCarro.add(carMarca);
        addCarro.add(carModelo);
        addCarro.add(carPlaca);
        addCarro.add(estacionarCarro);
        addMoto.add(motoMarca);
        addMoto.add(motoCilindradas);
        addMoto.add(motoPlaca);
        addMoto.add(estacionarMoto);
        addCaminhao.add(caminhaoCarga);
        addCaminhao.add(caminhaoComprimento);
        addCaminhao.add(caminhaoPlaca);
        addCaminhao.add(estacionarCaminhao);
        buttons.add(retornarPrincipal);
        buttons.add(estacionarCadastrado);
        this.add(addCarro);
        this.add(addMoto);
        this.add(addCaminhao);
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
                addCarro.add(mensagem);
                addCarro.setVisible(false);
                addCarro.setVisible(true);
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

        if (e.getSource() == estacionarCadastrado) {
            emailCliente = new JTextField();
            emailCliente.setText("Nome do proprietario");
            emailCliente.setPreferredSize(new Dimension(100, 30));

            veiculoCliente = new JTextField();
            veiculoCliente.setText("Placa do veiculo");
            veiculoCliente.setPreferredSize(new Dimension(100, 30));

            estacionarCliente = new JButton("Procurar e estacionar");
            estacionarCliente.addActionListener(this);

            this.remove(addCarro);
            this.remove(addMoto);
            this.remove(addCaminhao);
            this.remove(buttons);
            this.add(emailCliente);
            this.add(veiculoCliente);
            this.add(estacionarCliente);
            this.add(retornarPrincipal);
            this.setVisible(false);
            this.setVisible(true);
        }
        if (e.getSource() == estacionarCliente) {
            Cliente proprietario;
            Veiculo cadastrado;
            String email = emailCliente.getText();
            String placa = veiculoCliente.getText();
            boolean status = false;
            int i;
            Vaga vaga = null;

            for (i = 0; i < GUI_CadastrarCliente.clientes.size() && !status; i++){
                if (email.equals(GUI_CadastrarCliente.clientes.get(i).getEmail())){
                    proprietario = GUI_CadastrarCliente.clientes.get(i);// proprietario encontrado
                    for (i = 0; i < proprietario.numVeiculos() && !status; i++){ //busca pelo veiculo
                        if (placa.equals(proprietario.getVeiculo(i).getPlaca())){
                            status = true;
                            cadastrado = proprietario.getVeiculo(i); // veiculo encontrado
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

                                this.dispose();
                                GUI gui = new GUI();
                            }
                        }
                    }
                }
            }
            mensagem.setText("Nao encontrado! Revise o email e placa");
            this.add(mensagem);
            this.setVisible(false);
            this.setVisible(true);
        }
    }
}
