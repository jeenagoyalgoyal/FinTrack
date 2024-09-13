package banksystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.*;

public class deposit extends JFrame implements ActionListener {

    JLabel text;
    JTextField amount;
    JButton deposit1, back;
    String pin;
    deposit(String pin){
        this.pin = pin;
        setTitle("Deposit");
        setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons1/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        text=new JLabel("Enter the amount to deposit");
        text.setBounds(220,300,700,35);
        text.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        text.setForeground(Color.WHITE);
        image.add(text);

        amount= new JTextField();
        amount.setFont(new Font("Osward", Font.BOLD, 25));
        amount.setBounds(170, 350, 330, 30);
        image.add(amount);

        deposit1=new JButton("Deposit");
        deposit1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        deposit1.setForeground(Color.BLACK);
        deposit1.setBackground(Color.WHITE);
        deposit1.setBounds(170, 400, 150, 30);
        deposit1.addActionListener(this);
        image.add(deposit1);

        back=new JButton("Back");
        back.setFont(new Font("Times New Roman", Font.BOLD, 15));
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
        back.setBounds(350, 400, 150, 30);
        back.addActionListener(this);
        image.add(back);


        setSize(900,900);
        setLocation(350,0);
//        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new deposit("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==deposit1){
            String no=amount.getText();
            Date date=new Date();

            if(no.equals("")){
                JOptionPane.showMessageDialog(null,"Enter amount to deposit");
            }else {
                try{
                    Connect con=new Connect();
                    String q= "insert into bank values('"+pin+"','"+date+"','Deposit','"+no+"')";
                    con.s.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"Deposit successful");
                    setVisible(false);
                    new transactions(pin).setVisible(true);
                }catch (Exception e2){
                    System.out.println("Error "+e2.getMessage());
                }

            }

        }
        else if(e.getSource()==back){
            setVisible(false);
            new transactions(pin).setVisible(true);
        }
        else if(e.getSource()==deposit1){
            System.exit(0);
        }
    }
}
