package banksystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.*;

public class login extends JFrame implements ActionListener {

    JButton loginButton, clear, signUp;
    JTextField cardTextField;
    JPasswordField pinTextField;
    JLabel text, card_Number,pin,label;
    login(){
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons1/logo.jpg"));
        Image image = icon.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon icon1 = new ImageIcon(image);
        label = new JLabel(icon1);
        label.setBounds(70,10,100,100);
        add(label);

        text= new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,40));
        text.setBounds(200,40,600,40);
        add(text);

        card_Number= new JLabel("Card No: ");
        card_Number.setFont(new Font("Raleway",Font.BOLD,40));
        card_Number.setBounds(120,150,600,35);
        add(card_Number);

        cardTextField= new JTextField();
        cardTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cardTextField.setBounds(350,150,350,32);
        cardTextField.setFont(new Font("Arial",Font.BOLD,17));
        add(cardTextField);

        pin= new JLabel("PIN: ");
        pin.setFont(new Font("Raleway",Font.BOLD,40));
        pin.setBounds(120,250,600,35);
        add(pin);

        pinTextField= new JPasswordField();
        pinTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        pinTextField.setBounds(350,250,350,32);
        pinTextField.setFont(new Font("Arial",Font.BOLD,17));
        add(pinTextField);

        loginButton= new JButton("Sign In");
        loginButton.setBounds(350,320,150,35);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        loginButton.setOpaque(true);
        loginButton.setBorderPainted(false);
        loginButton.addActionListener(this);
        add(loginButton);

        clear= new JButton("Clear");
        clear.setBounds(550,320,150,35);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setOpaque(true);
        clear.setBorderPainted(false);
        clear.addActionListener(this);
        add(clear);

        signUp= new JButton("Sign Up");
        signUp.setBounds(350,370,350,35);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.setOpaque(true);
        signUp.setBorderPainted(false);
        signUp.addActionListener(this);
        add(signUp);

        getContentPane().setBackground(Color.WHITE);

        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    public static void main(String[] args) {
        new login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==loginButton){
            Connect con = new Connect();
            String cardNo = cardTextField.getText();
            String pinNo = pinTextField.getText();
            String selectQuery= "select * from login where cardNo='"+cardNo+"' and pinNo='"+pinNo+"'";
            try{
                ResultSet rs = con.s.executeQuery(selectQuery);
                if(rs.next()){
                    setVisible(false);
                    new transactions(pinNo).setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Invalid Card Number or PIN");
                }
            }catch (Exception e1){
                System.out.println(e1);
            }
        }
        else if(e.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(e.getSource()==signUp){
            setVisible(false);
            SignUp sign=new SignUp();
            sign.setVisible(true);
        }
    }
}
