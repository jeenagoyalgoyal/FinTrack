package banksystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pinChange extends JFrame implements ActionListener {
    String pinChange;
    JLabel text, text2, text3;
    JTextField amount, amount2,amount3;
    JButton change, back;

    pinChange(String pinChange) {
        this.pinChange = pinChange;
        setLayout(null);
        this.setTitle(pinChange);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons1/atm.jpg"));
        Image i1 = icon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i1);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        text = new JLabel("Enter Your Current PIN");
        text.setBounds(260,300,700,35);
        text.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        text.setForeground(Color.WHITE);
        image.add(text);

        amount= new JTextField();
        amount.setFont(new Font("Osward", Font.BOLD, 25));
        amount.setBounds(170, 330, 330, 30);
        image.add(amount);

        text2 = new JLabel("New PIN");
        text2.setBounds(300,360,700,35);
        text2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        text2.setForeground(Color.WHITE);
        image.add(text2);

        amount2= new JTextField();
        amount2.setFont(new Font("Osward", Font.BOLD, 25));
        amount2.setBounds(170, 390, 330, 30);
        image.add(amount2);

        text3 = new JLabel("Re-enter New PIN");
        text3.setBounds(260,420,700,35);
        text3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        text3.setForeground(Color.WHITE);
        image.add(text3);

        amount3= new JTextField();
        amount3.setFont(new Font("Osward", Font.BOLD, 25));
        amount3.setBounds(170, 450, 330, 30);
        image.add(amount3);

        change= new JButton("Change");
        change.setBounds(180,500,100,20);
        change.setBackground(Color.WHITE);
        change.setForeground(Color.BLACK);
        change.setOpaque(true);
        change.addActionListener(this);
        image.add(change);

        back= new JButton("Back");
        back.setBounds(390,500,100,20);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.setOpaque(true);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300,0);
        setVisible(true);
    }




    public static void main(String[] args) {
        new pinChange("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == change) {
            try{
                String npin = amount2.getText();
                String rpin = amount3.getText();
                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"PIN does not match");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"PIN is empty");
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Re-enter New PIN");
                }
                Connect con = new Connect();
                //look into bank query bcz pin does not change
                String q1= "update bank  set pin= '"+rpin+"' where pin= '"+pinChange+"'";
                String q2= "update login  set pinNo= '"+rpin+"' where pinNo= '"+pinChange+"'";
                String q3= "update SignUp3  set pin= '"+rpin+"' where pin= '"+pinChange+"'";
                con.s.executeUpdate(q1);
                con.s.executeUpdate(q2);
                con.s.executeUpdate(q3);

                JOptionPane.showMessageDialog(null,"PIN Changed Successfully");
                setVisible(false);
                new transactions(rpin).setVisible(true);

            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        else {
            setVisible(false);
            new transactions(pinChange).setVisible(true);
        }
    }
}

