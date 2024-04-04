package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField tname,tage,tsalary,tphoneNumber,taadhar,temail;

    JButton back,save;

    JComboBox comboBox,tgender;
    AddEmployee()
    {
        JPanel panel =new JPanel();
        panel.setBounds(5,5,840,490);
        panel.setBackground(new Color(58, 1, 37));
        panel.setLayout(null);
        add(panel);

        JLabel l1=new JLabel("ADD EMPLOYEE DETAILS");
        l1.setBounds(500,30,500,22);
        l1.setFont(new Font("Regular",Font.BOLD,22));
        l1.setForeground(Color.WHITE);
        panel.add(l1);

        JLabel name=new JLabel("NAME");
        name.setBounds(60,30,150,30);
        name.setFont(new Font("Regular",Font.BOLD,16));
        name.setForeground(Color.WHITE);
        panel.add(name);

        tname=new JTextField();
        tname.setBounds(230,30,150,27);
        tname.setBackground(new Color(148, 212, 229));
        tname.setFont(new Font("Regular",Font.BOLD,16));
        tname.setForeground(Color.WHITE);
        panel.add(tname);

        JLabel age=new JLabel("AGE");
        age.setBounds(60,70,150,30);
        age.setFont(new Font("Regular",Font.BOLD,16));
        age.setForeground(Color.WHITE);
        panel.add(age);

        tage=new JTextField();
        tage.setBounds(230,70,150,27);
        tage.setBackground(new Color(148, 212, 229));
        tage.setFont(new Font("Regular",Font.BOLD,16));
        tage.setForeground(Color.WHITE);
        panel.add(tage);


        JLabel gender=new JLabel("GENDER");
        gender.setBounds(60,110,150,30);
        gender.setFont(new Font("Regular",Font.BOLD,16));
        gender.setForeground(Color.WHITE);
        panel.add(gender);



        tgender=new JComboBox<>(new String[]{"Male","Female","Other"});
        tgender.setBounds(230,110,150,27);
        tgender.setFont(new Font("Regular",Font.BOLD,16));
        tgender.setBackground(new Color(148, 212, 229));
        tgender.setForeground(Color.WHITE);
        panel.add(tgender);



        JLabel job=new JLabel("JOB");
        job.setBounds(60,150,150,30);
        job.setFont(new Font("Regular",Font.BOLD,16));
        job.setForeground(Color.WHITE);
        panel.add(job);

        comboBox=new JComboBox<>(new String[]{"Maintenance Staff","Security","Receptionist","HouseKeeper","Food Service","Room Service","Manager","Accountant","Chef","Hotel Cleaning Staff"});
        comboBox.setBounds(230,150,150,30);
        comboBox.setFont(new Font("Regular",Font.PLAIN,16));
        comboBox.setForeground(Color.WHITE);
        comboBox.setBackground(new Color(148, 212, 229));
        panel.add(comboBox);


        JLabel salary=new JLabel("SALARY");
        salary.setBounds(60,190,150,30);
        salary.setFont(new Font("Regular",Font.BOLD,16));
        salary.setForeground(Color.WHITE);
        panel.add(salary);

        tsalary=new JTextField();
        tsalary.setBounds(230,190,150,27);
        tsalary.setBackground(new Color(148, 212, 229));
        tsalary.setFont(new Font("Regular",Font.BOLD,16));
        tsalary.setForeground(Color.WHITE);
        panel.add(tsalary);

        JLabel phoneNumber=new JLabel("PHONE NUMBER");
        phoneNumber.setBounds(60,230,150,30);
        phoneNumber.setFont(new Font("Regular",Font.BOLD,16));
        phoneNumber.setForeground(Color.WHITE);
        panel.add(phoneNumber);

        tphoneNumber=new JTextField();
        tphoneNumber.setBounds(230,230,150,27);
        tphoneNumber.setBackground(new Color(148, 212, 229));
        tphoneNumber.setFont(new Font("Regular",Font.BOLD,16));
        tphoneNumber.setForeground(Color.WHITE);
        panel.add(tphoneNumber);

        JLabel aadhar=new JLabel("AADHAR NUMBER");
        aadhar.setBounds(60,270,150,30);
        aadhar.setFont(new Font("Regular",Font.BOLD,16));
        aadhar.setForeground(Color.WHITE);
        panel.add(aadhar);

        taadhar=new JTextField();
        taadhar.setBounds(230,270,150,27);
        taadhar.setBackground(new Color(148, 212, 229));
        taadhar.setFont(new Font("Regular",Font.BOLD,16));
        taadhar.setForeground(Color.WHITE);
        panel.add(taadhar);


        JLabel email=new JLabel("EMAIL ID");
        email.setBounds(60,310,150,30);
        email.setFont(new Font("Regular",Font.BOLD,16));
        email.setForeground(Color.WHITE);
        panel.add(email);

        temail=new JTextField();
        temail.setBounds(230,310,150,27);
        temail.setBackground(new Color(148, 212, 229));
        temail.setFont(new Font("Regular",Font.BOLD,16));
        temail.setForeground(Color.WHITE);
        panel.add(temail);




        save=new JButton("SAVE");
        save.setBounds(60,350,140,33);
        save.setFont(new Font("Regular",Font.BOLD,16));
        save.setForeground(Color.WHITE);
        save.setBackground(Color.BLACK);
        panel.add(save);



        back=new JButton("BACK");
        back.setBounds(240,350,140,33);
        back.setFont(new Font("Regular",Font.BOLD,16));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        panel.add(back);

        ImageIcon i11= new ImageIcon(ClassLoader.getSystemResource("icon/addemp.png"));
        Image i2=i11.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(500,60,300,300);
        panel.add(img);

        save.addActionListener(this);
        back.addActionListener(this);






        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setLayout(null);
        setVisible(true);
        setSize(850,500);
        setLocation(60,160);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back)
        {
            setVisible(false);
        }
        else{

            String emp_id=JOptionPane.showInputDialog("Set Employee ID");
            try
            {

                String name=tname.getText();
                String age=tage.getText();
                String gender=Objects.requireNonNull(tgender.getSelectedItem()).toString();
                String job= Objects.requireNonNull(comboBox.getSelectedItem()).toString();
                String salary =tsalary.getText();
                String phone =tphoneNumber.getText();
                String aadhar =taadhar.getText();
                String email=temail.getText();

                jdbcConnection jd=new jdbcConnection();
                String query="insert into employee values('"+emp_id+"','"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+aadhar+"','"+email+"')";
                jd.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee Details Saved Successfully");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
