package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class CheckOut extends JFrame {
    CheckOut()
    {
        setUndecorated(true);


        JPanel p=new JPanel();
        p.setBounds(5,5,790,390);
        p.setBackground(new Color(58, 1, 37));
        p.setLayout(null);
        add(p);


        JLabel label=new JLabel("CHECK-OUT");
        label.setBounds(100,20,150,30);
        label.setFont(new Font("Regular",Font.BOLD,24));
        label.setForeground(Color.WHITE);
        p.add(label);


        JLabel id=new JLabel("Customer ID :");
        id.setBounds(30,80,150,30);
        id.setForeground(Color.WHITE);
        id.setFont(new Font("tahoma",Font.BOLD,16));
        p.add(id);


        Choice cust=new Choice();
        cust.setBounds(200,80,150,30);
        p.add(cust);

        JLabel number=new JLabel("ROOM NUMBER :");
        number.setBounds(30,130,150,30);
        number.setForeground(Color.WHITE);
        number.setFont(new Font("tahoma",Font.BOLD,16));
        p.add(number);

        JLabel tnumber=new JLabel();
        tnumber.setBounds(200,130,150,30);
        tnumber.setForeground(Color.WHITE);
        tnumber.setFont(new Font("tahoma",Font.BOLD,16));
        p.add(tnumber);

        JLabel Checkin=new JLabel("CHECK-IN TIME");
        Checkin.setBounds(30,180,150,30);
        Checkin.setForeground(Color.WHITE);
        Checkin.setFont(new Font("tahoma",Font.BOLD,16));
        p.add(Checkin);


        JLabel tCheckin=new JLabel();
        tCheckin.setBounds(200,180,250,30);
        tCheckin.setForeground(Color.WHITE);
        tCheckin.setFont(new Font("tahoma",Font.BOLD,16));
        p.add(tCheckin);


        JLabel checkOut=new JLabel("CHECK-OUT TIME");
        checkOut.setBounds(30,230,150,30);
        checkOut.setForeground(Color.WHITE);
        checkOut.setFont(new Font("tahoma",Font.BOLD,16));
        p.add(checkOut);


        Date date=new Date();
        JLabel tcheckOut=new JLabel(""+date);
        tcheckOut.setBounds(200,230,250,30);
        tcheckOut.setForeground(Color.WHITE);
        tcheckOut.setFont(new Font("tahoma",Font.BOLD,16));
        p.add(tcheckOut);


        try
        {
            jdbcConnection jdbc=new jdbcConnection();
            ResultSet rs=jdbc.statement.executeQuery("select * from customer");
            while (rs.next())
            {
                cust.add(rs.getString("ID_NUMBER"));
            }
        }catch (Exception E)
        {
            E.printStackTrace();
        }
        JButton Out=new JButton("CHECK-OUT");
        Out.setBounds(30,300,120,30);
        Out.setForeground(Color.WHITE);
        Out.setBackground(Color.BLACK);
        p.add(Out);
        Out.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    jdbcConnection jd=new jdbcConnection();
                    String query="delete from customer where ID_NUMBER='"+cust.getSelectedItem()+"'";
                    jd.statement.executeUpdate(query);

                    String query1="update room set avilability='Available' where roomno='"+tnumber.getText()+"'";
                    jd.statement.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null,"Checked-Out Successfully");
                    setVisible(false);

                }catch (Exception ee)
                {
                    ee.printStackTrace();
                }


            }
        });


        JButton back=new JButton("BACK");
        back.setBounds(170,300,120,30);
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


        JButton status=new JButton("CHECK-STATUS");
        status.setBounds(300,300,130,30);
        status.setForeground(Color.WHITE);
        status.setBackground(Color.BLACK);
        p.add(status);
        status.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=cust.getSelectedItem();
                String query="select * from customer where ID_NUMBER='"+id+"'";
                try
                {
                    jdbcConnection jdbc=new jdbcConnection();
                    ResultSet rs=jdbc.statement.executeQuery(query);
                    while(rs.next()) {
                        tnumber.setText(rs.getString("Alloccated_ROOM_NO"));
                        tCheckin.setText(rs.getString("Check_IN_TIME"));


                    }
                }catch (Exception ee)
                {
                    ee.printStackTrace();
                }

            }
        });













        setLayout(null);
        setVisible(true);
        setSize(800,400);
        setLocation(210,80);
    }
    public static void main(String[] args) {
        new CheckOut();
    }
}

