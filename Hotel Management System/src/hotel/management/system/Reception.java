package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {
    Reception()
    {
        super("Reception Page");
        JPanel panel =new JPanel();
        panel.setLayout(null);
        panel.setBounds(280,5,1238,820);
        panel.setBackground(new Color(58, 1, 37));
        add(panel);

        ImageIcon i12= new ImageIcon(ClassLoader.getSystemResource("icon/Reception.png"));
        Image i21=i12.getImage().getScaledInstance(1238,820,Image.SCALE_DEFAULT);
        ImageIcon i31= new ImageIcon(i21);
        JLabel im=new JLabel(i31);
        im.setBounds(0,0,1238,820);
        panel.add(im);



        JPanel panel1 =new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(0,5,270,820);
        panel1.setBackground(new Color(58, 1, 37));
        add(panel1);


        ImageIcon i11= new ImageIcon(ClassLoader.getSystemResource("icon/hazbinhotel.gif"));
        Image i2=i11.getImage().getScaledInstance(280,235,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(0,0,280,235);
        panel1.add(img);

        JButton customerForm=new JButton("New Customer Form");
        customerForm.setBounds(35,240,200,30);
        customerForm.setBackground(Color.BLACK);
        customerForm.setForeground(Color.WHITE);
        panel1.add(customerForm);

        customerForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    new CheckIn();
                }catch (Exception eE)
                {
                    eE.printStackTrace();
                }

            }
        });


        JButton room=new JButton("Room Details");
        room.setBounds(35,280,200,30);
        room.setBackground(Color.BLACK);
        room.setForeground(Color.WHITE);
        panel1.add(room);

        room.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    new Room();

                }catch (Exception eE)
                {
                    eE.printStackTrace();
                }

            }
        });


        JButton department=new JButton("Department");
        department.setBounds(35,320,200,30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        panel1.add(department);

        department.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    new Department();
                }catch (Exception eE)
                {
                    eE.printStackTrace();
                }

            }
        });



        JButton allemp=new JButton("All Employee");
        allemp.setBounds(35,360,200,30);
        allemp.setBackground(Color.BLACK);
        allemp.setForeground(Color.WHITE);
        panel1.add(allemp);

        allemp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    new Employee();
                }catch (Exception eE)
                {
                    eE.printStackTrace();
                }

            }
        });


        JButton custInfo=new JButton("Customer Information");
        custInfo.setBounds(35,400,200,30);
        custInfo.setBackground(Color.BLACK);
        custInfo.setForeground(Color.WHITE);
        panel1.add(custInfo);

        custInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    new Customer();
                }catch (Exception eE)
                {
                    eE.printStackTrace();
                }

            }
        });


        JButton managerInfo=new JButton("Manager Information");
        managerInfo.setBounds(35,440,200,30);
        managerInfo.setBackground(Color.BLACK);
        managerInfo.setForeground(Color.WHITE);
        panel1.add(managerInfo);

        managerInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    new ManagerInfo();
                }catch (Exception eE)
                {
                    eE.printStackTrace();
                }

            }
        });

        JButton checkout=new JButton("Check Out");
        checkout.setBounds(35,480,200,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        panel1.add(checkout);

        checkout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    new CheckOut();

                }catch (Exception eE)
                {
                    eE.printStackTrace();
                }

            }
        });


        JButton updateCI=new JButton("Update Check-In Details");
        updateCI.setBounds(35,520,200,30);
        updateCI.setBackground(Color.BLACK);
        updateCI.setForeground(Color.WHITE);
        panel1.add(updateCI);

        updateCI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    new UpdateCheckIn();
                }catch (Exception eE)
                {
                    eE.printStackTrace();
                }

            }
        });



        JButton updateRS=new JButton("Update Room Status");
        updateRS.setBounds(35,560,200,30);
        updateRS.setBackground(Color.BLACK);
        updateRS.setForeground(Color.WHITE);
        panel1.add(updateRS);

        updateRS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    new RoomUpdate();
                }catch (Exception eE)
                {
                    eE.printStackTrace();
                }

            }
        });

        JButton pickup=new JButton("Pick-up Service");
        pickup.setBounds(35,600,200,30);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        panel1.add(pickup);

        pickup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    new PickUp();
                }catch (Exception eE)
                {
                    eE.printStackTrace();
                }

            }
        });


        JButton SearchR=new JButton("Search Room");
        SearchR.setBounds(35,640,200,30);
        SearchR.setBackground(Color.BLACK);
        SearchR.setForeground(Color.WHITE);
        panel1.add(SearchR);

        SearchR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    new SearchRoom();
                }catch (Exception eE)
                {
                    eE.printStackTrace();
                }

            }
        });









        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(1950,740);
        setVisible(true);
        setLocation(-10,0);


    }
    public static void main(String[] args) {
        new Reception();
    }

}
