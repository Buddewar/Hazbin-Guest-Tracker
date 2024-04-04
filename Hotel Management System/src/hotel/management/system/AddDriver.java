package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class AddDriver extends JFrame implements ActionListener {
    JTextField tname,tage,tcar,tsalary,tlocation,tphoneNumber;
    JComboBox tgender,tavailable;

    JButton save,back;


    AddDriver()
    {
        JPanel panel =new JPanel();
        panel.setBounds(5,5,840,490);
        panel.setBackground(new Color(58, 1, 37));
        panel.setLayout(null);
        add(panel);

        JLabel l1=new JLabel("ADD DRIVER DETAILS");
        l1.setBounds(194,10,400,22);
        l1.setFont(new Font("Regular",Font.BOLD,22));
        l1.setForeground(Color.WHITE);
        panel.add(l1);

        JLabel name=new JLabel("NAME");
        name.setBounds(60,70,110,30);
        name.setFont(new Font("Regular",Font.BOLD,16));
        name.setForeground(Color.WHITE);
        panel.add(name);

        tname=new JTextField();
        tname.setBounds(250,70,150,30);
        tname.setBackground(new Color(148, 212, 229));
        tname.setFont(new Font("Regular",Font.BOLD,16));
        tname.setForeground(Color.WHITE);
        panel.add(tname);

        JLabel age=new JLabel("AGE");
        age.setBounds(60,110,110,30);
        age.setFont(new Font("Regular",Font.BOLD,16));
        age.setForeground(Color.WHITE);
        panel.add(age);

        tage=new JTextField();
        tage.setBounds(250,110,150,30);
        tage.setBackground(new Color(148, 212, 229));
        tage.setFont(new Font("Regular",Font.BOLD,16));
        tage.setForeground(Color.WHITE);
        panel.add(tage);


        JLabel gender=new JLabel("GENDER");
        gender.setBounds(60,150,150,30);
        gender.setFont(new Font("Regular",Font.BOLD,16));
        gender.setForeground(Color.WHITE);
        panel.add(gender);



        tgender=new JComboBox<>(new String[]{"Male","Female","Other"});
        tgender.setBounds(250,150,150,30);
        tgender.setFont(new Font("Regular",Font.BOLD,16));
        tgender.setBackground(new Color(148, 212, 229));
        tgender.setForeground(Color.WHITE);
        panel.add(tgender);


        JLabel car=new JLabel("CAR MODEL");
        car.setBounds(60,190,150,30);
        car.setFont(new Font("Regular",Font.BOLD,16));
        car.setForeground(Color.WHITE);
        panel.add(car);

        tcar=new JTextField();
        tcar.setBounds(250,190,150,30);
        tcar.setBackground(new Color(148, 212, 229));
        tcar.setFont(new Font("Regular",Font.BOLD,16));
        tcar.setForeground(Color.WHITE);
        panel.add(tcar);


        JLabel carName=new JLabel("SALARY");
        carName.setBounds(60,230,150,30);
        carName.setFont(new Font("Regular",Font.BOLD,16));
        carName.setForeground(Color.WHITE);
        panel.add(carName);

        tsalary=new JTextField();
        tsalary.setBounds(250,230,150,30);
        tsalary.setBackground(new Color(148, 212, 229));
        tsalary.setFont(new Font("Regular",Font.BOLD,16));
        tsalary.setForeground(Color.WHITE);
        panel.add(tsalary);



        JLabel available=new JLabel("AVAILABILITY");
        available.setBounds(60,270,150,30);
        available.setFont(new Font("Regular",Font.BOLD,16));
        available.setForeground(Color.WHITE);
        panel.add(available);



        tavailable=new JComboBox<>(new String[]{"Available","Not Available"});
        tavailable.setBounds(250,270,150,30);
        tavailable.setFont(new Font("Regular",Font.BOLD,16));
        tavailable.setBackground(new Color(148, 212, 229));
        tavailable.setForeground(Color.WHITE);
        panel.add(tavailable);




        JLabel location=new JLabel("LOCATION");
        location.setBounds(60,310,150,30);
        location.setFont(new Font("Regular",Font.BOLD,16));
        location.setForeground(Color.WHITE);
        panel.add(location);

        tlocation=new JTextField();
        tlocation.setBounds(250,310,150,30);
        tlocation.setBackground(new Color(148, 212, 229));
        tlocation.setFont(new Font("Regular",Font.BOLD,16));
        tlocation.setForeground(Color.WHITE);
        panel.add(tlocation);


        JLabel phoneNumber=new JLabel("PHONE NUMBER");
        phoneNumber.setBounds(60,350,150,30);
        phoneNumber.setFont(new Font("Regular",Font.BOLD,16));
        phoneNumber.setForeground(Color.WHITE);
        panel.add(phoneNumber);

        tphoneNumber=new JTextField();
        tphoneNumber.setBounds(250,350,150,27);
        tphoneNumber.setBackground(new Color(148, 212, 229));
        tphoneNumber.setFont(new Font("Regular",Font.BOLD,16));
        tphoneNumber.setForeground(Color.WHITE);
        panel.add(tphoneNumber);





        save=new JButton("SAVE");
        save.setBounds(60,410,160,33);
        save.setFont(new Font("Regular",Font.BOLD,16));
        save.setForeground(Color.WHITE);
        save.setBackground(Color.BLACK);
        panel.add(save);



        back=new JButton("BACK");
        back.setBounds(240,410,160,33);
        back.setFont(new Font("Regular",Font.BOLD,16));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        panel.add(back);

        ImageIcon i11= new ImageIcon(ClassLoader.getSystemResource("icon/license.png"));
        Image i2=i11.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(500,60,300,300);
        panel.add(img);

        save.addActionListener(this);
        back.addActionListener(this);






        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setLayout(null);
        setVisible(true);
        setSize(850,500);
        setLocation(60,160);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back)
        {
            setVisible(false);
        }
        else{

            String driverId=JOptionPane.showInputDialog("Set Driver ID");
            try
            {

                String name=tname.getText();
                String age=tage.getText();
                String gender= Objects.requireNonNull(tgender.getSelectedItem()).toString();
                String company= tcar.getText();
                String salary =tsalary.getText();
                String availability= Objects.requireNonNull(tavailable.getSelectedItem()).toString();
                String location =tlocation.getText();
                String phone =tphoneNumber.getText();


                jdbcConnection jd=new jdbcConnection();
                String query="insert into driver values('"+driverId+"','"+name+"','"+age+"','"+gender+"','"+company+"','"+salary+"','"+availability+"','"+location+"','"+phone+"')";
                jd.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Driver Details Saved Successfully");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new AddDriver();
    }
}
