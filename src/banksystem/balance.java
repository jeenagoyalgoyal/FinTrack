package banksystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class balance extends JFrame implements ActionListener {

    String pinChange;
    JButton back;
    int balance = 0;
    JLabel l1;


    balance(String pinChange){
        this.pinChange = pinChange;
        setLayout(null);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons1/atm.jpg"));
        Image image = icon.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon icon1 = new ImageIcon(image);
        JLabel label = new JLabel(icon1);
        label.setBounds(0,0,900,900);
        add(label);

        back= new JButton("Back");
        back.setBounds(390,500,100,20);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.setOpaque(true);
        back.addActionListener(this);
        label.add(back);

        Connect con = new Connect();
        try {
            ResultSet rs = con.s.executeQuery("select * from bank where pin='" + pinChange + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch (Exception mx){
            System.out.println(mx);
        }

        l1= new JLabel("Your Current Balance is: $"+balance);
        l1.setForeground(Color.WHITE);
        l1.setBounds(170,300,400,30);
        label.add(l1);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new transactions(pinChange).setVisible(true);


    }

    public static void main(String[] args) {
        new balance("").setVisible(true);
    }
}

