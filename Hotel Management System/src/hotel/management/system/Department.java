package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame{
    Department()
    {

        JPanel p=new JPanel();
        p.setBounds(5,5,690,490);
        p.setBackground(new Color(58, 1, 37));
        p.setLayout(null);
        add(p);


        JTable table=new JTable();
        table.setBounds(15,60,450,250);
        table.setBackground(new Color(58, 1, 37));
        table.setForeground(Color.WHITE);
        p.add(table);

        JButton back=new JButton("BACK");
        back.setBounds(400,410,120,30);
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
        setUndecorated(true);
        setLayout(null);
        setVisible(true);
        setSize(700,500);
        setLocation(320,150);


        JLabel depart=new JLabel("DEPARTMENT");
        depart.setBounds(60,40,200,14);
        depart.setForeground(Color.WHITE);
        depart.setFont(new Font("Regular",Font.BOLD,16));
        p.add(depart);


        JLabel budget=new JLabel("BUDGET");
        budget.setBounds(300,40,200,14);
        budget.setForeground(Color.WHITE);
        budget.setFont(new Font("Regular",Font.BOLD,16));
        p.add(budget);





        try
        {
            jdbcConnection jdbc=new jdbcConnection();
            String query="select * from department";
            ResultSet rs=jdbc.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e)
        {
            e.printStackTrace();
        }


    }
    public static void main(String[] args) {
        new Department();
    }
}
