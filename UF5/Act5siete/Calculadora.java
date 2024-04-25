package M3.UF5.Act5siete;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame {

    private JTextField display; //recuadro resultado
    private double num1;
    private double num2;
    private char signo;

    public Calculadora() {
        super("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel main = new JPanel(new BorderLayout());
        JPanel boton = new JPanel(new GridLayout(4, 4));
        JPanel botonIgual = new JPanel(new GridLayout(1, 1));
        
        display = new JTextField();
        display.setEditable(false); //para que no sea editable el recuadro del resultado
        display.setHorizontalAlignment(JTextField.RIGHT);

        main.add(display, BorderLayout.NORTH);
        main.add(boton, BorderLayout.CENTER);
        main.add(botonIgual, BorderLayout.SOUTH);

        addBoton(boton, "1");
        addBoton(boton, "2");
        addBoton(boton, "3");
        addBoton(boton, "+");

        addBoton(boton, "4");
        addBoton(boton, "5");
        addBoton(boton, "6");
        addBoton(boton, "-");

        addBoton(boton, "7");
        addBoton(boton, "8");
        addBoton(boton, "9");
        addBoton(boton, "*");

        addBoton(boton, "C");
        addBoton(boton, "0");
        addBoton(boton, ",");
        addBoton(boton, "/");

        addBoton(botonIgual, "=");
        

        add(main);
        setVisible(true);
    }

    private void addBoton(Container container, String text) {
        JButton button = new JButton(text);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String botonTxt = event.getActionCommand();
                if (botonTxt.equals("C")) {
                    clear();
                } else if (botonTxt.equals("=")) {
                    calcular();
                } else if (botonTxt.equals("+") || botonTxt.equals("-") || botonTxt.equals("*") || botonTxt.equals("/")) {
                    signo = botonTxt.charAt(0);
                    num1 = Double.parseDouble(display.getText());
                    display.setText("");
                } else {
                    display.setText(display.getText() + botonTxt);
                }
            }
        });
        container.add(button);
    }

    private void clear() {
        display.setText("");
    }

    private void calcular() {
        num2 = Double.parseDouble(display.getText());
        double result = 0;
        switch (signo) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    display.setText("Error");
                    return;
                }
                break;
        }
        display.setText(Double.toString(result));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Calculadora();
            }
        });
    }
}
