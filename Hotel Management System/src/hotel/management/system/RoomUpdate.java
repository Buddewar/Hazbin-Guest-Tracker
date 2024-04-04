package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class RoomUpdate extends JFrame {
    JTextField rno,tname,tclean,tavailability;
    RoomUpdate()
    {
        JPanel p=new JPanel();
        p.setBounds(5,5,990,590);
        p.setBackground(new Color(58, 1, 37));
        p.setLayout(null);
        add(p);


        ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("icon/update.png"));
        Image i= icon.getImage().getScaledInstance(300,300, Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i);
        JLabel image=new JLabel(i2);
        image.setBounds(650,35,300,300);
        p.add(image);

        JLabel label=new JLabel("UPDATE STATUS OF ROOM");
        label.setBounds(250,10,350,30);
        label.setFont(new Font("Regular",Font.BOLD,24));
        label.setForeground(Color.WHITE);
        p.add(label);


        JLabel availability=new JLabel("AVAILABILITY :");
        availability.setBounds(20,150,151,20);
        availability.setForeground(Color.WHITE);
        availability.setFont(new Font("tahoma",Font.BOLD,14));
        p.add(availability);


        tavailability=new JTextField();
        tavailability.setBounds(250,150,156,20);
        tavailability.setFont(new Font("Regular",Font.PLAIN,16));
        tavailability.setForeground(Color.WHITE);
        tavailability.setBackground(new Color(148, 212, 229));
        p.add(tavailability);




        JLabel id=new JLabel("ID NUMBER :");
        id.setBounds(20,100,100,20);
        id.setForeground(Color.WHITE);
        id.setFont(new Font("tahoma",Font.BOLD,14));
        p.add(id);

        Choice choice=new Choice();
        choice.setBounds(250,100,156,20);
        choice.setBackground(new Color(148, 212, 229));
        p.add(choice);

        try
        {
            jdbcConnection jdbc=new jdbcConnection();
            String query="select * from customer";
            ResultSet rs=jdbc.statement.executeQuery(query);
            while(rs.next())
            {
                choice.add(rs.getString("ID_NUMBER"));
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }





        JLabel number=new JLabel("ROOM NO :");
        number.setBounds(20,200,200,20);
        number.setForeground(Color.WHITE);
        number.setFont(new Font("tahoma",Font.BOLD,14));
        p.add(number);


        rno=new JTextField();
        rno.setBounds(250,200,156,20);
        rno.setFont(new Font("Regular",Font.PLAIN,16));
        rno.setForeground(Color.WHITE);
        rno.setBackground(new Color(148, 212, 229));
        p.add(rno);



        JLabel clean=new JLabel("CLEANING STATUS :");
        clean.setBounds(20,250,200,20);
        clean.setForeground(Color.WHITE);
        clean.setFont(new Font("tahoma",Font.BOLD,14));
        p.add(clean);


        tclean=new JTextField();
        tclean.setBounds(250,250,156,20);
        tclean.setFont(new Font("Regular",Font.PLAIN,16));
        tclean.setForeground(Color.WHITE);
        tclean.setBackground(new Color(148, 212, 229));
        p.add(tclean);






        JButton update=new JButton("UPDATE");
        update.setBounds(220,415,150,30);
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        p.add(update);
        update.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    jdbcConnection jd=new jdbcConnection();
                    String status=tclean.getText();
                    String avail=tavailability.getText();
                    String query="update room set cleaning_status='"+status+"' where roomno="+rno.getText();
                    jd.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Updated Successfully");





                }catch (Exception ee)
                {
                    ee.printStackTrace();
                }


            }
        });


        JButton back=new JButton("BACK");
        back.setBounds(20,415,150,30);
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


        JButton checkIn=new JButton("CHECK-IN");
        checkIn.setBounds(420,415,150,30);
        checkIn.setForeground(Color.WHITE);
        checkIn.setBackground(Color.BLACK);
        p.add(checkIn);
        checkIn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=choice.getSelectedItem();
                String query="select * from customer where ID_NUMBER='"+id+"'";
                try
                {
                    jdbcConnection jdbc=new jdbcConnection();
                    ResultSet rs=jdbc.statement.executeQuery(query);
                    while(rs.next())
                    {
                        rno.setText(rs.getString("Alloccated_ROOM_NO"));

                    }
                    String query2="select * from room where roomno='"+rno.getText()+"'";
                    ResultSet rss=jdbc.statement.executeQuery(query2);
                    while (rss.next())
                    {
                        tavailability.setText(rss.getString("avilability"));
                        tclean.setText(rss.getString("cleaning_status"));

                    }
                }catch (Exception ee)
                {
                    ee.printStackTrace();
                }

            }
        });









        setUndecorated(true);
        setLayout(null);
        setSize(1000,500);
        setVisible(true);

        setLocation(200,75);
    }

    public static void main(String[] args) {
        new RoomUpdate();
    }
}
