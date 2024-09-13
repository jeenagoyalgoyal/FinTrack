package banksystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class miniStatement extends JFrame implements ActionListener {

    String pinNumber;
    JLabel text,bank,mini,card;

    miniStatement(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);
        setTitle("E-Statement");

        mini = new JLabel();
        mini.setBounds(20,140,600,200);
        mini.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(mini);

        bank = new JLabel("ScotiaBank");
        bank.setBounds(150,20,100,20);
        bank.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(bank);

        card = new JLabel();
        card.setBounds(20,80,500,20);
        card.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(card);

        text = new JLabel();
        text.setBounds(20,400,300,20);
        text.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(text);

        try{
            Connect con = new Connect();
            ResultSet rs=con.s.executeQuery("select * from login where pinNo = '"+pinNumber+"'");
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("cardNo").substring(0,4) + "XXXXXXXX" + rs.getString("cardNo").substring(12,16));
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            Connect con = new Connect();
            int bal=0;
            ResultSet resultSet= con.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
            while(resultSet.next()){
                mini.setText(mini.getText()+"<html>"+resultSet.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+"<br><br><html>");
                if(resultSet.getString("type").equals("Deposit")){
                    bal+=Integer.parseInt(resultSet.getString("amount"));
                }
                else {
                    bal -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
            text.setText("Your Current Balance is $ "+bal);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        setSize(600, 800);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
//        setUndecorated(true);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String[] args) {
        new miniStatement("").setVisible(true);
    }
}

