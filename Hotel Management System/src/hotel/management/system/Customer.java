package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Customer extends JFrame {
    Customer()
    {
        JPanel p=new JPanel();
        p.setBounds(5,5,990,590);
        p.setBackground(new Color(58, 1, 37));
        p.setLayout(null);
        add(p);


        JTable table=new JTable();
        table.setBounds(15,65,900,400);
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


        JLabel name=new JLabel("Name");
        name.setBounds(18,40,100,20);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("tahoma",Font.BOLD,14));
        p.add(name);

        JLabel id=new JLabel("GOVT ID");
        id.setBounds(125,40,100,20);
        id.setForeground(Color.WHITE);
        id.setFont(new Font("tahoma",Font.BOLD,14));
        p.add(id);





        JLabel number=new JLabel("ID NUMBER");
        number.setBounds(225,40,200,20);
        number.setForeground(Color.WHITE);
        number.setFont(new Font("tahoma",Font.BOLD,14));
        p.add(number);


        JLabel gender=new JLabel("GENDER");
        gender.setBounds(325,40,200,20);
        gender.setForeground(Color.WHITE);
        gender.setFont(new Font("tahoma",Font.BOLD,14));
        p.add(gender);


        JLabel address=new JLabel("ADDRESS");
        address.setBounds(420,40,200,20);
        address.setForeground(Color.WHITE);
        address.setFont(new Font("tahoma",Font.BOLD,14));
        p.add(address);


        JLabel rno=new JLabel("ROOM NO");
        rno.setBounds(525,40,200,20);
        rno.setForeground(Color.WHITE);
        rno.setFont(new Font("tahoma",Font.BOLD,14));
        p.add(rno);


        JLabel date=new JLabel("DATE-TIME");
        date.setBounds(625,40,200,20);
        date.setForeground(Color.WHITE);
        date.setFont(new Font("tahoma",Font.BOLD,14));
        p.add(date);

        JLabel advancePaid=new JLabel("ADVANCE PAID");
        advancePaid.setBounds(720,40,200,20);
        advancePaid.setForeground(Color.WHITE);
        advancePaid.setFont(new Font("tahoma",Font.BOLD,12));
        p.add(advancePaid);


        JLabel No_days=new JLabel("No of Days");
        No_days.setBounds(825,40,200,20);
        No_days.setForeground(Color.WHITE);
        No_days.setFont(new Font("tahoma",Font.BOLD,14));
        p.add(No_days);

        setUndecorated(true);
        setLayout(null);
        setVisible(true);
        setSize(1000,600);
        setLocation(230,100);


        try
        {
            jdbcConnection jdbc=new jdbcConnection();
            String query="select * from customer";
            ResultSet rs=jdbc.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e)
        {
            e.printStackTrace();
        }



    }
    public static void main(String[] args) {
        new Customer();
    }
}
