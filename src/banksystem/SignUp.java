package banksystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import com.toedter.calendar.JDateChooser;

public class SignUp extends JFrame implements ActionListener {

    JDateChooser dateChooser;
    JButton loginButton;
    JRadioButton male, female, married, Single, other;
    JTextField nameText, fnameText,mailText,addressText, cityText,proText,zipText;


    Random random=new Random();
    long rand= Math.abs(random.nextLong()%9000L)+1000L;
    String form= ""+rand;

    SignUp(){

        setLayout(null);

        JLabel form= new JLabel("Application form no:" +rand);
        form.setFont(new Font("Raleway", Font.BOLD, 30));
        form.setBounds(150,20,600,30);
        add(form);

        JLabel personal= new JLabel("Page 1: Personal Information");
        personal.setFont(new Font("Raleway", Font.BOLD, 20));
        personal.setBounds(200,80,600,30);
        add(personal);

        JLabel name= new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,100,30);
        add(name);

        nameText= new JTextField();
        nameText.setFont(new Font("Raleway", Font.BOLD, 20));
        nameText.setBounds(300,140,300,30);
        add(nameText);

        JLabel fname= new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100,190,200,30);
        add(fname);

        fnameText= new JTextField();
        fnameText.setFont(new Font("Raleway", Font.BOLD, 20));
        fnameText.setBounds(300,190,300,30);
        add(fnameText);

        JLabel dob= new JLabel("DOB:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,240,100,30);
        add(dob);

        dateChooser= new JDateChooser();
        dateChooser.setBounds(300,240,300,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);


        JLabel gender= new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,290,100,30);
        add(gender);

        male= new JRadioButton("Male");
        male.setBounds(300,290,100,30);
        add(male);

        female= new JRadioButton("Female");
        female.setBounds(400,290,100,30);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email= new JLabel("E-mail:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,340,100,30);
        add(email);

        mailText= new JTextField();
        mailText.setFont(new Font("Raleway", Font.BOLD, 20));
        mailText.setBounds(300,340,300,30);
        add(mailText);

        JLabel marital= new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100,390,150,30);
        add(marital);

        married= new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        add(married);

        Single= new JRadioButton("Unmarried");
        Single.setBounds(400,390,100,30);
        add(Single);

        other= new JRadioButton("Other");
        other.setBounds(500,390,100,30);
        add(other);

        ButtonGroup group = new ButtonGroup();
        group.add(married);
        group.add(Single);
        group.add(other);

        JLabel address= new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100,440,100,30);
        add(address);

        addressText= new JTextField();
        addressText.setFont(new Font("Raleway", Font.BOLD, 20));
        addressText.setBounds(300,440,300,30);
        add(addressText);

        JLabel city= new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,490,100,30);
        add(city);

        cityText= new JTextField();
        cityText.setFont(new Font("Raleway", Font.BOLD, 20));
        cityText.setBounds(300,490,300,30);
        add(cityText);

        JLabel pro= new JLabel("Province:");
        pro.setFont(new Font("Raleway", Font.BOLD, 20));
        pro.setBounds(100,540,100,30);
        add(pro);

        proText= new JTextField();
        proText.setFont(new Font("Raleway", Font.BOLD, 20));
        proText.setBounds(300,540,300,30);
        add(proText);

        JLabel code= new JLabel("ZIP Code:");
        code.setFont(new Font("Raleway", Font.BOLD, 20));
        code.setBounds(100,590,100,30);
        add(code);

        zipText= new JTextField();
        zipText.setFont(new Font("Raleway", Font.BOLD, 20));
        zipText.setBounds(300,590,300,30);
        add(zipText);

        loginButton= new JButton("Next");
        loginButton.setBounds(450,640,150,35);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        loginButton.setOpaque(true);
        loginButton.setBorderPainted(false);
        loginButton.addActionListener(this);
        add(loginButton);

        setSize(700,800);
        setVisible(true);
        setLocation(350,200);
        getContentPane().setBackground(Color.WHITE);



    }




    public static void main(String[] args) {
        new SignUp();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formNo= form;
        String name= nameText.getText();
        String fname= fnameText.getText();
        Date dob= dateChooser.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String selected= sdf.format(dob);
        String gender= null;

        if(male.isSelected()){
            gender= "Male";
        }
        else if(female.isSelected()){
            gender= "Female";
        }
        String email= mailText.getText();
        String marital= null;
        if(married.isSelected()){
            marital= "Married";
        }
        else if(Single.isSelected()){
            marital= "Unmarried";
        }
        else if(other.isSelected()){
            marital= "Other";
        }
        String address= addressText.getText();
        String city= cityText.getText();
        String pro= proText.getText();
        String zip= zipText.getText();

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter your name");
            }
            else{
                Connect conn= new Connect();
                String query= "insert into signup values( '" +formNo+"', '"+name+"','"+fname+"','"+selected+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pro+"','"+zip+"')";
                conn.s.executeUpdate(query);
                setVisible(false);
                new SignUp2(formNo).setVisible(true);
            }
        } catch (Exception m){
            System.out.println(m);
        }
    }
}
