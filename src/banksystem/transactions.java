package banksystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class transactions extends JFrame implements ActionListener {
    JLabel label,text;
    JButton deposit, withdraw, interac, statement, pinChange, balance, exit;
    String pin;
    transactions(String pin){
        this.pin = pin;
        setTitle("Transactions");

        setLayout(null);
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons1/atm.jpg"));
        Image image = icon.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon icon1 = new ImageIcon(image);
        label = new JLabel(icon1);
        label.setBounds(0,0,900,900);
        add(label);

        text = new JLabel("Select your Transaction");
        text.setBounds(235,300,700,35);
        text.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        text.setForeground(Color.WHITE);
        label.add(text);

        deposit= new JButton("Deposit");
        deposit.setBounds(200,370,100,20);
        deposit.setBackground(Color.WHITE);
        deposit.setForeground(Color.BLACK);
        deposit.setOpaque(true);
        deposit.addActionListener(this);
        label.add(deposit);

        withdraw= new JButton("Withdraw");
        withdraw.setBounds(370,370,100,20);
        withdraw.setBackground(Color.WHITE);
        withdraw.setForeground(Color.BLACK);
        withdraw.setOpaque(true);
        withdraw.addActionListener(this);
        label.add(withdraw);

        interac= new JButton("Fast Withdraw");
        interac.setBounds(200,410,100,20);
        interac.setBackground(Color.WHITE);
        interac.setForeground(Color.BLACK);
        interac.setOpaque(true);
        interac.addActionListener(this);
        label.add(interac);

        statement= new JButton("E-Statements");
        statement.setBounds(370,410,100,20);
        statement.setBackground(Color.WHITE);
        statement.setForeground(Color.BLACK);
        statement.setOpaque(true);
        statement.addActionListener(this);
        label.add(statement);

        pinChange= new JButton("PIN Change");
        pinChange.setBounds(200,450,100,20);
        pinChange.setBackground(Color.WHITE);
        pinChange.setForeground(Color.BLACK);
        pinChange.setOpaque(true);
        pinChange.addActionListener(this);
        label.add(pinChange);

        balance= new JButton("Balance Info");
        balance.setBounds(370,450,100,20);
        balance.setBackground(Color.WHITE);
        balance.setForeground(Color.BLACK);
        balance.setOpaque(true);
        balance.addActionListener(this);
        label.add(balance);

        exit= new JButton("Exit");
        exit.setBounds(290,490,100,20);
        exit.setBackground(Color.WHITE);
        exit.setForeground(Color.BLACK);
        exit.setOpaque(true);
        exit.addActionListener(this);
        label.add(exit);

        setSize(900,900);
        setLocation(350,0);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new transactions("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit){
            System.exit(0);
        }
        else if(e.getSource()==deposit){
            setVisible(false);
            new deposit(pin).setVisible(true);
        }
        else if(e.getSource()==withdraw){
            setVisible(false);
            new withdraw(pin).setVisible(true);
        }
        else if(e.getSource()==interac){
            setVisible(false);
            new Interac(pin).setVisible(true);
        }
        else if(e.getSource()==pinChange){
            setVisible(false);
            new pinChange(pin).setVisible(true);
        }
        else if(e.getSource()==balance){
            setVisible(false);
            new balance(pin).setVisible(true);
        }
        else if(e.getSource()== statement){
            new miniStatement(pin).setVisible(true);
        }

    }
}

