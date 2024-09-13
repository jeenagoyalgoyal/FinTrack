package banksystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import static java.awt.AWTEventMulticaster.add;


public class SignUp3 extends JFrame implements ActionListener {
    JLabel text1, heading, h2,extra,h3,h4,e1;
    String formPass;
    JRadioButton s,c,f,r;
    JTextField card,pin;
    JCheckBox atm, internet, mobile, email, cheque, statement,agree;
    JButton submit,cancel;


    SignUp3(String formPass){
        this.formPass = formPass;
        setLayout(null);


        text1 = new JLabel("Page 3: Account Details");
        text1.setFont(new Font("Osward", Font.BOLD, 35));
        text1.setBounds(150, 30, 900, 45);
        add(text1);

        heading= new JLabel("Account Type:");
        heading.setFont(new Font("Osward", Font.BOLD, 25));
        heading.setBounds(50, 120, 900, 40);
        add(heading);


        s= new JRadioButton("Saving Account");
        s.setBounds(100, 170, 300, 30);
        add(s);

        f= new JRadioButton("Fixed Deposit Account");
        f.setBounds(400, 170, 600, 30);
        add(f);

        c= new JRadioButton("Current Account");
        c.setBounds(100, 220, 300, 30);
        add(c);

        r= new JRadioButton("Recurring Deposit Account");
        r.setBounds(400, 220, 600, 30);
        add(r);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(s);
        genderGroup.add(f);
        genderGroup.add(c);
        genderGroup.add(r);

        h2= new JLabel("Card Number:");
        h2.setFont(new Font("Osward", Font.BOLD, 25));
        h2.setBounds(50, 270, 200, 35);
        add(h2);

        extra= new JLabel("(Your 16 Digit Card Number)");
        extra.setFont(new Font("Osward", Font.BOLD, 10));
        extra.setBounds(55, 300, 600, 30);
        add(extra);

        card= new JTextField();
        card.setFont(new Font("Osward", Font.BOLD, 25));
        card.setBounds(300, 275, 300, 30);
        add(card);


        h3= new JLabel("PIN:");
        h3.setFont(new Font("Osward", Font.BOLD, 25));
        h3.setBounds(50, 350, 500, 30);
        add(h3);

        e1= new JLabel("(Your 4 Digit Password)");
        e1.setFont(new Font("Osward", Font.BOLD, 10));
        e1.setBounds(55, 365, 200, 40);
        add(e1);

        pin= new JTextField();
        pin.setFont(new Font("Osward", Font.BOLD, 25));
        pin.setBounds(300, 350, 300, 30);
        add(pin);



        h4= new JLabel("Services Required:");
        h4.setFont(new Font("Osward", Font.BOLD, 25));
        h4.setBounds(50, 410, 500, 40);
        add(h4);

        atm= new JCheckBox("ATM Card");
        atm.setFont(new Font("Osward", Font.BOLD, 20));
        atm.setBounds(70, 460, 200, 30);
        add(atm);

        internet= new JCheckBox("Internet Banking");
        internet.setFont(new Font("Osward", Font.BOLD, 20));
        internet.setBounds(300, 460, 400, 30);
        add(internet);

        mobile= new JCheckBox("Mobile Banking");
        mobile.setFont(new Font("Osward", Font.BOLD, 20));
        mobile.setBounds(70, 500, 200, 30);
        add(mobile);

        email= new JCheckBox("E-mail & SMS Alerts");
        email.setFont(new Font("Osward", Font.BOLD, 20));
        email.setBounds(300, 500, 400, 30);
        add(email);

        cheque= new JCheckBox("Cheque");
        cheque.setFont(new Font("Osward", Font.BOLD, 20));
        cheque.setBounds(70, 550, 200, 30);
        add(cheque);

        statement= new JCheckBox("E-Statement");
        statement.setFont(new Font("Osward", Font.BOLD, 20));
        statement.setBounds(300, 550, 200, 30);
        add(statement);

        agree= new JCheckBox("I hereby declare that the above details entered are correct");
        agree.setFont(new Font("Osward", Font.BOLD, 15));
        agree.setBounds(70, 600, 800, 30);
        add(agree);

        submit= new JButton("Submit");
        submit.setBounds(70,650,200,35);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setOpaque(true);
        submit.setBorderPainted(false);
        submit.addActionListener(this);
        add(submit);

        cancel= new JButton("Cancel");
        cancel.setBounds(400,650,200,35);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setOpaque(true);
        cancel.setBorderPainted(false);
        cancel.addActionListener(this);
        add(cancel);


        setSize(700,800);
        setVisible(true);
        setLocation(350,200);
        getContentPane().setBackground(Color.WHITE);

    }
    public static void main(String[] args) {
        new SignUp3("").setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String formNext=formPass;
        if(e.getSource()== submit){
            String account=null;
            if(s.isSelected()){
                account= "Saving Account";
            }
            else if(f.isSelected()){
                account= "Fixed Deposit Account";
            }
            else if(c.isSelected()){
                account= "Current Account";
            }
            else if(r.isSelected()){
                account= "Recurring Deposit Account";
            }

            Random random=new Random();
//            String cardNo=""+Math.abs((random.nextLong()*90000000L)+ 5040936000000000L);
//            String pinNo=""+Math.abs((random.nextLong()*9000L)+ 1000L);

            String cardNo=card.getText();
            String pinNo=pin.getText();
            String fac="";
            if(atm.isSelected()){
                fac= fac+"ATM Card";
            }
            else if(internet.isSelected()){
                fac= fac+"Internet Banking";
            }
            else if(mobile.isSelected()){
                fac= fac+"Mobile Banking";
            }
            else if(email.isSelected()){
                fac= fac+"E-mail & SMS Alerts";
            }
            else if(cheque.isSelected()){
                fac= fac+"Cheque";
            }
            else if(statement.isSelected()){
                fac= fac+"Statement Account";
            }

            try{
                if(account.equals("")){
                    JOptionPane.showMessageDialog(null, "Please select account type");
                }
                else{
                    Connect c= new Connect();
                    String q= "insert into Signup3 values('"+formNext+"','"+account+"','"+cardNo+"','"+pinNo+"','"+fac+"')";
                    String q2= "insert into login values('"+formNext+"','"+cardNo+"','"+pinNo+"')";

                    c.s.executeUpdate(q);
                    c.s.executeUpdate(q2);

                    JOptionPane.showMessageDialog(null, "Card Number "+cardNo+" \n Pin: "+pinNo);

                    setVisible(false);
                    new deposit(pinNo).setVisible(false);
                }
            }catch (Exception s){
                System.out.println(s);
            }

        } else if(e.getSource()== cancel){
            setVisible(false);
            new login().setVisible(true);
        }
    }
}
