package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheckIn extends JFrame {
    JTextField rno,tname,tcheckin,tamountPaid,tamountDue;
    UpdateCheckIn()
    {
        JPanel p=new JPanel();
        p.setBounds(5,5,990,590);
        p.setBackground(new Color(58, 1, 37));
        p.setLayout(null);
        add(p);


        ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image i= icon.getImage().getScaledInstance(300,300, Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i);
        JLabel image=new JLabel(i2);
        image.setBounds(650,35,300,300);
        p.add(image);

        JLabel label=new JLabel("CHECK-IN DETAILS");
        label.setBounds(300,10,230,30);
        label.setFont(new Font("Regular",Font.BOLD,24));
        label.setForeground(Color.WHITE);
        p.add(label);


        JLabel name=new JLabel("NAME :");
        name.setBounds(20,150,100,20);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("tahoma",Font.BOLD,14));
        p.add(name);


        tname=new JTextField();
        tname.setBounds(250,150,156,20);
        tname.setFont(new Font("Regular",Font.PLAIN,16));
        tname.setForeground(Color.WHITE);
        tname.setBackground(new Color(148, 212, 229));
        p.add(tname);




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



        JLabel checkin=new JLabel("CHECKED-IN TIME :");
        checkin.setBounds(20,250,200,20);
        checkin.setForeground(Color.WHITE);
        checkin.setFont(new Font("tahoma",Font.BOLD,14));
        p.add(checkin);


        tcheckin=new JTextField();
        tcheckin.setBounds(250,250,156,20);
        tcheckin.setFont(new Font("Regular",Font.PLAIN,16));
        tcheckin.setForeground(Color.WHITE);
        tcheckin.setBackground(new Color(148, 212, 229));
        p.add(tcheckin);



        JLabel amountPaid=new JLabel("AMOUNT PAID :");
        amountPaid.setBounds(20,300,200,20);
        amountPaid.setForeground(Color.WHITE);
        amountPaid.setFont(new Font("tahoma",Font.BOLD,14));
        p.add(amountPaid);


        tamountPaid=new JTextField();
        tamountPaid.setBounds(250,300,156,20);
        tamountPaid.setFont(new Font("Regular",Font.PLAIN,16));
        tamountPaid.setForeground(Color.WHITE);
        tamountPaid.setBackground(new Color(148, 212, 229));
        p.add(tamountPaid);



        JLabel amountDue=new JLabel("AMOUNT DUE :");
        amountDue.setBounds(20,350,200,20);
        amountDue.setForeground(Color.WHITE);
        amountDue.setFont(new Font("tahoma",Font.BOLD,14));
        p.add(amountDue);


        tamountDue=new JTextField();
        tamountDue.setBounds(250,350,156,20);
        tamountDue.setFont(new Font("Regular",Font.PLAIN,16));
        tamountDue.setForeground(Color.WHITE);
        tamountDue.setBackground(new Color(148, 212, 229));
        p.add(tamountDue);


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
                    String choicee= choice.getSelectedItem();
                    String name=tname.getText();
                    String rnum=rno.getText();
                    String time=tcheckin.getText();
                    String paid=tamountPaid.getText();

                    jd.statement.executeUpdate("update customer set name='"+name+"',Alloccated_ROOM_NO='"+rnum+"',Check_IN_TIME='"+time+"',Advance='"+paid+"' where ID_NUMBER='"+choicee+"'");
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
                       tname.setText(rs.getString("name"));
                       rno.setText(rs.getString("Alloccated_ROOM_NO"));
                       tcheckin.setText(rs.getString("Check_IN_TIME"));
                       tamountPaid.setText(rs.getString("Advance"));
                   }
                   String query2="select * from room where roomno='"+rno.getText()+"'";
                   ResultSet rss=jdbc.statement.executeQuery(query2);
                   while (rss.next())
                   {
                       String cost=rss.getString("price");
                       int dueAmount=Integer.parseInt(cost)-Integer.parseInt(tamountPaid.getText());
                       tamountDue.setText(""+dueAmount);
                   }
               }catch (Exception ee)
               {
                   ee.printStackTrace();
               }

            }
        });









        setUndecorated(true);
        setLayout(null);
        setSize(1000,600);
        setVisible(true);

        setLocation(200,75);

    }
    public static void main(String[] args) {
        new UpdateCheckIn();
    }
}
