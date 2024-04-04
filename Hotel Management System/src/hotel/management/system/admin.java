package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class admin extends JFrame {
    admin()
    {
    super("ADMIN PAGE");

        JButton addEmployee=new JButton("Add Employee");
        addEmployee.setBounds(250,150,200,30);
        addEmployee.setBackground(Color.WHITE);
        addEmployee.setForeground(Color.BLACK);
        addEmployee.setFont(new Font("Regular",Font.BOLD,16));
        add(addEmployee);

        addEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    if(e.getSource()==addEmployee)
                    {
                        new AddEmployee();
                    }
                }catch (Exception eE)
                {
                    eE.printStackTrace();
                }

            }
        });


        ImageIcon i12= new ImageIcon(ClassLoader.getSystemResource("icon/employees.png"));
        Image i21=i12.getImage().getScaledInstance(130,130,Image.SCALE_DEFAULT);
        ImageIcon i31= new ImageIcon(i21);
        JLabel im=new JLabel(i31);
        im.setBounds(70,90,130,130);
        add(im);


        JButton addRoom=new JButton("Add Room");
        addRoom.setBounds(250,300,200,30);
        addRoom.setBackground(Color.WHITE);
        addRoom.setForeground(Color.BLACK);
        addRoom.setFont(new Font("Regular",Font.BOLD,16));
        add(addRoom);


        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/room.png"));
        Image i2=i1.getImage().getScaledInstance(130,130,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(70,240,130,130);
        add(image);

        addRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    if(e.getSource()==addRoom)
                    {
                        new AddRoom();
                    }
                }catch (Exception eE)
                {
                    eE.printStackTrace();
                }

            }
        });


        JButton addDriver=new JButton("Add Driver");
        addDriver.setBounds(250,450,200,30);
        addDriver.setBackground(Color.WHITE);
        addDriver.setForeground(Color.BLACK);
        addDriver.setFont(new Font("Regular",Font.BOLD,16));
        add(addDriver);

        addDriver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    if(e.getSource()==addDriver)
                    {
                        new AddDriver();
                    }

                }catch (Exception eE)
                {
                    eE.printStackTrace();
                }

            }
        });


        ImageIcon i= new ImageIcon(ClassLoader.getSystemResource("icon/driver.png"));
        Image ii=i.getImage().getScaledInstance(130,130,Image.SCALE_DEFAULT);
        ImageIcon iii= new ImageIcon(ii);
        JLabel imagei=new JLabel(iii);
        imagei.setBounds(70,390,130,130);
        add(imagei);


        JButton back=new JButton("Back");
        back.setBounds(250,600,95,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Regular",Font.BOLD,16));
        add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    if(e.getSource()==back)
                    {
                        new Home();
                        setVisible(false);
                    }
                }catch (Exception eE)
                {
                    eE.printStackTrace();
                }

            }
        });


        JButton logout=new JButton("Log Out");
        logout.setBounds(350,600,100,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("Regular",Font.BOLD,16));
        add(logout);

        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    if(e.getSource()==logout)
                    {
                        System.exit(0);
                    }
                }catch (Exception eE)
                {
                    eE.printStackTrace();
                }

            }
        });


        ImageIcon logo= new ImageIcon(ClassLoader.getSystemResource("icon/hazbinhotel.gif"));
        Image ilogo=logo.getImage().getScaledInstance(855,685,Image.SCALE_DEFAULT);
        ImageIcon iilogo= new ImageIcon(ilogo);
        JLabel imageLogo=new JLabel(iilogo);
        imageLogo.setBounds(500,0,855,685);
        add(imageLogo);




        setLayout(null);
        setSize(1950,1090);
        setVisible(true);
        setLocation(-10,0);
        getContentPane().setBackground(new Color(58, 1, 37));



    }
    public static void main(String[] args) {
        new admin();
    }
}
