package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.spec.ECField;
import java.sql.ResultSet;

public class PickUp extends JFrame {
    PickUp()
    {
        setUndecorated(true);
        JPanel p=new JPanel();
        p.setBounds(5,5,990,590);
        p.setBackground(new Color(58, 1, 37));
        p.setLayout(null);
        add(p);

        JLabel label=new JLabel("PICK-UP SERVICE");
        label.setBounds(350,10,300,30);
        label.setFont(new Font("Regular",Font.BOLD,24));
        label.setForeground(Color.WHITE);
        p.add(label);



        JLabel carModel=new JLabel("CAR MODEL");
        carModel.setBounds(35,95,100,30);
        carModel.setFont(new Font("Regular",Font.BOLD,16));
        carModel.setForeground(Color.WHITE);
        p.add(carModel);


        Choice choice=new Choice();
        choice.setBounds(155,95,150,30);
        p.add(choice);

        try
        {
            jdbcConnection jdbc=new jdbcConnection();
            String query="select * from driver";
            ResultSet rs=jdbc.statement.executeQuery(query);
            while (rs.next())
            {
                choice.add(rs.getString("car_Model"));
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }



        JTable table=new JTable();
        table.setBounds(20,230,900,250);
        table.setBackground(new Color(58, 1, 37));
        table.setForeground(Color.WHITE);
        p.add(table);


        try
        {
            jdbcConnection jdbc=new jdbcConnection();
            String query="select * from driver";
            ResultSet rs=jdbc.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e)
        {
            e.printStackTrace();
        }


        JLabel driverId=new JLabel("DRIVER ID");
        driverId.setBounds(18,200,100,20);
        driverId.setForeground(Color.WHITE);
        driverId.setFont(new Font("tahoma",Font.BOLD,14));
        p.add(driverId);

        JLabel name=new JLabel("NAME");
        name.setBounds(125,200,100,20);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("tahoma",Font.BOLD,14));
        p.add(name);





        JLabel age=new JLabel("AGE");
        age.setBounds(225,200,200,20);
        age.setForeground(Color.WHITE);
        age.setFont(new Font("tahoma",Font.BOLD,14));
        p.add(age);


        JLabel gender=new JLabel("GENDER");
        gender.setBounds(325,200,200,20);
        gender.setForeground(Color.WHITE);
        gender.setFont(new Font("tahoma",Font.BOLD,14));
        p.add(gender);


        JLabel carmodel=new JLabel("CAR-MODEL");
        carmodel.setBounds(420,200,200,20);
        carmodel.setForeground(Color.WHITE);
        carmodel.setFont(new Font("tahoma",Font.BOLD,14));
        p.add(carmodel);


        JLabel salary=new JLabel("SALARY");
        salary.setBounds(525,200,200,20);
        salary.setForeground(Color.WHITE);
        salary.setFont(new Font("tahoma",Font.BOLD,14));
        p.add(salary);


        JLabel availability=new JLabel("AVAILABILITY");
        availability.setBounds(625,200,200,20);
        availability.setForeground(Color.WHITE);
        availability.setFont(new Font("tahoma",Font.BOLD,13));
        p.add(availability);

        JLabel location=new JLabel("LOCATION");
        location.setBounds(725,200,200,20);
        location.setForeground(Color.WHITE);
        location.setFont(new Font("tahoma",Font.BOLD,12));
        p.add(location);


        JLabel mobileNo=new JLabel("MOBILE NO");
        mobileNo.setBounds(825,200,200,20);
        mobileNo.setForeground(Color.WHITE);
        mobileNo.setFont(new Font("tahoma",Font.BOLD,14));
        p.add(mobileNo);

        JButton Display=new JButton("DISPLAY");
        Display.setBounds(250,500,150,30);
        Display.setForeground(Color.WHITE);
        Display.setBackground(Color.BLACK);
        p.add(Display);
        Display.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    jdbcConnection jd=new jdbcConnection();
                    String query="select * from driver where car_Model='"+choice.getSelectedItem()+"'";
                    ResultSet rs=jd.statement.executeQuery(query);
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                }catch (Exception ee)
                {
                    ee.printStackTrace();
                }


            }
        });

        JButton back=new JButton("BACK");
        back.setBounds(50,500,150,30);
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




        setLayout(null);
        setSize(1000,600);
        setLocation(185,70);
        setVisible(true);
    }
    public static void main(String[] args) {
        new PickUp();
    }
}
