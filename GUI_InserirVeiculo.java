import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_InserirVeiculo extends JFrame implements ActionListener {
    private JButton retornarPrincipal;

    public GUI_InserirVeiculo() {
        this.setTitle("Gerenciador de Estacionamento - Inserir Veiculo");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.getContentPane().setBackground(new Color(100,50,200));
        this.setLayout(null);

        retornarPrincipal = new JButton("<<Voltar");
        retornarPrincipal.setBounds(100, 75, 100, 50);
        retornarPrincipal.addActionListener(this);

        this.add(retornarPrincipal);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == retornarPrincipal) {
            this.dispose();
            GUI gui = new GUI();
        }
    }
}
