package banksystem;


import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SignUp2 extends JFrame implements ActionListener  {

    JLabel text, religion, category, income, education,
            Occupation, sinNo, idNo, senior, account;
    JTextField sin, id;
    JRadioButton yes1, no1, eyes, eno;
    JButton nextButton;
    JComboBox reli,cat, inc, qual, occ;
    String formNumber;

    SignUp2(String formNumber) {
        this.formNumber = formNumber;
        setLayout(null);

        text = new JLabel("Page 2: Additional Details");
        text.setFont(new Font("Osward", Font.BOLD, 30));
        text.setBounds(150, 30, 900, 45);
        add(text);

        religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(80, 100, 200, 25);
        add(religion);

        String val[]= {"Hindu", "Muslim", "Christian","Other"};
        reli= new JComboBox(val);
        reli.setBounds(270,100,300,30);
        add(reli);

        category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(80, 150, 200, 25);
        add(category);

        String val1[]= {"General", "Scheduled Caste", "OBC","Other"};
        cat= new JComboBox(val1);
        cat.setBounds(270,150,300,30);
        add(cat);

        income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(80, 200, 200, 25);
        add(income);

        String val2[]= {"Null", "< 150,000", "< 250,000","< 500,000"};
        inc= new JComboBox(val2);
        inc.setBounds(270,200,300,30);
        add(inc);

        education = new JLabel("Education:");
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        education.setBounds(80, 250, 200, 25);
        add(education);

        String val3[]= {"Undergraduate", "Graduate", "Post Graduate","High School Diploma","Certificate"};
        qual= new JComboBox(val3);
        qual.setBounds(270,250,300,30);
        add(qual);

        Occupation = new JLabel("Occupation:");
        Occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        Occupation.setBounds(80, 300, 200, 25);
        add(Occupation);

        String val4[]= {"Permanent Part-time", "Self-Employed", "Permanent Full-time","Temporary Full-time","Temporary Part-time"};
        occ= new JComboBox(val4);
        occ.setBounds(270,300,300,30);
        add(occ);

        sinNo = new JLabel("SIN No:");
        sinNo.setFont(new Font("Raleway", Font.BOLD, 20));
        sinNo.setBounds(80, 350, 200, 25);
        add(sinNo);

        sin= new JTextField();
        sin.setFont(new Font("Raleway", Font.BOLD, 20));
        sin.setBounds(270,350,300,30);
        add(sin);

        idNo = new JLabel("ID No:");
        idNo.setFont(new Font("Raleway", Font.BOLD, 20));
        idNo.setBounds(80, 400, 200, 25);
        add(idNo);

        id= new JTextField();
        id.setFont(new Font("Raleway", Font.BOLD, 20));
        id.setBounds(270,400,300,30);
        add(id);

        senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway", Font.BOLD, 20));
        senior.setBounds(80, 450, 200, 25);
        add(senior);

        yes1= new JRadioButton("Yes");
        yes1.setBounds(270,450,100,30);
        add(yes1);

        no1= new JRadioButton("No");
        no1.setBounds(400,450,100,30);
        add(no1);
//
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(yes1);
        genderGroup.add(no1);


        account = new JLabel("Existing A/C:");
        account.setFont(new Font("Raleway", Font.BOLD, 20));
        account.setBounds(80, 500, 200, 25);
        add(account);

        eyes= new JRadioButton("Yes");
        eyes.setBounds(270,500,100,30);
        add(eyes);

        eno= new JRadioButton("No");
        eno.setBounds(400,500,100,30);
        add(eno);

        ButtonGroup genderGroup1 = new ButtonGroup();
        genderGroup1.add(eyes);
        genderGroup1.add(eno);

        nextButton= new JButton("Next");
        nextButton.setBounds(450,600,150,35);
        nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.WHITE);
        nextButton.setOpaque(true);
        nextButton.setBorderPainted(false);
        nextButton.addActionListener(this);
        add(nextButton);


        setSize(700,800);
        setVisible(true);
        setLocation(350,200);
        getContentPane().setBackground(Color.WHITE);

    }
    public static void main(String[] args) {
        new SignUp2("").setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String rel= (String)reli.getSelectedItem();
        String cat1= (String)cat.getSelectedItem();
        String salary= (String)inc.getSelectedItem();
        String qual1= (String)qual.getSelectedItem();
        String occ1= (String)occ.getSelectedItem();
        String seniorCitizen= null;
        String SinNo= sin.getText();
        String IdNo= id.getText();

        if(yes1.isSelected()){
            seniorCitizen= "Yes";
        }
        else if(no1.isSelected()) {
            seniorCitizen = "No";
        }
        String account1= null;

        if(eyes.isSelected()){
            account1= "Yes";
        }
        else if(eno.isSelected()){
            account1= "No";
        }

        try{

            Connect conn= new Connect();
            String query1= "insert into signupTwo values( '" +formNumber+"', '"+rel+"','"+cat1+"','"+salary+"','"+qual1+"','"+occ1+"','"+SinNo+"','"+IdNo+"','"+seniorCitizen+"','"+account1+"')";
            conn.s.executeUpdate(query1);

            new SignUp3(formNumber).setVisible(true);
            setVisible(false);

        } catch (Exception n){
            n.printStackTrace();
        }
    }
}



