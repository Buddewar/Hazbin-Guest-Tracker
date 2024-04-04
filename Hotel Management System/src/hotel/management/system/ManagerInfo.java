package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ManagerInfo extends JFrame {
    ManagerInfo()
    {
        JPanel p=new JPanel();
        p.setBounds(5,5,990,590);
        p.setBackground(new Color(58, 1, 37));
        p.setLayout(null);
        add(p);


        JTable table=new JTable();
        table.setBounds(15,60,900,400);
        table.setBackground(new Color(58, 1, 37));
        table.setForeground(Color.WHITE);
        p.add(table);

        JButton back=new JButton("BACK");
        back.setBounds(300,500,120,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        p.add(back);
        back.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        JLabel depart=new JLabel("Employee ID");
        depart.setBounds(20,40,100,20);
        depart.setForeground(Color.WHITE);
        depart.setFont(new Font("tahoma",Font.BOLD,14));
        p.add(depart);


        JLabel name=new JLabel("Name");
        name.setBounds(125,40,100,20);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("tahoma",Font.BOLD,14));
        p.add(name);


        JLabel age=new JLabel("Age");
        age.setBounds(225,40,200,20);
        age.setForeground(Color.WHITE);
        age.setFont(new Font("tahoma",Font.BOLD,14));
        p.add(age);


        JLabel gender=new JLabel("Gender");
        gender.setBounds(325,40,200,20);
        gender.setForeground(Color.WHITE);
        gender.setFont(new Font("tahoma",Font.BOLD,14));
        p.add(gender);


        JLabel job=new JLabel("Job");
        job.setBounds(425,40,200,20);
        job.setForeground(Color.WHITE);
        job.setFont(new Font("tahoma",Font.BOLD,14));
        p.add(job);


        JLabel salary=new JLabel("Salary");
        salary.setBounds(525,40,200,20);
        salary.setForeground(Color.WHITE);
        salary.setFont(new Font("tahoma",Font.BOLD,14));
        p.add(salary);


        JLabel phone=new JLabel("Phone No");
        phone.setBounds(625,40,200,20);
        phone.setForeground(Color.WHITE);
        phone.setFont(new Font("tahoma",Font.BOLD,14));
        p.add(phone);

        JLabel aadhar=new JLabel("Aadhar No");
        aadhar.setBounds(725,40,200,20);
        aadhar.setForeground(Color.WHITE);
        aadhar.setFont(new Font("tahoma",Font.BOLD,14));
        p.add(aadhar);


        JLabel mail=new JLabel("Email ID");
        mail.setBounds(825,40,200,20);
        mail.setForeground(Color.WHITE);
        mail.setFont(new Font("tahoma",Font.BOLD,14));
        p.add(mail);

        setUndecorated(true);
        setLayout(null);
        setVisible(true);
        setSize(1000,600);
        setLocation(230,100);


        try
        {
            jdbcConnection jdbc=new jdbcConnection();
            String query="select * from employee where job='Manager'";
            ResultSet rs=jdbc.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e)
        {
            e.printStackTrace();
        }



    }
    public static void main(String[] args) {
        new ManagerInfo();
    }
}
