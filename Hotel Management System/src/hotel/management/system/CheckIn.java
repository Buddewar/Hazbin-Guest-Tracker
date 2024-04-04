package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Objects;

public class CheckIn extends JFrame {
    JComboBox c,tgender;
    JTextField tname,tnumber,taddress,tadvance,tdays;
    Choice choice;
    JLabel checkinTime;
    CheckIn()
    {

        setUndecorated(true);
        JPanel p=new JPanel();
        p.setBounds(5,5,890,590);
        p.setBackground(new Color(58, 1, 37));
        p.setLayout(null);
        add(p);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/customer.png"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(620,150,200,200);
        p.add(img);


        JLabel label=new JLabel("CHECK-IN FORM");
        label.setBounds(300,11,260,53);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Regular",Font.BOLD,25));
        p.add(label);


        JLabel name=new JLabel("CUSTOMER NAME");
        name.setBounds(35,75,200,30);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Regular",Font.BOLD,16));
        p.add(name);


        tname=new JTextField();
        tname.setBounds(270,75,150,27);
        tname.setBackground(new Color(148, 212, 229));
        tname.setFont(new Font("Regular",Font.BOLD,16));
        tname.setForeground(Color.WHITE);
        p.add(tname);


        JLabel Gid=new JLabel("GOVERNMENT ID");
        Gid.setBounds(35,115,200,30);
        Gid.setForeground(Color.WHITE);
        Gid.setFont(new Font("Regular",Font.BOLD,16));
        p.add(Gid);

        c=new JComboBox<>(new String[]{"Aadhar ID","Voter ID","Passport","Driving License","Pan Card"});
        c.setBounds(270,115,150,30);
        c.setFont(new Font("Regular",Font.PLAIN,16));
        c.setForeground(Color.WHITE);
        c.setBackground(new Color(148, 212, 229));
        p.add(c);



        JLabel number=new JLabel("ID NUMBER");
        number.setBounds(35,155,200,30);
        number.setForeground(Color.WHITE);
        number.setFont(new Font("Regular",Font.BOLD,16));
        p.add(number);


        tnumber=new JTextField();
        tnumber.setBounds(270,155,150,27);
        tnumber.setBackground(new Color(148, 212, 229));
        tnumber.setFont(new Font("Regular",Font.BOLD,16));
        tnumber.setForeground(Color.WHITE);
        p.add(tnumber);

        JLabel gender=new JLabel("GENDER");
        gender.setBounds(35,195,200,30);
        gender.setForeground(Color.WHITE);
        gender.setFont(new Font("Regular",Font.BOLD,16));
        p.add(gender);


        tgender=new JComboBox<>(new String[]{"Male","Female","Other"});
        tgender.setBounds(270,195,150,27);
        tgender.setFont(new Font("Regular",Font.BOLD,16));
        tgender.setBackground(new Color(148, 212, 229));
        tgender.setForeground(Color.WHITE);
        p.add(tgender);


        JLabel address=new JLabel("ADDRESS");
        address.setBounds(35,235,200,30);
        address.setForeground(Color.WHITE);
        address.setFont(new Font("Regular",Font.BOLD,16));
        p.add(address);


        taddress=new JTextField();
        taddress.setBounds(270,235,150,27);
        taddress.setBackground(new Color(148, 212, 229));
        taddress.setFont(new Font("Regular",Font.BOLD,16));
        taddress.setForeground(Color.WHITE);
        p.add(taddress);


        JLabel allocatedRoom=new JLabel("ALLOCATED ROOM NO");
        allocatedRoom.setBounds(35,275,200,30);
        allocatedRoom.setForeground(Color.WHITE);
        allocatedRoom.setFont(new Font("Regular",Font.BOLD,16));
        p.add(allocatedRoom);


        choice=new Choice();
        try {
            jdbcConnection jdbc=new jdbcConnection();
            String query="Select * from room where avilability='Available'";
            ResultSet rs=jdbc.statement.executeQuery(query);
            while (rs.next())
            {
                choice.add(rs.getString("roomno"));
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        choice.setBounds(270,275,150,20);
        choice.setFont(new Font("Regular",Font.BOLD,16));
        choice.setBackground(new Color(148, 212, 229));
        choice.setForeground(Color.WHITE);
        p.add(choice);


        JLabel checkin=new JLabel("CHECK-IN TIME");
        checkin.setBounds(35,315,200,30);
        checkin.setForeground(Color.WHITE);
        checkin.setFont(new Font("Regular",Font.BOLD,16));
        p.add(checkin);

        Date date=new Date();
        checkinTime=new JLabel(date+"");
        checkinTime.setBounds(270,315,250,30);
        checkinTime.setForeground(Color.WHITE);
        checkinTime.setFont(new Font("Regular",Font.BOLD,16));
        p.add(checkinTime);


        JLabel advance=new JLabel("ADVANCE AMOUNT");
        advance.setBounds(35,355,200,30);
        advance.setForeground(Color.WHITE);
        advance.setFont(new Font("Regular",Font.BOLD,16));
        p.add(advance);


        tadvance=new JTextField();
        tadvance.setBounds(270,355,150,27);
        tadvance.setBackground(new Color(148, 212, 229));
        tadvance.setFont(new Font("Regular",Font.BOLD,16));
        tadvance.setForeground(Color.WHITE);
        p.add(tadvance);



        JLabel days=new JLabel("NUMBER OF DAYS");
        days.setBounds(35,395,200,30);
        days.setForeground(Color.WHITE);
        days.setFont(new Font("Regular",Font.BOLD,16));
        p.add(days);


        tdays=new JTextField();
        tdays.setBounds(270,395,150,27);
        tdays.setBackground(new Color(148, 212, 229));
        tdays.setFont(new Font("Regular",Font.BOLD,16));
        tdays.setForeground(Color.WHITE);
        p.add(tdays);

        JButton save=new JButton("SAVE");
        save.setBounds(35,500,150,30);
        save.setForeground(Color.WHITE);
        save.setBackground(Color.BLACK);
        p.add(save);
        save.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {

                try
                {
                    String name=tname.getText();
                    String id= Objects.requireNonNull(c.getSelectedItem()).toString();
                    String number =tnumber.getText();
                    String gender= Objects.requireNonNull(tgender.getSelectedItem()).toString();
                    String address=taddress.getText();
                    String roomNo =choice.getSelectedItem();
                    String time =checkinTime.getText();
                    String amount=tadvance.getText();
                    String days=tdays.getText();



                    jdbcConnection jd=new jdbcConnection();
                    String query="insert into customer values('"+name+"','"+id+"','"+number+"','"+gender+"','"+address+"','"+roomNo+"','"+time+"','"+amount+"','"+days+"')";
                    String update_roomStatus="update room set avilability='Occupied' where roomno="+roomNo;
                    jd.statement.executeUpdate(query);
                    jd.statement.executeUpdate(update_roomStatus);
                    JOptionPane.showMessageDialog(null,"Customer Details Saved Successfully");
                    setVisible(false);

                }catch (Exception E)
                {
                    E.printStackTrace();
                }
            }
        });



        JButton back=new JButton("BACK");
        back.setBounds(275,500,150,30);
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
        setLocation(230,100);
        setSize(900,600);
        setVisible(true);
    }
    public static void main(String[] args) {
        new CheckIn();
    }
}
