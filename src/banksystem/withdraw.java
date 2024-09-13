package banksystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class withdraw extends JFrame implements ActionListener {

    JLabel text;
    JTextField amount;
    JButton withdrawl, back;
    String pin;
    withdraw(String pin){
        this.pin = pin;
        setTitle("Deposit");
        setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons1/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        text=new JLabel("Enter the amount to withdraw");
        text.setBounds(220,300,700,35);
        text.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        text.setForeground(Color.WHITE);
        image.add(text);

        amount= new JTextField();
        amount.setFont(new Font("Osward", Font.BOLD, 25));
        amount.setBounds(170, 350, 330, 30);
        image.add(amount);

        withdrawl=new JButton("Withdraw");
        withdrawl.setFont(new Font("Times New Roman", Font.BOLD, 15));
        withdrawl.setForeground(Color.BLACK);
        withdrawl.setBackground(Color.WHITE);
        withdrawl.setBounds(170, 400, 150, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

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
        new withdraw("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==withdrawl){
            String no=amount.getText();
            Date date=new Date();

            if(no.equals("")){
                JOptionPane.showMessageDialog(null,"Enter amount to withdraw");
            }else {
                try{
                    Connect con=new Connect();
                    String q= "insert into bank values('"+pin+"','"+date+"','Withdrawl','"+no+"')";
                    con.s.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"Withdraw successful");
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
        else if(e.getSource()==withdrawl){
            System.exit(0);
        }
    }
}



