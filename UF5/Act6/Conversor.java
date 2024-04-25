package M3.UF5.Act6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Conversor extends JFrame {

	private JTextField Quantitat2;
    private JTextField Resultat2;

    private double cambio€a£ = 0.85; 
    private double cambio€a$ = 1.2; 

    public Conversor() {
        super("Conversor de monedes");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel main = new JPanel(new BorderLayout());
        JPanel campos = new JPanel(new GridLayout(2, 2));
        JPanel botones = new JPanel(new FlowLayout());

        JLabel Quantitat = new JLabel("Quantitat:");
        Quantitat2 = new JTextField(10);

        JLabel Resultat = new JLabel("Resultat:");
        Resultat2 = new JTextField(10);
        Resultat2.setEditable(false); //para no editar ese recuadro

        JButton €a£ = new JButton("€ a £");
        €a£.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //euros a lliures
                double euros = Double.parseDouble(Quantitat2.getText());
                double lliures = euros * cambio€a£;
                Resultat2.setText(String.format("%.2f", lliures));
            }
        });

        JButton £a€ = new JButton("£ a €");
        £a€.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //lliures a euros
                double lliures = Double.parseDouble(Quantitat2.getText());
                double euros = lliures / cambio€a£;
                Resultat2.setText(String.format("%.2f", euros));
            }
        });

        JButton €a$ = new JButton("€ a $");
        €a$.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//euros a dolars
                double euros = Double.parseDouble(Quantitat2.getText());
                double dolars = euros * cambio€a$;
                Resultat2.setText(String.format("%.2f", dolars));
            }
        });

        JButton $a€ = new JButton("$ a €");
        $a€.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//dolars a euros
                double dolars = Double.parseDouble(Quantitat2.getText());
                double euros = dolars / cambio€a$;
                Resultat2.setText(String.format("%.2f", euros));
            }
        });
        
        campos.add(Quantitat);
        campos.add(Quantitat2);
        campos.add(Resultat);
        campos.add(Resultat2);

        botones.add(€a£);
        botones.add(£a€);
        botones.add(€a$);
        botones.add($a€);

        main.add(campos, BorderLayout.CENTER);
        main.add(botones, BorderLayout.SOUTH);

        add(main);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Conversor();
            }
        });
    }
}
