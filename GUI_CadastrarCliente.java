import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI_CadastrarCliente extends JFrame implements ActionListener {
    public static ArrayList<Cliente> clientes = new ArrayList<Cliente>(); // array estatica para armazenar todos os clientes cadastrados

    private JPanel infoCliente;
    private JTextField nome;
    private JTextField telefone;
    private JTextField email;
    private JButton cadastrar;
    private JButton retornarPrincipal;

    private JPanel buttonsVeiculos;
    private JButton cadastrarVeiculo;
    private JButton removerVeiculo;

    private JPanel infoCarro;
    private JTextField cor;
    private JTextField marcaCarro;
    private JTextField modelo;
    private JButton cadastrarCarro;
    private JPanel infoMoto;
    private JTextField marcaMoto;
    private JTextField cilindradas;
    private JButton cadastrarMoto;
    private JPanel infoCaminhao;
    private JTextField cargaMax;
    private JTextField comprimento;
    private JButton cadastrarCaminhao;

    private JTextField placa;
    private JButton localizarRemover;

    public GUI_CadastrarCliente() {
        this.setTitle("Gerenciador de Estacionamento - Cadastrar Cliente");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLayout(new GridLayout(3, 0, 0, 50));
        this.getContentPane().setBackground(new Color(100,255,200));

        infoCliente = new JPanel();
        infoCliente.setBackground(new Color(100,255,200));

        nome = new JTextField();
        nome.setText("Nome");
        nome.setPreferredSize(new Dimension(100, 30));

        telefone = new JTextField();
        telefone.setText("Telefone");
        telefone.setPreferredSize(new Dimension(100, 30));

        email = new JTextField();
        email.setText("Email");
        email.setPreferredSize(new Dimension(100, 30));

        cadastrar = new JButton("Cadastrar");
        cadastrar.addActionListener(this);

        retornarPrincipal = new JButton("Retornar Principal");
        retornarPrincipal.addActionListener(this);

        buttonsVeiculos = new JPanel();
        buttonsVeiculos.setBackground(new Color(100,255,200));

        cadastrarVeiculo = new JButton("Cadastrar Veiculo");
        cadastrarVeiculo.addActionListener(this);

        removerVeiculo = new JButton("Remover Veiculo");
        removerVeiculo.addActionListener(this);

        infoCliente.add(nome);
        infoCliente.add(telefone);
        infoCliente.add(email);
        infoCliente.add(cadastrar);
        buttonsVeiculos.add(cadastrarVeiculo);
        buttonsVeiculos.add(removerVeiculo);
        this.add(infoCliente);
        this.add(buttonsVeiculos);
        this.add(retornarPrincipal);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == retornarPrincipal) {
            this.dispose();
            GUI gui = new GUI();
        }
        if (e.getSource() == cadastrar) {
            String nometxt = nome.getText();
            String emailtxt = email.getText();
            int teltxt = Integer.parseInt(telefone.getText());

            Cliente novoCliente = new Cliente(nometxt, emailtxt, teltxt);
            clientes.add(novoCliente);

            this.dispose();
            GUI gui = new GUI();
        }
        if (e.getSource() == cadastrarVeiculo) {
            this.remove(buttonsVeiculos);
            this.remove(infoCliente);

            infoCarro = new JPanel();
            infoCarro.setBackground(new Color(100,255,200));
            cor = new JTextField();
            cor.setText("Cor");
            cor.setPreferredSize(new Dimension(100, 30));
            marcaCarro = new JTextField();
            marcaCarro.setText("Marca");
            marcaCarro.setPreferredSize(new Dimension(100, 30));
            modelo = new JTextField();
            modelo.setText("Modelo");
            modelo.setPreferredSize(new Dimension(100, 30));
            cadastrarCarro = new JButton("Cadastrar Carro");
            cadastrarCarro.addActionListener(this);
            infoCarro.add(cor);
            infoCarro.add(marcaCarro);
            infoCarro.add(modelo);
            infoCarro.add(cadastrarCarro);

            infoMoto = new JPanel();
            infoMoto.setBackground(new Color(100,255,200));
            cilindradas = new JTextField();
            cilindradas.setText("Cilindradas");
            cilindradas.setPreferredSize(new Dimension(100, 30));
            marcaMoto = new JTextField();
            marcaMoto.setText("Marca");
            marcaMoto.setPreferredSize(new Dimension(100, 30));
            cadastrarMoto = new JButton("Cadastrar Moto");
            cadastrarMoto.addActionListener(this);
            infoMoto.add(cilindradas);
            infoMoto.add(marcaMoto);
            infoMoto.add(cadastrarMoto);



            infoCaminhao = new JPanel();
            infoCaminhao.setBackground(new Color(100,255,200));
            cargaMax = new JTextField();
            cargaMax.setText("Carga Max");
            cargaMax.setPreferredSize(new Dimension(100, 30));
            comprimento = new JTextField();
            comprimento.setText("Comprimento");
            comprimento.setPreferredSize(new Dimension(100, 30));
            cadastrarCaminhao = new JButton("Cadastrar Caminhao");
            cadastrarCaminhao.addActionListener(this);
            infoCaminhao.add(comprimento);
            infoCaminhao.add(cargaMax);
            infoCaminhao.add(cadastrarCaminhao);

            placa = new JTextField();
            placa.setText("Placa");
            placa.setPreferredSize(new Dimension(100, 30));


            this.setLayout(new GridLayout(6, 0, 0, 50));
            this.add(email);
            this.add(infoCarro);
            this.add(infoMoto);
            this.add(infoCaminhao);
            this.add(placa);
            this.setVisible(false);
            this.setVisible(true);
        }
        if (e.getSource() == removerVeiculo) {
            buttonsVeiculos.remove(cadastrarVeiculo);
            buttonsVeiculos.remove(removerVeiculo);
            this.remove(buttonsVeiculos);
            this.remove(infoCliente);

            placa = new JTextField();
            placa.setText("Placa");
            placa.setPreferredSize(new Dimension(100, 30));

            localizarRemover = new JButton("Localizar e Remover");
            localizarRemover.addActionListener(this);


            buttonsVeiculos.add(placa);
            buttonsVeiculos.add(localizarRemover);
            this.add(email);
            this.add(buttonsVeiculos);
            this.setVisible(false);
            this.setVisible(true);

            //criar funcao de remocao
        }
        if (e.getSource() == cadastrarCarro) {
            String cortxt = cor.getText();
            String marcatxt = marcaCarro.getText();
            String modelotxt = modelo.getText();
            String placatxt = placa.getText();
            String emailtxt = email.getText();
            Carro novoCarro = new Carro(modelotxt, cortxt, marcatxt, placatxt);
            for (Cliente cliente : clientes) {
                if (cliente.getEmail().equals(emailtxt)) {
                    cliente.addVeiculo(novoCarro);
                }
            }
            this.dispose();
            GUI gui = new GUI();
        }
        if (e.getSource() == cadastrarMoto) {
            String marcaMototxt = marcaMoto.getText();
            int cilindradastxt = Integer.parseInt(cilindradas.getText());
            String placatxt = placa.getText();
            String emailtxt = email.getText();
            Moto novoMoto = new Moto(marcaMototxt, cilindradastxt, placatxt);
            for (Cliente cliente : clientes) {
                if (cliente.getEmail().equals(emailtxt)) {
                    cliente.addVeiculo(novoMoto);
                }
            }
            this.dispose();
            GUI gui = new GUI();
        }
        if (e.getSource() == cadastrarCaminhao) {
            int comprimentotxt = Integer.parseInt(comprimento.getText());
            int cargaMaxtxt = Integer.parseInt(cargaMax.getText());
            String placatxt = placa.getText();
            String emailtxt = email.getText();
            Caminhao novoCaminhao = new Caminhao(cargaMaxtxt, comprimentotxt, placatxt);
            for (Cliente cliente : clientes) {
                if (cliente.getEmail().equals(emailtxt)) {
                    cliente.addVeiculo(novoCaminhao);
                }
            }
            this.dispose();
            GUI gui = new GUI();
        }
        if (e.getSource() == localizarRemover) {
            String emailtxt = email.getText();
            String placatxt = placa.getText();
            Veiculo remover;
            for (Cliente cliente : clientes) {
                if (cliente.getEmail().equals(emailtxt)) {
                    for(int i = 0; i < cliente.numVeiculos(); i++){
                        if (cliente.getVeiculo(i).getPlaca().equals(placatxt)) {
                            remover = cliente.getVeiculo(i);
                        }
                    }
                }
            }
            this.dispose();
            GUI gui = new GUI();
        }
    }
}
