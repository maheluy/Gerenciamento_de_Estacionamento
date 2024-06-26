import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GUI_Relatorio extends JFrame implements ActionListener {
    private JTextArea lista;
    private String linha;
    private Scanner input;
    private File relatorio;

    private JButton retornarPrincipal;

    public GUI_Relatorio(){
        this.setTitle("Gerenciador de Estacionamento - Relatorio");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(new Color(100,50,200));

        retornarPrincipal = new JButton("<< Voltar");
        retornarPrincipal.addActionListener(this);
        try {
            relatorio = new File("C:\\Users\\User\\IdeaProjects\\Gerenciador-Estacionamento\\src\\Relatorio.txt");
            input = new Scanner(relatorio).useDelimiter("\n");
        } catch (FileNotFoundException e){
            new RuntimeException(e);
        }

        lista = new JTextArea();
        while(input.hasNext()){
            linha = input.next();
            lista.append(linha + "\n");
        }


        this.add(lista, BorderLayout.CENTER);
        this.add(retornarPrincipal, BorderLayout.SOUTH);
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