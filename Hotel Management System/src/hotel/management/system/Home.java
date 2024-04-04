package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {
    JButton admin,reception;
    Home()
    {
        super("Hotel Management System");

        admin=new JButton("Admin");
        admin.setBounds(850,510,200,30);
        admin.setFont(new Font("Regular",Font.BOLD,15));
        admin.setBackground(new Color(0, 140, 255));
        admin.setForeground(Color.WHITE);
        add(admin);


        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/boss.png"));
        Image i2=i1.getImage().getScaledInstance(200,195,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(850,300,200,195);
        add(img);


        reception=new JButton("Reception");
        reception.setBounds(200,510,200,30);
        reception.setFont(new Font("Regular",Font.BOLD,15));
        reception.setBackground(new Color(0, 140, 255));
        reception.setForeground(Color.WHITE);
        add(reception);

        ImageIcon i12= new ImageIcon(ClassLoader.getSystemResource("icon/reception.jpg"));
        Image i21=i12.getImage().getScaledInstance(200,195,Image.SCALE_DEFAULT);
        ImageIcon i31= new ImageIcon(i21);
        JLabel im=new JLabel(i31);
        im.setBounds(200,300,200,195);
        add(im);



        ImageIcon i11= new ImageIcon(ClassLoader.getSystemResource("icon/Dashboard.gif"));
        Image i22=i11.getImage().getScaledInstance(1950,1090,Image.SCALE_DEFAULT);
        ImageIcon i33= new ImageIcon(i22);
        JLabel imgg=new JLabel(i33);
        imgg.setBounds(5,0,1950,1090);
        add(imgg);

        setLayout(null);
        setVisible(true);
        setSize(1950,1090);
        setLocation(-10,0);
        admin.addActionListener(this);
        reception.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==admin)
        {
            new AdminLogin();
            setVisible(false);
        } else{
            new Reception();

        }
    }

    public static void main(String[] args) {
    new Home();
    }
}
