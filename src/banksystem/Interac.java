package banksystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.*;

public class Interac extends JFrame implements ActionListener {
    JLabel label,text;
    JButton deposit, withdraw, interac, statement, pinChange, balance, exit;
    String pin;
    Interac(String pin){
        this.pin = pin;
        setTitle("Transactions");

        setLayout(null);
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons1/atm.jpg"));
        Image image = icon.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon icon1 = new ImageIcon(image);
        label = new JLabel(icon1);
        label.setBounds(0,0,900,900);
        add(label);

        text = new JLabel("Select withdrawl amount");
        text.setBounds(235,300,700,35);
        text.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        text.setForeground(Color.WHITE);
        label.add(text);

        deposit= new JButton("$ 100");
        deposit.setBounds(200,370,100,20);
        deposit.setBackground(Color.WHITE);
        deposit.setForeground(Color.BLACK);
        deposit.setOpaque(true);
        deposit.addActionListener(this);
        label.add(deposit);

        withdraw= new JButton("$ 500");
        withdraw.setBounds(370,370,100,20);
        withdraw.setBackground(Color.WHITE);
        withdraw.setForeground(Color.BLACK);
        withdraw.setOpaque(true);
        withdraw.addActionListener(this);
        label.add(withdraw);

        interac= new JButton("$ 1000");
        interac.setBounds(200,410,100,20);
        interac.setBackground(Color.WHITE);
        interac.setForeground(Color.BLACK);
        interac.setOpaque(true);
        interac.addActionListener(this);
        label.add(interac);

        statement= new JButton("$ 2000");
        statement.setBounds(370,410,100,20);
        statement.setBackground(Color.WHITE);
        statement.setForeground(Color.BLACK);
        statement.setOpaque(true);
        statement.addActionListener(this);
        label.add(statement);

        pinChange= new JButton("$ 5000");
        pinChange.setBounds(200,450,100,20);
        pinChange.setBackground(Color.WHITE);
        pinChange.setForeground(Color.BLACK);
        pinChange.setOpaque(true);
        pinChange.addActionListener(this);
        label.add(pinChange);

        balance= new JButton("$ 10000");
        balance.setBounds(370,450,100,20);
        balance.setBackground(Color.WHITE);
        balance.setForeground(Color.BLACK);
        balance.setOpaque(true);
        balance.addActionListener(this);
        label.add(balance);

        exit= new JButton("Back");
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
        new Interac("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit){
            setVisible(false);
            new transactions(pin).setVisible(true);
        }
        else {
            JButton button = (JButton)e.getSource();
            String amt= (button.getText().substring(3));
            Connect con = new Connect();
            try{
                ResultSet rs= con.s.executeQuery("select * from bank where pin='"+pin+"'");
                int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }
                    else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(e.getSource()!=exit && balance<Integer.parseInt(amt)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }

                Date date=new Date(System.currentTimeMillis());
                String q2= "insert into bank values('"+pin+"','"+date+"','Withdrawl','"+amt+"')";
                con.s.executeUpdate(q2);
                JOptionPane.showMessageDialog(null,"Transaction Successful");
                setVisible(false);
                new transactions(pin).setVisible(true);

            }catch (Exception e1){
                System.out.println(e1.getMessage());
            }

        }


    }
}



