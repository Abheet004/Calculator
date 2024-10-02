
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class calculatorUI implements ActionListener {

    double n1=0,n2=0,res=0;
    char opr;
    JButton[] numbutton = new JButton[10];
    JButton[] oprbutton = new JButton[8];
    JButton addb, subb, mulb, divb;
    JButton decb, equb, delb, clrb;
    JTextField textField;
    calculatorUI(){

        JFrame frame = new JFrame("Calculator");
        frame.setSize(400,550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.BLACK);
        Font myFont = new Font("Ink Free", Font.BOLD, 25);

        textField = new JTextField();
        textField.setBounds(25, 25, 340, 60);
        textField.setFont(myFont);
        textField.setEditable(false);
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.WHITE);
        textField.setBorder(null);
        frame.add(textField);

        JPanel panel = new JPanel();
        panel.setBounds(25, 185, 340, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));


        addb = new JButton("+");
        subb = new JButton("-");
        mulb = new JButton("*");
        divb = new JButton("/");
        equb = new JButton("=");
        decb = new JButton(".");
        delb = new JButton("Delete");
        clrb = new JButton("Clear");


        oprbutton[0]=addb;
        oprbutton[1]=subb;
        oprbutton[2]=mulb;
        oprbutton[3]=divb;
        oprbutton[4]=equb;
        oprbutton[5]=decb;
        oprbutton[6]=delb;
        oprbutton[7]=clrb;

        for (int i = 0; i < oprbutton.length; i++) {
            oprbutton[i].setFont(myFont);
            oprbutton[i].addActionListener(this);
            oprbutton[i].setBackground(Color.BLACK);
            oprbutton[i].setForeground(Color.WHITE);
            oprbutton[i].setFocusable(false);
            oprbutton[i].setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        }
        equb.setBackground(new Color(0, 171, 240));

        for (int i = 0; i < numbutton.length; i++) {
            numbutton[i]=new JButton(String.valueOf(i));
            numbutton[i].setFont(myFont);
            numbutton[i].addActionListener(this);
            numbutton[i].setBackground(Color.GRAY);
            numbutton[i].setForeground(Color.WHITE);
            numbutton[i].setFocusable(false);
        }

        panel.add(numbutton[1]);
        panel.add(numbutton[2]);
        panel.add(numbutton[3]);
        panel.add(addb);
        panel.add(numbutton[4]);
        panel.add(numbutton[5]);
        panel.add(numbutton[6]);
        panel.add(subb);
        panel.add(numbutton[7]);
        panel.add(numbutton[8]);
        panel.add(numbutton[9]);
        panel.add(mulb);
        panel.add(decb);
        panel.add(numbutton[0]);
        panel.add(equb);
        panel.add(divb);
        panel.setBackground(Color.BLACK);
        frame.add(panel);

        clrb.setBounds(25, 110, 165, 50);
        delb.setBounds(200, 110, 165, 50);
        clrb.setHorizontalAlignment(SwingConstants.CENTER);
        delb.setHorizontalAlignment(SwingConstants.CENTER);
        clrb.setVerticalAlignment(SwingConstants.CENTER);
        delb.setVerticalAlignment(SwingConstants.CENTER);

        frame.add(clrb);
        frame.add(delb);

        frame.setVisible(true);


    }
    public void actionPerformed(ActionEvent e){
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numbutton[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource()==decb) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource()==addb) {
            n1=Double.parseDouble(textField.getText());
            opr='+';
            textField.setText("");
        }
        if (e.getSource()==mulb) {
            n1=Double.parseDouble(textField.getText());
            opr='*';
            textField.setText("");
        }
        if (e.getSource()==subb) {
            n1=Double.parseDouble(textField.getText());
            opr='-';
            textField.setText("");
        }
        if (e.getSource()==divb) {
            n1=Double.parseDouble(textField.getText());
            opr='/';
            textField.setText("");
        }
        if (e.getSource()==equb) {
            n2=Double.parseDouble(textField.getText());
            switch (opr) {
                case '+':
                    res=n1+n2;
                    break;
            
                case '-':
                    res=n1-n2;
                    break;
            
                case '*':
                    res=n1*n2;
                    break;
            
                case '/':
                    res=n1/n2;
                    break;
            }
            textField.setText(String.valueOf(res));
            n1=Double.parseDouble(textField.getText());
        }
        if (e.getSource() == clrb) {
            textField.setText("");
        }

        if (e.getSource() == delb) {
            String temp = textField.getText();
            textField.setText("");
            for (int i = 0; i < temp.length() - 1; i++) {
                textField.setText(textField.getText() + temp.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        new calculatorUI();
    }
    
}